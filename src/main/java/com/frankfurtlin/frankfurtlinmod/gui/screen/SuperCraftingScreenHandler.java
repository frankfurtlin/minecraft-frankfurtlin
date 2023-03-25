package com.frankfurtlin.frankfurtlinmod.gui.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.*;


/*
    Based on vanilla CraftingScreenHandler
 */
public class SuperCraftingScreenHandler extends CraftingScreenHandler
{

    public SuperCraftingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(syncId, playerInventory, context);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}