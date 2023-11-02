package com.frankfurtlin.frankfurtlinmod.mixin.mob;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.DrownedEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// 溺尸 mixin
@Mixin(DrownedEntity.class)
public class DrownedEntityMixin extends MobEntity {

    protected DrownedEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V", at= @At("TAIL"))
    private void handDropChancesInject(EntityType<? extends DrownedEntity> entityType, World world, CallbackInfo ci){
        if(ModConfig.INSTANCE.drownedAlwaysDropWeapon){
            this.setEquipmentDropChance(EquipmentSlot.MAINHAND, 1);
        }
    }

    /**
     * 修改溺尸在河流生物群系生成概率
     * @param rate 概率
     * @return ModConfig.INSTANCE.drownedSpawnInRiverRate
     */
    @ModifyConstant(method = "canSpawn(Lnet/minecraft/entity/EntityType;" +
            "Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/entity/SpawnReason;" +
            "Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/random/Random;)Z",
            constant = @Constant(intValue = 15), require = 0)
    private static int changeSpawnRateInRiver(int rate){
        return ModConfig.INSTANCE.drownedSpawnInRiverRate;
    }

    /**
     * 修改溺尸在海洋生物群系生成概率
     * @param rate 概率
     * @return ModConfig.INSTANCE.drownedSpawnInOceanRate
     */
    @ModifyConstant(method = "canSpawn(Lnet/minecraft/entity/EntityType;" +
            "Lnet/minecraft/world/ServerWorldAccess;Lnet/minecraft/entity/SpawnReason;" +
            "Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/random/Random;)Z",
            constant = @Constant(intValue = 40), require = 0)
    private static int changeSpawnRateInOcean(int rate){
        return ModConfig.INSTANCE.drownedSpawnInOceanRate;
    }


    /**
     * 原始溺尸带武器的概率为 1/10，带武器 5/8 为三叉戟、3/8 为钓鱼竿
     * @return ModConfig.INSTANCE.drownedSpawnWithEquipment
     */
    @ModifyConstant(method = "initEquipment", constant = @Constant(doubleValue = 0.9), require = 0)
    private double changeSpawnWithWeaponRate(double rate){
        return 1 - ModConfig.INSTANCE.drownedSpawnWithEquipment;
    }


}
