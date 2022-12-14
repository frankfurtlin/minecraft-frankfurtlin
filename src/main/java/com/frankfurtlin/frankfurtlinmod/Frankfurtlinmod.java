package com.frankfurtlin.frankfurtlinmod;

import com.frankfurtlin.frankfurtlinmod.items.RegisterItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Frankfurtlinmod implements ModInitializer{
    public static final String MOD_ID = "frankfurtlin";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final ItemGroup SUPER_ARMOR_GROUP = FabricItemGroupBuilder.create(
                    new Identifier(MOD_ID, "super_item_group"))
            .icon(() -> new ItemStack(RegisterItems.SUPER_ARMOR_ITEM))
            .build();

    @Override
    public void onInitialize() {
        LOGGER.info("Frankfurtlin Fabric Mod Initialize!");
        RegisterItems.register();
    }
}
