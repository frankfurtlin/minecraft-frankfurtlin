package com.frankfurtlin.frankfurtlinmod.items;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.blocks.RegisterBlocks;
import com.frankfurtlin.frankfurtlinmod.blocks.StrawberryBlock;
import com.frankfurtlin.frankfurtlinmod.items.super_item.*;
import com.frankfurtlin.frankfurtlinmod.materials.SuperArmorMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
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


    // 草莓种子
    public static final Item STRAWBERRY_SEED = new AliasedBlockItem(RegisterBlocks.STRAWBERRY_CROP, new Item.Settings());
    // 草莓
    public static final Item STRAWBERRY = new Item(new Item.Settings().
            food(new FoodComponent.Builder().
            alwaysEdible().hunger(1).saturationModifier(0.3f).
            statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 2400, 0,
                            false, false, true), 1.0f).
            build()));
    // 草莓奶昔
    public static final Item STRAWBERRY_SMOOTHIE = new Item(new Item.Settings().recipeRemainder(STRAWBERRY).
            food(new FoodComponent.Builder().hunger(4).saturationModifier(0.5f).alwaysEdible().
                    statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 12000, 1,
                            false, false, true), 1.0f).
                    build()));


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


        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "strawberry_seed"), STRAWBERRY_SEED);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "strawberry"), STRAWBERRY);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "strawberry_smoothie"), STRAWBERRY_SMOOTHIE);


        //添加物品到原能物品组
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


        //添加物品到农作物物品组
        ItemGroupEvents.modifyEntriesEvent(Frankfurtlinmod.FOOD_GROUP).register(content -> {
            content.add(STRAWBERRY_SEED);
            content.add(STRAWBERRY);
            content.add(STRAWBERRY_SMOOTHIE);

        });

    }
}

