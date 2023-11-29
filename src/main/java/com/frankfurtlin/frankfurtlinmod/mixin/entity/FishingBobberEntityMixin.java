package com.frankfurtlin.frankfurtlinmod.mixin.entity;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ExperienceOrbEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberEntityMixin extends ProjectileEntity {
    @Shadow
    private boolean caughtFish;

    public FishingBobberEntityMixin(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract @Nullable PlayerEntity getPlayerOwner();


    @Shadow @Final private int luckOfTheSeaLevel;

    /**
     * 钓到鱼时自动收杆放杆
     * @param data TrackedData
     * @param ci CallbackInfo
     * @throws InterruptedException 中断异常
     */
    @Inject(at = @At("TAIL"), method = "onTrackedDataSet")
    public void onTrackedDataSet(TrackedData<?> data, CallbackInfo ci) throws InterruptedException {
        PlayerEntity owner = this.getPlayerOwner();

        if(owner == null || !owner.getWorld().isClient()){
            return;
        }


        MinecraftClient client = MinecraftClient.getInstance();

        if(client.player != owner){
            return;
        }

        if (caughtFish && ModConfig.INSTANCE.autoFish) {
            if (client.interactionManager != null) {
                client.interactionManager.interactItem(owner, Hand.MAIN_HAND);
            }
            Thread.sleep(30L);
            if (client.interactionManager != null) {
                client.interactionManager.interactItem(owner, Hand.MAIN_HAND);
            }
        }
    }

    @Inject(method = "tickFishingLogic", at = @At("HEAD"))
    private void buffFishing(BlockPos pos, CallbackInfo ci){
        PlayerEntity playerEntity = this.getPlayerOwner();
        if(playerEntity != null){
            ItemStack itemStack = playerEntity.getStackInHand(Hand.MAIN_HAND);
            if(ModConfig.INSTANCE.buffFish){
                LootContextParameterSet lootContextParameterSet = new LootContextParameterSet.Builder((ServerWorld)this.getWorld())
                    .add(LootContextParameters.ORIGIN, this.getPos()).add(LootContextParameters.TOOL, itemStack)
                    .add(LootContextParameters.THIS_ENTITY, this).luck((float)luckOfTheSeaLevel + playerEntity.getLuck()).build(LootContextTypes.FISHING);
                if(this.getWorld().getServer() != null){
                    LootTable lootTable = this.getWorld().getServer().getLootManager().getLootTable(LootTables.FISHING_GAMEPLAY);
                    ObjectArrayList<ItemStack> list = lootTable.generateLoot(lootContextParameterSet);
                    Criteria.FISHING_ROD_HOOKED.trigger((ServerPlayerEntity)playerEntity, itemStack, this.getPlayerOwner().fishHook, list);
                    for (ItemStack itemStack1 : list) {
                        if(ModConfig.INSTANCE.buffFishOnlyEnchantedBook && !itemStack1.isOf(Items.ENCHANTED_BOOK)){
                            continue;
                        }
                        ItemEntity itemEntity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), itemStack1);
                        double d = playerEntity.getX() - this.getX();
                        double e = playerEntity.getY() - this.getY();
                        double f = playerEntity.getZ() - this.getZ();
                        itemEntity.setVelocity(d * 0.1, e * 0.1 + Math.sqrt(Math.sqrt(d * d + e * e + f * f)) * 0.08, f * 0.1);
                        this.getWorld().spawnEntity(itemEntity);
                        playerEntity.getWorld().spawnEntity(new ExperienceOrbEntity(playerEntity.getWorld(),
                            playerEntity.getX(), playerEntity.getY() + 0.5, playerEntity.getZ() + 0.5, this.random.nextInt(6) + 1));
                        if (!itemStack1.isIn(ItemTags.FISHES)) continue;
                        playerEntity.increaseStat(Stats.FISH_CAUGHT, 1);
                    }
                }

            }
        }

    }

}
