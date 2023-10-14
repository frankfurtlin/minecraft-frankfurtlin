package com.frankfurtlin.frankfurtlinmod;

import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import com.frankfurtlin.frankfurtlinmod.commands.RegisterCommands;
import com.frankfurtlin.frankfurtlinmod.enchantment.ModEnchantments;
import com.frankfurtlin.frankfurtlinmod.entity.ModEntities;
import com.frankfurtlin.frankfurtlinmod.items.ModItemGroups;
import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Frankfurtlinmod implements ModInitializer{
    public static final String MOD_ID = "frankfurtlin";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Frankfurtlin Fabric Mod Initialize!");

        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();

        ModBlocks.registerModBlocks();

        ModEnchantments.registerModEnchantments();

        ModEntities.registerModEntities();

        RegisterCommands.register();

        ModConfig.init();
    }
}
