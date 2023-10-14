package com.frankfurtlin.frankfurtlinmod.gui.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.*;


/*
    Based on vanilla CraftingScreenHandler
 */
public class CraftingScreenHandler extends net.minecraft.screen.CraftingScreenHandler
{

    public CraftingScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context) {
        super(syncId, playerInventory, context);
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return true;
    }
}