package com.frankfurtlin.frankfurtlinmod.items;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/23 19:40
 */
public class ModItemGroups {
    public static final RegistryKey<ItemGroup> SUPER_GROUP_KEY = RegistryKey.of(
        RegistryKeys.ITEM_GROUP, new Identifier(Frankfurtlinmod.MOD_ID, "super_group"));

    public static final RegistryKey<ItemGroup> ADDITION_ITEM_GROUP_KEY = RegistryKey.of(
        RegistryKeys.ITEM_GROUP, new Identifier(Frankfurtlinmod.MOD_ID, "addition_item_group"));

    public static final RegistryKey<ItemGroup> FOOD_GROUP_KEY = RegistryKey.of(
        RegistryKeys.ITEM_GROUP, new Identifier(Frankfurtlinmod.MOD_ID, "food_group"));

    public static final ItemGroup SUPER_GROUP = FabricItemGroup.builder()
        .displayName(Text.translatable("frankfurtlin.super_group"))
        .icon(() -> new ItemStack(ModItems.WHITE_GOLD_INGOT))
        .entries((context, entries) -> {
            entries.add(ModItems.WHITE_GOLD_INGOT);
            entries.add(ModBlocks.WHITE_GOLD_BLOCK);

            // 白金盔甲
            entries.add(ModItems.WHITE_GOLD_HELMET);
            entries.add(ModItems.WHITE_GOLD_CHESTPLATE);
            entries.add(ModItems.WHITE_GOLD_LEGGINGS);
            entries.add(ModItems.WHITE_GOLD_BOOTS);

            // 白金工具
            entries.add(ModItems.WHITE_GOLD_SWORD);
            entries.add(ModItems.WHITE_GOLD_PICKAXE);
            entries.add(ModItems.WHITE_GOLD_AXE);
            entries.add(ModItems.WHITE_GOLD_SHOVEL);
            entries.add(ModItems.WHITE_GOLD_HOE);

            // 煤炭簇
            entries.add(ModBlocks.BUDDING_COAL);
            entries.add(ModBlocks.COAL_CLUSTER);
            entries.add(ModBlocks.LARGE_COAL_BUD);
            entries.add(ModBlocks.MEDIUM_COAL_BUD);
            entries.add(ModBlocks.SMALL_COAL_BUD);

            // 铁簇
            entries.add(ModBlocks.BUDDING_IRON);
            entries.add(ModBlocks.IRON_CLUSTER);
            entries.add(ModBlocks.LARGE_IRON_BUD);
            entries.add(ModBlocks.MEDIUM_IRON_BUD);
            entries.add(ModBlocks.SMALL_IRON_BUD);

            // 铜簇
            entries.add(ModBlocks.BUDDING_COPPER);
            entries.add(ModBlocks.COPPER_CLUSTER);
            entries.add(ModBlocks.LARGE_COPPER_BUD);
            entries.add(ModBlocks.MEDIUM_COPPER_BUD);
            entries.add(ModBlocks.SMALL_COPPER_BUD);

            // 金簇
            entries.add(ModBlocks.BUDDING_GOLD);
            entries.add(ModBlocks.GOLD_CLUSTER);
            entries.add(ModBlocks.LARGE_GOLD_BUD);
            entries.add(ModBlocks.MEDIUM_GOLD_BUD);
            entries.add(ModBlocks.SMALL_GOLD_BUD);

            // 青金石簇
            entries.add(ModBlocks.BUDDING_LAPIS);
            entries.add(ModBlocks.LAPIS_CLUSTER);
            entries.add(ModBlocks.LARGE_LAPIS_BUD);
            entries.add(ModBlocks.MEDIUM_LAPIS_BUD);
            entries.add(ModBlocks.SMALL_LAPIS_BUD);

            // 红石簇
            entries.add(ModBlocks.BUDDING_REDSTONE);
            entries.add(ModBlocks.REDSTONE_CLUSTER);
            entries.add(ModBlocks.LARGE_REDSTONE_BUD);
            entries.add(ModBlocks.MEDIUM_REDSTONE_BUD);
            entries.add(ModBlocks.SMALL_REDSTONE_BUD);

            // 绿宝石簇
            entries.add(ModBlocks.BUDDING_EMERALD);
            entries.add(ModBlocks.EMERALD_CLUSTER);
            entries.add(ModBlocks.LARGE_EMERALD_BUD);
            entries.add(ModBlocks.MEDIUM_EMERALD_BUD);
            entries.add(ModBlocks.SMALL_EMERALD_BUD);

            // 钻石簇
            entries.add(ModBlocks.BUDDING_DIAMOND);
            entries.add(ModBlocks.DIAMOND_CLUSTER);
            entries.add(ModBlocks.LARGE_DIAMOND_BUD);
            entries.add(ModBlocks.MEDIUM_DIAMOND_BUD);
            entries.add(ModBlocks.SMALL_DIAMOND_BUD);

            // 石英簇
            entries.add(ModBlocks.BUDDING_QUARTZ);
            entries.add(ModBlocks.QUARTZ_CLUSTER);
            entries.add(ModBlocks.LARGE_QUARTZ_BUD);
            entries.add(ModBlocks.MEDIUM_QUARTZ_BUD);
            entries.add(ModBlocks.SMALL_QUARTZ_BUD);

            // 远古残骸簇
            entries.add(ModBlocks.BUDDING_NETHERITE);
            entries.add(ModBlocks.NETHERITE_CLUSTER);
            entries.add(ModBlocks.LARGE_NETHERITE_BUD);
            entries.add(ModBlocks.MEDIUM_NETHERITE_BUD);
            entries.add(ModBlocks.SMALL_NETHERITE_BUD);

            // 矿物甘蔗块
            entries.add(ModBlocks.COAL_CANE);
            entries.add(ModBlocks.IRON_CANE);
            entries.add(ModBlocks.COPPER_CANE);
            entries.add(ModBlocks.GOLD_CANE);
            entries.add(ModBlocks.LAPIS_CANE);
            entries.add(ModBlocks.DIAMOND_CANE);
            entries.add(ModBlocks.REDSTONE_CANE);
            entries.add(ModBlocks.EMERALD_CANE);
            entries.add(ModBlocks.QUARTZ_CANE);
            entries.add(ModBlocks.NETHERITE_CANE);

        }).build();

