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

            // 实用物品
            entries.add(ModItems.SUPER_ENDER_PACK);
            entries.add(ModItems.SUPER_BACKPACK);
            entries.add(ModItems.SUPER_CRAFTING_TABLE);
        }).build();

    public static final ItemGroup ADDITION_ITEM_GROUP = FabricItemGroup.builder()
        .displayName(Text.translatable("frankfurtlin.addition_item_group"))
        .icon(() -> new ItemStack(ModItems.GLOW_STICK))
        .entries((context, entries) -> {
            entries.add(ModItems.GLOW_STICK);
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
