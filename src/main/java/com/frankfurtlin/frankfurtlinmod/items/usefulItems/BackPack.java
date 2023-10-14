package com.frankfurtlin.frankfurtlinmod.items.usefulItems;

import com.frankfurtlin.frankfurtlinmod.gui.screen.BackPackInventory;
import com.frankfurtlin.frankfurtlinmod.gui.screen.BackPackScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * 大容量背包
 */
public class BackPack extends Item {
    public BackPack(Settings settings) {
        super(settings);
    }

    @Override
    public boolean canBeNested()
    {
        return false;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
    {
        if(player.getWorld().isClient) {
            return TypedActionResult.pass(player.getStackInHand(hand));
        }

        player.setCurrentHand(hand);
        ItemStack stack = player.getStackInHand(hand);
        player.openHandledScreen(createScreenHandlerFactory(stack));

        return TypedActionResult.pass(player.getStackInHand(hand));
    }

    private NamedScreenHandlerFactory createScreenHandlerFactory(ItemStack stack)
    {
        return new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) ->
                BackPackScreenHandler.createGeneric9x6(i, playerInventory, new BackPackInventory(stack)), stack.getName());
    }
}
