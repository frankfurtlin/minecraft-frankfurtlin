package com.frankfurtlin.frankfurtlinmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/28 14:46
 * 轻功水上漂附魔
 */
public class WalkOnFluidEnchantment extends Enchantment {
    protected WalkOnFluidEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
    }

    @Override
    public int getMinPower(int level) {
        return 15;
    }

    @Override
    public int getMaxPower(int level) {
        return super.getMinPower(level) + 50;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    protected boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != Enchantments.DEPTH_STRIDER && other != Enchantments.FROST_WALKER;
    }
}
