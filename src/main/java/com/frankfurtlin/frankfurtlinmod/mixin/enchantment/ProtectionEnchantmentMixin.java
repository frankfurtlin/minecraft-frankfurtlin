package com.frankfurtlin.frankfurtlinmod.mixin.enchantment;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ProtectionEnchantment.class)
public class ProtectionEnchantmentMixin extends Enchantment{

    protected ProtectionEnchantmentMixin(Rarity weight, EnchantmentTarget type, EquipmentSlot[] slotTypes) {
        super(weight, type, slotTypes);
    }

    @Final
    @Shadow
    public ProtectionEnchantment.Type protectionType;

    /**
     * @author frankfurtlin
     * @reason  保护、火焰保护、弹射物保护、爆炸保护可同时存在
     */
    @Overwrite
    public boolean canAccept(Enchantment other) {
        if (other instanceof ProtectionEnchantment protectionEnchantment) {
            if (this.protectionType == protectionEnchantment.protectionType) {
                return false;
            }

            if(ModConfig.INSTANCE.removeProtectionEnchantmentConflict){
                return true;
            }
            else{
                return this.protectionType == ProtectionEnchantment.Type.FALL ||
                        protectionEnchantment.protectionType == ProtectionEnchantment.Type.FALL;
            }
        }
        return super.canAccept(other);
    }
}
