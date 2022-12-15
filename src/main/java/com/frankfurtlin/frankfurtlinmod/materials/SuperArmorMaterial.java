package com.frankfurtlin.frankfurtlinmod.materials;

import com.frankfurtlin.frankfurtlinmod.items.RegisterItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

/**
 * 超级盔甲材料
 */
public class SuperArmorMaterial implements ArmorMaterial {
    // 头盔、胸甲、护腿、靴子基础耐久度
    private static final int[] durability = new int[]{11, 16, 15, 13};
    // 耐久度倍率 皮革5 铁、锁链15 龟壳25 金7 钻石33 下届合金37
    private static final int multiplier = 40;

    // 护甲值
    private static final int[] protection = new int[]{3, 8, 6, 3};

    @Override
    public int getDurability(EquipmentSlot slot) {
        return durability[3 - slot.getEntitySlotId()] * multiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return protection[3 - slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return 25;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(RegisterItems.SUPER_ITEM);
    }

    @Override
    public String getName() {
        return "super_armor_item";
    }

    // 韧性 钻石2 下届合金3
    @Override
    public float getToughness() {
        return 5.0f;
    }

    // 击退抵抗 下届合金0.1
    @Override
    public float getKnockbackResistance() {
        return 0.2f;
    }

}
