package com.frankfurtlin.frankfurtlinmod;

import com.frankfurtlin.frankfurtlinmod.blocks.RegisterBlocks;
import com.frankfurtlin.frankfurtlinmod.commands.RegisterCommands;
import com.frankfurtlin.frankfurtlinmod.items.ModItemGroups;
import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Frankfurtlinmod implements ModInitializer{
    public static final String MOD_ID = "frankfurtlin";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    /*public static final RegistryKey<ItemGroup> SUPER_ITEM_GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "super_item_group"));

    public static final RegistryKey<ItemGroup> FOOD_GROUP_KEY = RegistryKey.of(
            RegistryKeys.ITEM_GROUP, new Identifier(MOD_ID, "food_group"));

    public static final ItemGroup SUPER_ITEM_GROUP = FabricItemGroup.builder()
            .displayName(Text.translatable("frankfurtlin.super_item_group"))
            .icon(() -> new ItemStack(RegisterItems.SUPER_ITEM))
            .entries((context, entries) -> {
                entries.add(RegisterItems.SUPER_ITEM);
                entries.add(RegisterItems.SUPER_HELMET);
                entries.add(RegisterItems.SUPER_CHESTPLATE);
                entries.add(RegisterItems.SUPER_LEGGINGS);
                entries.add(RegisterItems.SUPER_BOOTS);

                entries.add(RegisterItems.CUDA);


                entries.add(RegisterItems.SUPER_ENDER_PACK);
                entries.add(RegisterItems.SUPER_BACKPACK);
                entries.add(RegisterItems.SUPER_CRAFTING_TABLE);
            }).build();


    public static final ItemGroup FOOD_GROUP = FabricItemGroup.builder()
            .displayName(Text.translatable("frankfurtlin.food_group"))
            .icon(() -> new ItemStack(RegisterItems.STRAWBERRY))
            .entries((context, entries) -> {
                entries.add(RegisterItems.STRAWBERRY);
                entries.add(RegisterItems.BLACKBERRY);
                entries.add(RegisterItems.BLUEBERRY);
                entries.add(RegisterItems.BANANA);
                entries.add(RegisterItems.CHERRY);
                entries.add(RegisterItems.COCONUT);
                entries.add(RegisterItems.CORN);
                entries.add(RegisterItems.DRAGONFRUIT);
                entries.add(RegisterItems.GRAPE);
                entries.add(RegisterItems.KIWI);
                entries.add(RegisterItems.LEMON);
                entries.add(RegisterItems.MANGO);
                entries.add(RegisterItems.ORANGE);
                entries.add(RegisterItems.PINEAPPLE);
                entries.add(RegisterItems.STARFRUIT);

                entries.add(RegisterItems.STRAWBERRY_JUICE);
                entries.add(RegisterItems.COCONUT_JUICE);
                entries.add(RegisterItems.GRAPE_JUICE);
                entries.add(RegisterItems.LEMONADE);
                entries.add(RegisterItems.MANGO_JUICE);
                entries.add(RegisterItems.ORANGE_JUICE);

                entries.add(RegisterItems.BEER);

                entries.add(RegisterItems.SHRIMP);
                entries.add(RegisterItems.FRIED_SHRIMP);
                entries.add(RegisterItems.CRAB);
                entries.add(RegisterItems.STEAMED_CRAB);
            })
            .build();*/

    @Override
    public void onInitialize() {
        LOGGER.info("Frankfurtlin Fabric Mod Initialize!");
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        RegisterBlocks.register();
       /* RegisterItems.register();
        Registry.register(Registries.ITEM_GROUP, SUPER_ITEM_GROUP_KEY, SUPER_ITEM_GROUP);
        Registry.register(Registries.ITEM_GROUP, FOOD_GROUP_KEY, FOOD_GROUP);*/
        RegisterCommands.register();

        ModConfig.init();
    }
}
