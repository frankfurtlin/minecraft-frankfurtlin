package com.frankfurtlin.frankfurtlinmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.world.World;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/29 11:00
 * 生命偷取附魔
 */
public class LifeStealEnchantment extends Enchantment {
    public LifeStealEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinPower(int level) {
        return 5 * level;
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 15;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        World world = user.getWorld();
        if (!world.isClient()) {
            if (user.getHealth() < 20 && (Math.random() < 0.10 + (level * 0.20))
                && target instanceof LivingEntity targetLivingEntity) {
                float targetHealth = ((LivingEntity) target).getHealth();
                if (targetHealth > 0) {
                    target.damage(targetLivingEntity.getRecentDamageSource(), Math.max(targetHealth * 0.5f, 10f));
                    user.heal(Math.max(targetHealth * 0.3f, 6f));
                }
            }
        }
        super.onTargetDamaged(user, target, level);
    }
}