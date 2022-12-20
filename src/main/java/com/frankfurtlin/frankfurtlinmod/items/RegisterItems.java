package com.frankfurtlin.frankfurtlinmod.items;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.items.super_item.SuperChestplate;
import com.frankfurtlin.frankfurtlinmod.items.super_item.SuperItem;
import com.frankfurtlin.frankfurtlinmod.materials.SuperArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class RegisterItems {
    // 原能盔甲材料
    public static final ArmorMaterial SUPER_ARMOR_MATERIAL = new SuperArmorMaterial();

    // 原能物质，可抗火
    public static final Item SUPER_ITEM =
            new SuperItem(new Item.Settings().group(Frankfurtlinmod.SUPER_ITEM_GROUP).fireproof());
    // 原能头盔
    public static final Item SUPER_HELMET = new ArmorItem(SUPER_ARMOR_MATERIAL, EquipmentSlot.HEAD,
            new Item.Settings().group(Frankfurtlinmod.SUPER_ITEM_GROUP).recipeRemainder(SUPER_ITEM).fireproof());
    // 原能胸甲
    public static final Item SUPER_CHESTPLATE = new SuperChestplate(SUPER_ARMOR_MATERIAL, EquipmentSlot.CHEST,
            new Item.Settings().group(Frankfurtlinmod.SUPER_ITEM_GROUP).recipeRemainder(SUPER_ITEM).fireproof());
    // 原能护腿
    public static final Item SUPER_LEGGINGS = new ArmorItem(SUPER_ARMOR_MATERIAL, EquipmentSlot.LEGS,
            new Item.Settings().group(Frankfurtlinmod.SUPER_ITEM_GROUP).recipeRemainder(SUPER_ITEM).fireproof());
    // 原能战靴
    public static final Item SUPER_BOOTS = new ArmorItem(SUPER_ARMOR_MATERIAL, EquipmentSlot.FEET,
            new Item.Settings().group(Frankfurtlinmod.SUPER_ITEM_GROUP).recipeRemainder(SUPER_ITEM).fireproof());


    // 注册物品
    public static void register() {
        Registry.register(Registry.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_item"), SUPER_ITEM);
        Registry.register(Registry.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_helmet"), SUPER_HELMET);
        Registry.register(Registry.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_chestplate"), SUPER_CHESTPLATE);
        Registry.register(Registry.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_leggings"), SUPER_LEGGINGS);
        Registry.register(Registry.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_boots"), SUPER_BOOTS);
    }
}

