package com.frankfurtlin.frankfurtlinmod.items.usefulItems;

import com.frankfurtlin.frankfurtlinmod.gui.screen.CraftingScreenHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.SimpleNamedScreenHandlerFactory;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 手持工作台，可右键快速打开工作台
 */
public class CraftingTable extends Item {

    private static final Text TITLE = Text.translatable("container.crafting");

    public CraftingTable(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if(!world.isClient)
        {
            player.openHandledScreen(createPortableScreenHandlerFactory(world, player.getBlockPos()));
            return TypedActionResult.success(itemStack);
        }

        return TypedActionResult.pass(itemStack);
    }

    public NamedScreenHandlerFactory createPortableScreenHandlerFactory(World world, BlockPos pos) {
        return new SimpleNamedScreenHandlerFactory((syncId, inventory, player) ->
             new CraftingScreenHandler(syncId, inventory, ScreenHandlerContext.create(world, pos)), TITLE);
    }
}
