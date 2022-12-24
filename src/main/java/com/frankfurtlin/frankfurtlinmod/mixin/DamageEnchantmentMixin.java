package com.frankfurtlin.frankfurtlinmod.mixin;

import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin {
    /**
     * @author frankfurtlin
     * @reason  锋利、亡灵杀手、节肢杀手可同时存在
     */
    @Overwrite
    public boolean canAccept(Enchantment other) {
        return true;
    }
}
