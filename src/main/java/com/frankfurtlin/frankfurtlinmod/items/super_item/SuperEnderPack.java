package com.frankfurtlin.frankfurtlinmod.items.super_item;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * 原能末影箱，可右键打开末影箱
 */
public class SuperEnderPack extends Item {
    public SuperEnderPack(Settings settings) {
        super(settings);
    }

    public static final Text TITLE = Text.translatable("container.enderchest");

    @Override
    public boolean canBeNested()
    {
        return false;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand)
    {
        ItemStack itemStack = player.getStackInHand(hand);
        player.setCurrentHand(hand);
        EnderChestInventory enderChest = player.getEnderChestInventory();

        if (enderChest != null)
        {
            if (!world.isClient)
            {
                player.openHandledScreen(new SimpleNamedScreenHandlerFactory((i, playerInventory, playerEntity) ->
                        GenericContainerScreenHandler.createGeneric9x3(i, playerInventory, enderChest), TITLE));
            }
        }

        return TypedActionResult.success(itemStack);
    }

}
