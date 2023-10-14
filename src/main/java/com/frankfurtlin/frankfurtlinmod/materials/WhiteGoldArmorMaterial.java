package com.frankfurtlin.frankfurtlinmod.materials;


import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

/**
 * 白金盔甲材料
 */
public class WhiteGoldArmorMaterial implements ArmorMaterial {
    // 头盔、胸甲、护腿、靴子基础耐久度
    private static final int[] durability = new int[]{11, 16, 15, 13};
    // 耐久度倍率 皮革5 铁、锁链15 龟壳25 金7 钻石33 下届合金37
    private static final int multiplier = 80;

    // 护甲值
    private static final int[] protection = new int[]{3, 8, 6, 3};

    @Override
    public int getDurability(ArmorItem.Type type) {
        return durability[4 - type.getEquipmentSlot().getArmorStandSlotId()] * multiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return protection[4 - type.getEquipmentSlot().getArmorStandSlotId()];
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.WHITE_GOLD_INGOT);
    }

    @Override
    public String getName() {
        return "white_gold";
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