    public static final ItemGroup ADDITION_ITEM_GROUP = FabricItemGroup.builder()
        .displayName(Text.translatable("frankfurtlin.addition_item_group"))
        .icon(() -> new ItemStack(ModItems.GLOW_STICK))
        .entries((context, entries) -> {
            // 实用物品
            entries.add(ModItems.SUPER_ENDER_PACK);
            entries.add(ModItems.SUPER_BACKPACK);
            entries.add(ModItems.SUPER_CRAFTING_TABLE);

            entries.add(ModItems.GLOW_STICK);
            entries.add(ModItems.AQUATIC_TORCH);
            entries.add(ModItems.ICE_BALL);
            entries.add(ModItems.PACKED_ICE_BALL);
            entries.add(ModItems.BLUE_ICE_BALL);
            entries.add(ModBlocks.LAVA_SPONGE);
            entries.add(ModBlocks.LAVA_WET_SPONGE);
            entries.add(ModBlocks.HOT_OBSIDIAN);
        }).build();

    public static final ItemGroup FOOD_GROUP = FabricItemGroup.builder()
        .displayName(Text.translatable("frankfurtlin.food_group"))
        .icon(() -> new ItemStack(ModItems.STRAWBERRY))
        .entries((context, entries) -> {
            // 农作物
            entries.add(ModItems.STRAWBERRY);
            entries.add(ModItems.BLACKBERRY);
            entries.add(ModItems.BLUEBERRY);
            entries.add(ModItems.BANANA);
            entries.add(ModItems.CHERRY);
            entries.add(ModItems.COCONUT);
            entries.add(ModItems.CORN);
            entries.add(ModItems.DRAGONFRUIT);
            entries.add(ModItems.GRAPE);
            entries.add(ModItems.KIWI);
            entries.add(ModItems.LEMON);
            entries.add(ModItems.MANGO);
            entries.add(ModItems.ORANGE);
            entries.add(ModItems.PINEAPPLE);
            entries.add(ModItems.STARFRUIT);

            // 饮料
            entries.add(ModItems.STRAWBERRY_JUICE);
            entries.add(ModItems.COCONUT_JUICE);
            entries.add(ModItems.GRAPE_JUICE);
            entries.add(ModItems.LEMONADE);
            entries.add(ModItems.MANGO_JUICE);
            entries.add(ModItems.ORANGE_JUICE);

            entries.add(ModItems.BEER);

            // 虾蟹
            entries.add(ModItems.SHRIMP);
            entries.add(ModItems.FRIED_SHRIMP);
            entries.add(ModItems.CRAB);
            entries.add(ModItems.STEAMED_CRAB);
        })
        .build();

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, SUPER_GROUP_KEY, SUPER_GROUP);
        Registry.register(Registries.ITEM_GROUP, ADDITION_ITEM_GROUP_KEY, ADDITION_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, FOOD_GROUP_KEY, FOOD_GROUP);
        Frankfurtlinmod.LOGGER.info("Registering Item Groups for " + Frankfurtlinmod.MOD_ID);
    }
}
