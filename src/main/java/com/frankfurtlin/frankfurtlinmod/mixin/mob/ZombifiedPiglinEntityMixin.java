package com.frankfurtlin.frankfurtlinmod.mixin.mob;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ZombifiedPiglinEntity.class)
public class ZombifiedPiglinEntityMixin extends MobEntity {
    protected ZombifiedPiglinEntityMixin(EntityType<? extends MobEntity> entityType, World world) {
        super(entityType, world);
    }

    // 僵尸猪灵武器掉落率0，即不掉落金剑
    @Inject(method = "<init>(Lnet/minecraft/entity/EntityType;Lnet/minecraft/world/World;)V", at = @At("TAIL"))
    public void handDropChancesInject(EntityType<? extends ZombifiedPiglinEntity> entityType, World world, CallbackInfo ci){
        if(ModConfig.INSTANCE.zombifiedPiglinLootTableOptimize){
            this.setEquipmentDropChance(EquipmentSlot.MAINHAND, 0);
        }
    }
}
