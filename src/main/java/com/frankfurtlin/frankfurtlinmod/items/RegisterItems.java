package com.frankfurtlin.frankfurtlinmod.items;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.items.superarmor.SuperArmorChestplate;
import com.frankfurtlin.frankfurtlinmod.items.superarmor.SuperArmorItem;
import com.frankfurtlin.frankfurtlinmod.materials.SuperArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class RegisterItems {
    public static final ArmorMaterial super_armor_material = new SuperArmorMaterial();


    public static final Item SUPER_ARMOR_ITEM =
            new SuperArmorItem(new Item.Settings().group(Frankfurtlinmod.SUPER_ARMOR_GROUP));
    public static final Item SUPER_ARMOR_HELMET = new ArmorItem(super_armor_material, EquipmentSlot.HEAD,
            new Item.Settings().group(Frankfurtlinmod.SUPER_ARMOR_GROUP).recipeRemainder(SUPER_ARMOR_ITEM));
    public static final Item SUPER_ARMOR_CHESTPLATE = new SuperArmorChestplate(super_armor_material, EquipmentSlot.CHEST,
            new Item.Settings().group(Frankfurtlinmod.SUPER_ARMOR_GROUP).recipeRemainder(SUPER_ARMOR_ITEM));
    public static final Item SUPER_ARMOR_LEGGINGS = new ArmorItem(super_armor_material, EquipmentSlot.LEGS,
            new Item.Settings().group(Frankfurtlinmod.SUPER_ARMOR_GROUP).recipeRemainder(SUPER_ARMOR_ITEM));
    public static final Item SUPER_ARMOR_BOOTS = new ArmorItem(super_armor_material, EquipmentSlot.FEET,
            new Item.Settings().group(Frankfurtlinmod.SUPER_ARMOR_GROUP).recipeRemainder(SUPER_ARMOR_ITEM));


    public static void register() {
        Registry.register(Registry.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_armor_item"), SUPER_ARMOR_ITEM);
        Registry.register(Registry.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_armor_helmet"), SUPER_ARMOR_HELMET);
        Registry.register(Registry.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_armor_chestplate"), SUPER_ARMOR_CHESTPLATE);
        Registry.register(Registry.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_armor_leggings"), SUPER_ARMOR_LEGGINGS);
        Registry.register(Registry.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_armor_boots"), SUPER_ARMOR_BOOTS);
    }
}

