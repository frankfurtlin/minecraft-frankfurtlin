package com.frankfurtlin.frankfurtlinmod;

import com.frankfurtlin.frankfurtlinmod.blocks.RegisterBlocks;
import com.frankfurtlin.frankfurtlinmod.commands.RegisterCommands;
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

        RegisterBlocks.register();

        RegisterCommands.register();

        ModConfig.init();
    }
}
