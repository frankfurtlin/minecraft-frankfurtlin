package com.frankfurtlin.frankfurtlinmod.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/22 8:28
 * 燕归巢附魔，掉落物在玩家附近
 * 可以附魔在剑、弓、弩
 */
public class DropOnPlayerEnchantment extends Enchantment {
    protected DropOnPlayerEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.BREAKABLE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
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
    public boolean isAcceptableItem(ItemStack stack) {
        return stack.getItem() instanceof SwordItem ||
            stack.getItem() instanceof TridentItem ||
            stack.getItem() instanceof BowItem ||
            stack.getItem() instanceof CrossbowItem;
    }
}
