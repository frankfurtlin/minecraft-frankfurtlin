package com.frankfurtlin.frankfurtlinmod;

import com.frankfurtlin.frankfurtlinmod.blocks.RegisterBlocks;
import com.frankfurtlin.frankfurtlinmod.commands.RegisterCommands;
import com.frankfurtlin.frankfurtlinmod.items.RegisterItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Frankfurtlinmod implements ModInitializer{
    public static final String MOD_ID = "frankfurtlin";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ItemGroup SUPER_ITEM_GROUP = FabricItemGroup.builder(
                    new Identifier(MOD_ID, "super_item_group"))
            .icon(() -> new ItemStack(RegisterItems.SUPER_ITEM))
            .build();

    public static final ItemGroup FOOD_GROUP = FabricItemGroup.builder(
                    new Identifier(MOD_ID, "food_group"))
            .icon(() -> new ItemStack(RegisterItems.STRAWBERRY))
            .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Frankfurtlin Fabric Mod Initialize!");
        RegisterBlocks.register();
        RegisterItems.register();
        RegisterCommands.register();

        ModConfig.init();
    }
}
