package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.enchantment.ModEnchantments;
import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.List;


@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    /**
     * 每随机刻检测玩家装备盔甲并给予相应的效果
     * 白金头盔 潮涌核心 荧光
     * 白金胸甲 抗性提升 荧光
     * 白金护腿 抗性提升 荧光
     * 白金战靴 跳跃提升 速度提升 荧光
     * @param ci CallbackInfo
     */
    @Inject(method = "updateTurtleHelmet()V", at = @At("TAIL"))
    public void updateWhiteGoldArmorInject(CallbackInfo ci) {

        ItemStack itemStackHelmet = this.getEquippedStack(EquipmentSlot.HEAD);
        if(itemStackHelmet.isOf(ModItems.WHITE_GOLD_HELMET)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 200, 0, false, false, false));
        }

        ItemStack itemStackChestplate = this.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack itemStackLeggings = this.getEquippedStack(EquipmentSlot.LEGS);
        if(itemStackChestplate.isOf(ModItems.WHITE_GOLD_CHESTPLATE) || itemStackLeggings.isOf(ModItems.WHITE_GOLD_LEGGINGS)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0, false, false, false));
        }

        ItemStack itemStackBoots = this.getEquippedStack(EquipmentSlot.FEET);
        if(itemStackBoots.isOf(ModItems.WHITE_GOLD_BOOTS)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 0, false, false, false));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0, false, false, false));
        }

        if(itemStackHelmet.isOf(ModItems.WHITE_GOLD_HELMET) || itemStackChestplate.isOf(ModItems.WHITE_GOLD_CHESTPLATE) ||
                itemStackLeggings.isOf(ModItems.WHITE_GOLD_LEGGINGS) || itemStackBoots.isOf(ModItems.WHITE_GOLD_BOOTS)){
            //this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false, false));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0, false, false, false));
        }
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void attractionEnchantment(CallbackInfo ci) {
        ItemStack itemStackChestplate = this.getEquippedStack(EquipmentSlot.CHEST);
        if(EnchantmentHelper.getLevel(ModEnchantments.ATTRACTION, itemStackChestplate) > 0){
            // Computing the attraction radius
            int radius = 10;
            Box box = Box.from(this.getPos()).expand(radius);

            // Getting item and experience orb entities to attract them toward the player
            List<Entity> entities = new ArrayList<>();
            entities.addAll(this.getWorld().getEntitiesByType(EntityType.ITEM, box, item -> true));
            entities.addAll(this.getWorld().getEntitiesByType(EntityType.EXPERIENCE_ORB, box, item -> true));

            // Attracting the entities toward the player
            entities.forEach(item ->
            {
                // Moving entity and updating on client
                Vec3d vec = this.getPos().subtract(item.getPos()).normalize();
                Vec3d delta = item.getVelocity();
                item.setVelocity(delta.add(vec.multiply(0.2F)));
                item.velocityModified = true;
            });
        }
    }
}
