package com.frankfurtlin.frankfurtlinmod.items;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.blocks.RegisterBlocks;
import com.frankfurtlin.frankfurtlinmod.items.super_item.*;
import com.frankfurtlin.frankfurtlinmod.materials.SuperArmorMaterial;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;


public class RegisterItems {
    // 原能盔甲材料
    public static final ArmorMaterial SUPER_ARMOR_MATERIAL = new SuperArmorMaterial();


    // 原能物质，可抗火
    public static final Item SUPER_ITEM =
            new SuperItem(new Item.Settings().rarity(Rarity.EPIC).fireproof());
    // 原能头盔
    public static final Item SUPER_HELMET = new ArmorItem(SUPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
            new Item.Settings().rarity(Rarity.EPIC).fireproof());
    // 原能胸甲
    public static final Item SUPER_CHESTPLATE = new SuperChestplate(SUPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
            new Item.Settings().rarity(Rarity.EPIC).fireproof());
    // 原能护腿
    public static final Item SUPER_LEGGINGS = new ArmorItem(SUPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
            new Item.Settings().rarity(Rarity.EPIC).fireproof());
    // 原能战靴
    public static final Item SUPER_BOOTS = new ArmorItem(SUPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
            new Item.Settings().rarity(Rarity.EPIC).fireproof());


