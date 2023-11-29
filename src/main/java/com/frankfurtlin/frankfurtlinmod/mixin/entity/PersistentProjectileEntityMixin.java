package com.frankfurtlin.frankfurtlinmod.mixin.entity;

import com.frankfurtlin.frankfurtlinmod.enchantment.ModEnchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/28 16:14
 */
@Mixin(PersistentProjectileEntity.class)
public abstract class PersistentProjectileEntityMixin extends ProjectileEntity {
    public PersistentProjectileEntityMixin(EntityType<? extends ProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract void setVelocity(double x, double y, double z, float speed, float divergence);

    /**
     * 强力反弹附魔
     * @param hit hit
     * @param ci ci
     */
    @Inject(method = "onEntityHit", at = @At(
        value = "INVOKE",
        target = "Lnet/minecraft/entity/Entity;setFireTicks(I)V",
        shift = At.Shift.AFTER
    ))
    private void beforeProjectileReflected(EntityHitResult hit, CallbackInfo ci){
        if(!(hit.getEntity() instanceof LivingEntity living))
            return;

        int level = EnchantmentHelper.getEquipmentLevel(ModEnchantments.REFLECTION, living);
        if(level == 0){
            return;
        }

        float norm = level * 3F;
        this.setVelocity(this.getVelocity().multiply(norm));
    }
}
