package com.frankfurtlin.frankfurtlinmod.items;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
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
    public static final RegistryKey<ItemGroup> SUPER_ITEM_GROUP_KEY = RegistryKey.of(
        RegistryKeys.ITEM_GROUP, new Identifier(Frankfurtlinmod.MOD_ID, "super_item_group"));

    public static final RegistryKey<ItemGroup> FOOD_GROUP_KEY = RegistryKey.of(
        RegistryKeys.ITEM_GROUP, new Identifier(Frankfurtlinmod.MOD_ID, "food_group"));
    public static final ItemGroup SUPER_ITEM_GROUP = FabricItemGroup.builder()
        .displayName(Text.translatable("frankfurtlin.super_item_group"))
        .icon(() -> new ItemStack(ModItems.SUPER_ITEM))
        .entries((context, entries) -> {
            entries.add(ModItems.SUPER_ITEM);
            entries.add(ModItems.SUPER_HELMET);
            entries.add(ModItems.SUPER_CHESTPLATE);
            entries.add(ModItems.SUPER_LEGGINGS);
            entries.add(ModItems.SUPER_BOOTS);

//            entries.add(ModItems.SUPER_HOE);
            
            entries.add(ModItems.SUPER_ENDER_PACK);
            entries.add(ModItems.SUPER_BACKPACK);
            entries.add(ModItems.SUPER_CRAFTING_TABLE);
        }).build();


    public static final ItemGroup FOOD_GROUP = FabricItemGroup.builder()
        .displayName(Text.translatable("frankfurtlin.food_group"))
        .icon(() -> new ItemStack(ModItems.STRAWBERRY))
        .entries((context, entries) -> {
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

            entries.add(ModItems.STRAWBERRY_JUICE);
            entries.add(ModItems.COCONUT_JUICE);
            entries.add(ModItems.GRAPE_JUICE);
            entries.add(ModItems.LEMONADE);
            entries.add(ModItems.MANGO_JUICE);
            entries.add(ModItems.ORANGE_JUICE);

            entries.add(ModItems.BEER);

            entries.add(ModItems.SHRIMP);
            entries.add(ModItems.FRIED_SHRIMP);
            entries.add(ModItems.CRAB);
            entries.add(ModItems.STEAMED_CRAB);
        })
        .build();

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, SUPER_ITEM_GROUP_KEY, SUPER_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, FOOD_GROUP_KEY, FOOD_GROUP);
        Frankfurtlinmod.LOGGER.info("Registering Item Groups for " + Frankfurtlinmod.MOD_ID);
    }
}