    // 原能末影箱，可右键打开
    public static final Item SUPER_ENDER_PACK = new SuperEnderPack(
            new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1));
    // 原能背包，可右键打开
    public static final Item SUPER_BACKPACK = new SuperBackPack(
            new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1));
    // 超级工作台，可右键打开
    public static final Item SUPER_CRAFTING_TABLE = new SuperCraftingTable(
            new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1));


    // 草莓
    public static final Item STRAWBERRY = new AliasedBlockItem(RegisterBlocks.STRAWBERRY_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build()));
    // 黑莓
    public static final Item BLACKBERRY = new AliasedBlockItem(RegisterBlocks.BLACKBERRY_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build()));
    // 蓝莓
    public static final Item BLUEBERRY = new AliasedBlockItem(RegisterBlocks.BLUEBERRY_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build()));
    // 香蕉
    public static final Item BANANA = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build()));
    // 樱桃
    public static final Item CHERRY = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build()));
    // 椰子
    public static final Item COCONUT = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build()));
    // 玉米
    public static final Item CORN = (Item) new AliasedBlockItem(RegisterBlocks.CORN_CROP, new Item.Settings());
    // 火龙果
    public static final Item DRAGONFRUIT = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build()));
    // 葡萄
    public static final Item GRAPE = new AliasedBlockItem(RegisterBlocks.GRAPE_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build()));
    // 猕猴桃
    public static final Item KIWI = new AliasedBlockItem(RegisterBlocks.KIWI_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build()));
    // 柠檬
    public static final Item LEMON = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build()));
    // 芒果
    public static final Item MANGO = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build()));
    // 橙子
    public static final Item ORANGE = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build()));
    // 菠萝
    public static final Item PINEAPPLE = new AliasedBlockItem(RegisterBlocks.PINEAPPLE_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build()));
    // 杨桃
    public static final Item STARFRUIT = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build()));
    // 草莓汁
    public static final Item STRAWBERRY_JUICE = new JuiceItem("strawberry_juice", new Item.Settings().
            rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible().
                    statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 12000, 4,
                            false, false, true), 1.0f).
                    build()));
    // 椰汁
    public static final Item COCONUT_JUICE = new JuiceItem("coconut_juice", new Item.Settings().
            rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible().
                    statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 12000, 0,
                            false, false, true), 1.0f).
                    build()));
    // 葡萄汁
    public static final Item GRAPE_JUICE = new JuiceItem("grape_juice", new Item.Settings().
            rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible().
                    statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 12000, 0,
                            false, false, true), 1.0f).
                    build()));
    // 柠檬汁
    public static final Item LEMONADE = new JuiceItem("lemonade", new Item.Settings().
            rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible().
                    statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 12000, 0,
                            false, false, true), 1.0f).
                    build()));
    // 芒果汁
    public static final Item MANGO_JUICE = new JuiceItem("mango_juice", new Item.Settings().
            rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible().
                    statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 12000, 0,
                            false, false, true), 1.0f).
                    build()));
    // 橙汁
    public static final Item ORANGE_JUICE = new JuiceItem("orange_juice", new Item.Settings().
            rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible().
                    statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 12000, 0,
                            false, false, true), 1.0f).
                    build()));
    // 啤酒
    public static final Item BEER = new JuiceItem("beer", new Item.Settings().
            rarity(Rarity.UNCOMMON).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).alwaysEdible().
                    statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 12000, 1,
                    false, false, true), 1.0f).build()));
    // 虾
    public static final Item SHRIMP = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build()));
    // 炸虾
    public static final Item FRIED_SHRIMP = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build()));
    // 大闸蟹
    public static final Item CRAB = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build()));
    // 蒸大闸蟹
    public static final Item STEAMED_CRAB = new Item(
            new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build()));


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


        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "strawberry"), STRAWBERRY);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "blackberry"), BLACKBERRY);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "blueberry"), BLUEBERRY);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "banana"), BANANA);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "cherry"), CHERRY);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "coconut"), COCONUT);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "corn"), CORN);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "dragonfruit"), DRAGONFRUIT);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "grape"), GRAPE);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "kiwi"), KIWI);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "lemon"), LEMON);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "mango"), MANGO);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "orange"), ORANGE);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "pineapple"), PINEAPPLE);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "starfruit"), STARFRUIT);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "strawberry_juice"), STRAWBERRY_JUICE);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "coconut_juice"), COCONUT_JUICE);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "grape_juice"), GRAPE_JUICE);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "lemonade"), LEMONADE);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "mango_juice"), MANGO_JUICE);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "orange_juice"), ORANGE_JUICE);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "beer"), BEER);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "shrimp"), SHRIMP);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "fried_shrimp"), FRIED_SHRIMP);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "crab"), CRAB);
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, "steamed_crab"), STEAMED_CRAB);


        //添加物品到原能物品组
        ItemGroupEvents.modifyEntriesEvent(Frankfurtlinmod.SUPER_ITEM_GROUP_KEY).register(content -> {
            content.add(SUPER_ITEM);
            content.add(SUPER_HELMET);
            content.add(SUPER_CHESTPLATE);
            content.add(SUPER_LEGGINGS);
            content.add(SUPER_BOOTS);


            content.add(SUPER_ENDER_PACK);
            content.add(SUPER_BACKPACK);
            content.add(SUPER_CRAFTING_TABLE);

        });


        //添加物品到食物物品组
        ItemGroupEvents.modifyEntriesEvent(Frankfurtlinmod.FOOD_GROUP_KEY).register(content -> {
            content.add(STRAWBERRY);
            content.add(BLACKBERRY);
            content.add(BLUEBERRY);
            content.add(BANANA);
            content.add(CHERRY);
            content.add(COCONUT);
            content.add(CORN);
            content.add(DRAGONFRUIT);
            content.add(GRAPE);
            content.add(KIWI);
            content.add(LEMON);
            content.add(MANGO);
            content.add(ORANGE);
            content.add(PINEAPPLE);
            content.add(STARFRUIT);

            content.add(STRAWBERRY_JUICE);
            content.add(COCONUT_JUICE);
            content.add(GRAPE_JUICE);
            content.add(LEMONADE);
            content.add(MANGO_JUICE);
            content.add(ORANGE_JUICE);

            content.add(BEER);

            content.add(SHRIMP);
            content.add(FRIED_SHRIMP);
            content.add(CRAB);
            content.add(STEAMED_CRAB);

        });

    }
}

