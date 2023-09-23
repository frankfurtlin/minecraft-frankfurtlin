package com.frankfurtlin.frankfurtlinmod.items;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.blocks.RegisterBlocks;
import com.frankfurtlin.frankfurtlinmod.items.super_item.*;
import com.frankfurtlin.frankfurtlinmod.materials.ModToolMaterial;
import com.frankfurtlin.frankfurtlinmod.materials.SuperArmorMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/23 19:39
 */
public class ModItems {
    // 原能盔甲材料
    public static final ArmorMaterial SUPER_ARMOR_MATERIAL = new SuperArmorMaterial();


    // 原能物质，可抗火
    public static final Item SUPER_ITEM = registerItem("super_item",
        new SuperItem(new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    // 原能头盔
    public static final Item SUPER_HELMET = registerItem("super_helmet",
        new ArmorItem(SUPER_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    // 原能胸甲
    public static final Item SUPER_CHESTPLATE = registerItem("super_chestplate",
        new SuperChestplate(SUPER_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    // 原能护腿
    public static final Item SUPER_LEGGINGS = registerItem("super_leggings",
        new ArmorItem(SUPER_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    // 原能战靴
    public static final Item SUPER_BOOTS = registerItem("super_boots",
        new ArmorItem(SUPER_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().rarity(Rarity.EPIC).fireproof()));

    // 原能锄
    public static final Item SUPER_HOE = registerItem("hello",
        new SuperHoe(ModToolMaterial.SUPER_ITEM, -3, 0.0f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));

    // 原能末影箱，可右键打开
    public static final Item SUPER_ENDER_PACK = registerItem("super_ender_pack",
        new SuperEnderPack(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1)));
    // 原能背包,可右键打开
    public static final Item SUPER_BACKPACK = registerItem("super_backpack",
        new SuperBackPack(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1)));
    // 超级工作台,可右键打开
    public static final Item SUPER_CRAFTING_TABLE = registerItem("super_crafting_table",
        new SuperCraftingTable(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1)));


    // 草莓
    public static final Item STRAWBERRY = registerItem("strawberry",
        new AliasedBlockItem(RegisterBlocks.STRAWBERRY_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
    // 黑莓
    public static final Item BLACKBERRY = registerItem("blackberry",
        new AliasedBlockItem(RegisterBlocks.BLACKBERRY_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
    // 蓝莓
    public static final Item BLUEBERRY = registerItem("blueberry",
        new AliasedBlockItem(RegisterBlocks.BLUEBERRY_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
    // 香蕉
    public static final Item BANANA = registerItem("banana",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
    // 樱桃
    public static final Item CHERRY = registerItem("cherry",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
    // 椰子
    public static final Item COCONUT = registerItem("coconut",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
    // 玉米
    public static final Item CORN = registerItem("corn",
        new AliasedBlockItem(RegisterBlocks.CORN_CROP, new Item.Settings()));
    // 火龙果
    public static final Item DRAGONFRUIT = registerItem("dragonfruit",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
    // 葡萄
    public static final Item GRAPE = registerItem("grape",
        new AliasedBlockItem(RegisterBlocks.GRAPE_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
    // 猕猴桃
    public static final Item KIWI = registerItem("kiwi",
        new AliasedBlockItem(RegisterBlocks.KIWI_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
    // 柠檬
    public static final Item LEMON = registerItem("lemon",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
    // 芒果
    public static final Item MANGO = registerItem("mango",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
    // 橙子
    public static final Item ORANGE = registerItem("orange",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
    // 菠萝
    public static final Item PINEAPPLE = registerItem("pineapple",
        new AliasedBlockItem(RegisterBlocks.PINEAPPLE_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    // 杨桃
    public static final Item STARFRUIT = registerItem("starfruit",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));

    // 草莓汁
    public static final Item STRAWBERRY_JUICE = registerItem("strawberry_juice",
        new JuiceItem("strawberry_juice", new Item.Settings().rarity(Rarity.UNCOMMON)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.LUCK, 12000, 4, false, false, true), 1.0f)
                .build())));
    // 椰汁
    public static final Item COCONUT_JUICE = registerItem("coconut_juice",
        new JuiceItem("coconut_juice", new Item.Settings().rarity(Rarity.UNCOMMON)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.INVISIBILITY, 12000, 0, false, false, true), 1.0f)
                .build())));
    // 葡萄汁
    public static final Item GRAPE_JUICE = registerItem("grape_juice",
        new JuiceItem("grape_juice", new Item.Settings().rarity(Rarity.UNCOMMON)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 12000, 0, false, false, true), 1.0f)
                .build())));
    // 柠檬汁
    public static final Item LEMONADE = registerItem("lemonade",
        new JuiceItem("lemonade", new Item.Settings().rarity(Rarity.UNCOMMON)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 12000, 0, false, false, true), 1.0f)
                .build())));
    // 芒果汁
    public static final Item MANGO_JUICE = registerItem("mango_juice",
        new JuiceItem("mango_juice", new Item.Settings().rarity(Rarity.UNCOMMON)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 12000, 0, false, false, true), 1.0f)
                .build())));
    // 橙汁
    public static final Item ORANGE_JUICE = registerItem("orange_juice",
        new JuiceItem("orange_juice", new Item.Settings().rarity(Rarity.UNCOMMON)
            .food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.DOLPHINS_GRACE, 12000, 0, false, false, true), 1.0f)
                .build())));
    // 啤酒
    public static final Item BEER = registerItem("beer",
        new JuiceItem("beer", new Item.Settings().rarity(Rarity.UNCOMMON)
            .food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).alwaysEdible()
                .statusEffect(new StatusEffectInstance(StatusEffects.HASTE, 12000, 1, false, false, true), 1.0f)
                .build())));
    // 虾
    public static final Item SHRIMP = registerItem("shrimp",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    // 炸虾
    public static final Item FRIED_SHRIMP = registerItem("fried_shrimp",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));
    // 大闸蟹
    public static final Item CRAB = registerItem("crab",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(3).saturationModifier(0.3f).build())));
    // 蒸大闸蟹
    public static final Item STEAMED_CRAB = registerItem("steamed_crab",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(6).saturationModifier(0.8f).build())));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Frankfurtlinmod.LOGGER.info("Registering Mod Items for " + Frankfurtlinmod.MOD_ID);
    }
}
