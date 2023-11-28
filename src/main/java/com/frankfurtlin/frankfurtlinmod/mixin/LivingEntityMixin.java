package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import com.frankfurtlin.frankfurtlinmod.enchantment.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.function.Consumer;


/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/22 22:51
 */
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Shadow protected int playerHitTimer;

    @Shadow @Nullable protected PlayerEntity attackingPlayer;

    @Shadow protected abstract float getJumpVelocity();

    /**
     * 不死图腾可以在背包里面生效
     * @param livingEntity 实体
     * @param hand 手
     * @return 背包里面的不死图腾物品
     */
    @Redirect(method = "tryUseTotem", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/entity/LivingEntity;getStackInHand(Lnet/minecraft/util/Hand;)Lnet/minecraft/item/ItemStack;"))
    private ItemStack getStackInHandInTryUseTotem(LivingEntity livingEntity, Hand hand) {
        if(ModConfig.INSTANCE.useTotemOFUndyingInInventory){
            if (livingEntity instanceof PlayerEntity) {
                for (int i = 0; i < ((PlayerEntity) livingEntity).getInventory().size(); i++) {
                    ItemStack itemStack = ((PlayerEntity) livingEntity).getInventory().getStack(i);
                    if(itemStack.isOf(Items.TOTEM_OF_UNDYING)){
                        return itemStack;
                    }
                }
            }
            return livingEntity.getMainHandStack();
        }
        else{
            if (hand == Hand.MAIN_HAND) {
                return livingEntity.getEquippedStack(EquipmentSlot.MAINHAND);
            }
            if (hand == Hand.OFF_HAND) {
                return livingEntity.getEquippedStack(EquipmentSlot.OFFHAND);
            }
            throw new IllegalArgumentException("Invalid hand " + hand);
        }
    }

    /**
     * 燕归巢附魔对掉落物
     * @param instance instance
     * @param parameters parameters
     * @param seed seed
     * @param lootConsumer lootConsumer
     */
    @Redirect(method = "dropLoot", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/loot/LootTable;generateLoot(Lnet/minecraft/loot/context/LootContextParameterSet;JLjava/util/function/Consumer;)V"))
    private void whereToDropLoot(LootTable instance, LootContextParameterSet parameters, long seed, Consumer<ItemStack> lootConsumer){
        instance.generateLoot(parameters, seed, this::changeDropStack);
    }

    @Unique
    private void changeDropStack(ItemStack stack){
        if (stack.isEmpty()) {
            return;
        }
        if (this.getWorld().isClient) {
            return;
        }
        ItemStack mainHandStack = null;
        PlayerEntity attackingPlayer = this.attackingPlayer;
        if(attackingPlayer != null) mainHandStack = attackingPlayer.getMainHandStack();

        ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), stack);

        itemEntity.setToDefaultPickupDelay();
        this.getWorld().spawnEntity(itemEntity);

        if(this.playerHitTimer > 0 && attackingPlayer != null
            && EnchantmentHelper.getLevel(ModEnchantments.DROP_ON_PLAYER, mainHandStack) > 0){
            itemEntity.setPosition(attackingPlayer.getPos());
            this.getWorld().playSound(null, this.getX(), this.getY(), this.getZ(),
                SoundEvents.ITEM_CHORUS_FRUIT_TELEPORT, SoundCategory.AMBIENT, 0.8F, 1.1f);
        }
    }

    /**
     * 燕归巢附魔对经验掉落
     * @param world world
     * @param pos pos
     * @param amount amount
     */
    @Redirect(method = "dropXp", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/entity/ExperienceOrbEntity;spawn(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/util/math/Vec3d;I)V"))
    private void whereToDropXp(ServerWorld world, Vec3d pos, int amount){
        ItemStack mainHandStack = null;
        PlayerEntity attackingPlayer = this.attackingPlayer;
        if(attackingPlayer != null) mainHandStack = attackingPlayer.getMainHandStack();

        if(this.playerHitTimer > 0 && attackingPlayer != null
            && EnchantmentHelper.getLevel(ModEnchantments.DROP_ON_PLAYER, mainHandStack) > 0){
            ExperienceOrbEntity.spawn(world, attackingPlayer.getPos(), amount);
        }
        else{
            ExperienceOrbEntity.spawn(world, pos, amount);
        }
    }

    /**
     * @author frankfurtlin
     * @reason 弹跳附魔重塑
     */
    @Overwrite
    public void jump() {
        Vec3d vec3d = this.getVelocity();
        this.setVelocity(vec3d.x, this.getJumpVelocity(), vec3d.z);

        int level = 1;
        if((Entity)this instanceof LivingEntity entity){
            level = EnchantmentHelper.getEquipmentLevel(ModEnchantments.BOOST_JUMP, entity);
        }

        if (this.isSprinting()) {
            float f = this.getYaw() * ((float) Math.PI / 180);
            this.setVelocity(this.getVelocity().add(-MathHelper.sin(f) * level * 0.2f,
                level * 0.1f, MathHelper.cos(f) * level * 0.2f));
        }
        this.velocityDirty = true;
    }

    /**
     * 轻功水上漂附魔
     * @param state state
     * @param cir cir
     */
    @Inject(method = "canWalkOnFluid", at = @At("HEAD"), cancellable = true)
    private void walkOnFluidEnchantment(FluidState state, CallbackInfoReturnable<Boolean> cir){
        if((Entity)this instanceof LivingEntity entity){
            int level = EnchantmentHelper.getEquipmentLevel(ModEnchantments.WALK_ON_FLUID, entity);
            if(level > 0){
                cir.setReturnValue(true);
            }
        }
    }

}
