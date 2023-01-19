package com.frankfurtlin.frankfurtlinmod.mixin.enchantment;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.enchantment.DamageEnchantment;
import net.minecraft.enchantment.Enchantment;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DamageEnchantment.class)
public class DamageEnchantmentMixin {

    @Final
    @Shadow
    public int typeIndex;
    /**
     * @author frankfurtlin
     * @reason  锋利、亡灵杀手、节肢杀手可同时存在
     */
    @Overwrite
    public boolean canAccept(Enchantment other) {
        if(!ModConfig.INSTANCE.removeDamageEnchantmentConflict){
            return !(other instanceof DamageEnchantment);
        }
        else{
            if(other instanceof DamageEnchantment){
                return ((DamageEnchantment) other).typeIndex != this.typeIndex;
            }
            return true;
        }

    }
}
