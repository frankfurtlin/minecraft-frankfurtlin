package com.frankfurtlin.frankfurtlinmod.mixin.mob;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WitherSkeletonEntity.class)
public class WitherSkeletonEntityMixin extends MobEntity {
    protected WitherSkeletonEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    // 凋零骷髅武器掉落率0，即不掉落石剑
    @Inject(method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V", at = @At("TAIL"))
    public void handDropChancesInject(EntityType<? extends WitherSkeletonEntity> entityType, World world, CallbackInfo ci){
        if(ModConfig.INSTANCE.witherSkeletonLootTableOptimize){
            this.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0);
        }

    }
}
