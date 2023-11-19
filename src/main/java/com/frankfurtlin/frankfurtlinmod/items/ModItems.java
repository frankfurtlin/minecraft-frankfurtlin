package com.frankfurtlin.frankfurtlinmod.items;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import com.frankfurtlin.frankfurtlinmod.items.usefulItems.BackPack;
import com.frankfurtlin.frankfurtlinmod.items.usefulItems.CraftingTable;
import com.frankfurtlin.frankfurtlinmod.items.usefulItems.EnderPack;
import com.frankfurtlin.frankfurtlinmod.items.whiteGold.WhiteGoldChestplate;
import com.frankfurtlin.frankfurtlinmod.items.whiteGold.WhiteGoldHoe;
import com.frankfurtlin.frankfurtlinmod.items.whiteGold.WhiteGoldIngot;
import com.frankfurtlin.frankfurtlinmod.materials.ModToolMaterial;
import com.frankfurtlin.frankfurtlinmod.materials.WhiteGoldArmorMaterial;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.math.Direction;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/23 19:39
 */
public class ModItems {
    // ----------------------------------------------------------------------------------------------------------------
    // 白金盔甲材料
    public static final ArmorMaterial WHITE_GOLD_ARMOR_MATERIAL = new WhiteGoldArmorMaterial();


    // 白金锭，可抗火
    public static final Item WHITE_GOLD_INGOT = registerItem("white_gold_ingot",
        new WhiteGoldIngot(new Item.Settings().rarity(Rarity.EPIC).fireproof()));


    // 白金战盔
    public static final Item WHITE_GOLD_HELMET = registerItem("white_gold_helmet",
        new ArmorItem(WHITE_GOLD_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    // 白金战甲
    public static final Item WHITE_GOLD_CHESTPLATE = registerItem("white_gold_chestplate",
        new WhiteGoldChestplate(WHITE_GOLD_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    // 白金护腿
    public static final Item WHITE_GOLD_LEGGINGS = registerItem("white_gold_leggings",
        new ArmorItem(WHITE_GOLD_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Settings().rarity(Rarity.EPIC).fireproof()));
    // 白金战靴
    public static final Item WHITE_GOLD_BOOTS = registerItem("white_gold_boots",
        new ArmorItem(WHITE_GOLD_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Settings().rarity(Rarity.EPIC).fireproof()));


    // 白金剑
    public static final Item WHITE_GOLD_SWORD = registerItem("white_gold_sword",
        new SwordItem(ModToolMaterial.WHITE_GOLD, 3, -2.3f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    // 白金镐
    public static final Item WHITE_GOLD_PICKAXE = registerItem("white_gold_pickaxe",
        new PickaxeItem(ModToolMaterial.WHITE_GOLD, 1, -2.7f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    // 白金斧
    public static final Item WHITE_GOLD_AXE = registerItem("white_gold_axe",
        new AxeItem(ModToolMaterial.WHITE_GOLD, 5.0f, -2.8f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    // 白金铲
    public static final Item WHITE_GOLD_SHOVEL= registerItem("white_gold_shovel",
        new ShovelItem(ModToolMaterial.WHITE_GOLD, 1.5f, -3.0f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));
    // 白金锄
    public static final Item WHITE_GOLD_HOE = registerItem("white_gold_hoe",
        new WhiteGoldHoe(ModToolMaterial.WHITE_GOLD, -5, 0.0f, new FabricItemSettings().rarity(Rarity.EPIC).fireproof()));




    // ----------------------------------------------------------------------------------------------------------------

    // 末影背包，可右键打开
    public static final Item SUPER_ENDER_PACK = registerItem("ender_pack",
        new EnderPack(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1)));
    // 大容量背包,可右键打开
    public static final Item SUPER_BACKPACK = registerItem("backpack",
        new BackPack(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1)));
    // 手持工作台,可右键打开
    public static final Item SUPER_CRAFTING_TABLE = registerItem("crafting_table",
        new CraftingTable(new Item.Settings().rarity(Rarity.EPIC).fireproof().maxCount(1)));
    // 荧光棒
    public static final Item GLOW_STICK = registerItem("glow_stick",
        new GlowStickItem(new Item.Settings().rarity(Rarity.UNCOMMON)));
    // 水蜡烛
    public static final Item AQUATIC_TORCH = registerItem("aquatic_torch",
        new VerticallyAttachableBlockItem(ModBlocks.AQUATIC_TORCH, ModBlocks.AQUATIC_WALL_TORCH,
            new Item.Settings(), Direction.DOWN));
    // 冰球
    public static final Item ICE_BALL = registerItem("ice_ball",
        new IceBallItem(new FabricItemSettings().maxCount(16).rarity(Rarity.COMMON), 2, 0));
    public static final Item PACKED_ICE_BALL = registerItem("packed_ice_ball",
        new IceBallItem(new FabricItemSettings().maxCount(16).rarity(Rarity.UNCOMMON), 4, 5));
    public static final Item BLUE_ICE_BALL = registerItem("blue_ice_ball",
        new IceBallItem(new FabricItemSettings().maxCount(16).rarity(Rarity.RARE), 6, 10));



    // ----------------------------------------------------------------------------------------------------------------

    // 草莓
    public static final Item STRAWBERRY = registerItem("strawberry",
        new AliasedBlockItem(ModBlocks.STRAWBERRY_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
    // 黑莓
    public static final Item BLACKBERRY = registerItem("blackberry",
        new AliasedBlockItem(ModBlocks.BLACKBERRY_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
    // 蓝莓
    public static final Item BLUEBERRY = registerItem("blueberry",
        new AliasedBlockItem(ModBlocks.BLUEBERRY_CROP,
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
        new AliasedBlockItem(ModBlocks.CORN_CROP, new Item.Settings()));
    // 火龙果
    public static final Item DRAGONFRUIT = registerItem("dragonfruit",
        new Item(new Item.Settings().food(new FoodComponent.Builder().hunger(2).saturationModifier(0.3f).build())));
    // 葡萄
    public static final Item GRAPE = registerItem("grape",
        new AliasedBlockItem(ModBlocks.GRAPE_CROP,
            new Item.Settings().food(new FoodComponent.Builder().hunger(1).saturationModifier(0.3f).build())));
    // 猕猴桃
    public static final Item KIWI = registerItem("kiwi",
        new AliasedBlockItem(ModBlocks.KIWI_CROP,
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
        new AliasedBlockItem(ModBlocks.PINEAPPLE_CROP,
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


    // ----------------------------------------------------------------------------------------------------------------


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        Frankfurtlinmod.LOGGER.info("Registering Mod Items for " + Frankfurtlinmod.MOD_ID);
    }
}
