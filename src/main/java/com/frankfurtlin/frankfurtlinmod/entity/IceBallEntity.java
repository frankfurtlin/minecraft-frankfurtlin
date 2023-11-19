package com.frankfurtlin.frankfurtlinmod.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.BlazeEntity;
import net.minecraft.entity.projectile.thrown.SnowballEntity;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

import java.util.function.Consumer;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/18 21:49
 */
public class IceBallEntity extends SnowballEntity {
    private final int damage;
    private final Consumer<IceBallEntity> onCollide;

    public IceBallEntity(World world, LivingEntity owner, int damage, Consumer<IceBallEntity> onCollide) {
        super(world, owner);
        this.damage = damage;
        this.onCollide = onCollide;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        int i = entity instanceof BlazeEntity ? damage * 2 : damage;
        entity.damage(entity.getWorld().getDamageSources().thrown(this, this.getOwner()), (float)i);
        ((LivingEntity)entity).addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100 * damage), this);
        entity.setFrozenTicks(140 + 40 * damage);
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        onCollide.accept(this);
        super.onCollision(hitResult);
    }
}
