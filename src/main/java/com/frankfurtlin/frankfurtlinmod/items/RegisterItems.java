package com.frankfurtlin.frankfurtlinmod.items;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.items.super_item.*;
import com.frankfurtlin.frankfurtlinmod.materials.SuperArmorMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;



public class RegisterItems {
    // 原能盔甲材料
    public static final ArmorMaterial SUPER_ARMOR_MATERIAL = new SuperArmorMaterial();


    // 原能物质，可抗火
    public static final Item SUPER_ITEM =
            new SuperItem(new Item.Settings().fireproof());
    // 原能头盔
    public static final Item SUPER_HELMET = new ArmorItem(SUPER_ARMOR_MATERIAL, EquipmentSlot.HEAD,
            new Item.Settings().recipeRemainder(SUPER_ITEM).fireproof());
    // 原能胸甲
    public static final Item SUPER_CHESTPLATE = new SuperChestplate(SUPER_ARMOR_MATERIAL, EquipmentSlot.CHEST,
            new Item.Settings().recipeRemainder(SUPER_ITEM).fireproof());
    // 原能护腿
    public static final Item SUPER_LEGGINGS = new ArmorItem(SUPER_ARMOR_MATERIAL, EquipmentSlot.LEGS,
            new Item.Settings().recipeRemainder(SUPER_ITEM).fireproof());
    // 原能战靴
    public static final Item SUPER_BOOTS = new ArmorItem(SUPER_ARMOR_MATERIAL, EquipmentSlot.FEET,
            new Item.Settings().recipeRemainder(SUPER_ITEM).fireproof());


    // 原能末影箱，可右键打开
    public static final Item SUPER_ENDER_PACK = new SuperEnderPack(
            new Item.Settings().recipeRemainder(SUPER_ITEM).fireproof().maxCount(1));
    // 原能背包，可右键打开
    public static final Item SUPER_BACKPACK = new SuperBackPack(
            new Item.Settings().recipeRemainder(SUPER_ITEM).fireproof().maxCount(1));
    // 超级工作台，可右键打开
    public static final Item SUPER_CRAFTING_TABLE = new SuperCraftingTable(
            new Item.Settings().recipeRemainder(SUPER_ITEM).fireproof().maxCount(1));


    // 注册物品
    public static void register() {
        Registry.register(Registries.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_item"), SUPER_ITEM);
        Registry.register(Registries.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_helmet"), SUPER_HELMET);
        Registry.register(Registries.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_chestplate"), SUPER_CHESTPLATE);
        Registry.register(Registries.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_leggings"), SUPER_LEGGINGS);
        Registry.register(Registries.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_boots"), SUPER_BOOTS);


        Registry.register(Registries.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_ender_pack"), SUPER_ENDER_PACK);
        Registry.register(Registries.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_backpack"), SUPER_BACKPACK);
        Registry.register(Registries.ITEM,
                new Identifier(Frankfurtlinmod.MOD_ID, "super_crafting_table"), SUPER_CRAFTING_TABLE);

        //添加物品到物品组
        ItemGroupEvents.modifyEntriesEvent(Frankfurtlinmod.SUPER_ITEM_GROUP).register(content -> {
            content.add(SUPER_ITEM);
            content.add(SUPER_HELMET);
            content.add(SUPER_CHESTPLATE);
            content.add(SUPER_LEGGINGS);
            content.add(SUPER_BOOTS);


            content.add(SUPER_ENDER_PACK);
            content.add(SUPER_BACKPACK);
            content.add(SUPER_CRAFTING_TABLE);


        });

    }
}

