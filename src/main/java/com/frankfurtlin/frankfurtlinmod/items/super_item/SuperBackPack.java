package com.frankfurtlin.frankfurtlinmod.items.super_item;

import com.frankfurtlin.frankfurtlinmod.gui.screen.SuperBackPackInventory;
import com.frankfurtlin.frankfurtlinmod.gui.screen.SuperBackPackScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * 原能背包，大容量背包
 */
public class SuperBackPack extends Item {
    public SuperBackPack(Settings settings) {
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
        if(player.world.isClient) {
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
                SuperBackPackScreenHandler.createGeneric9x6(i, playerInventory, new SuperBackPackInventory(stack)), stack.getName());
    }
}
