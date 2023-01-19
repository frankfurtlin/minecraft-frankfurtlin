package com.frankfurtlin.frankfurtlinmod.mixin.enchantment;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.InfinityEnchantment;
import net.minecraft.enchantment.MendingEnchantment;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(InfinityEnchantment.class)
public class InfinityEnchantmentMixin extends Enchantment{
    protected InfinityEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    /**
     * @author frankfurtlin
     * @reason 无限可与经验修补同时存在
     */
    @Overwrite
    public boolean canAccept(Enchantment other) {
        if (!ModConfig.INSTANCE.removeInfinityEnchantmentConflict && other instanceof MendingEnchantment) {
            return false;
        }
        return super.canAccept(other);
    }
}
