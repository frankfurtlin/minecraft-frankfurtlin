package com.frankfurtlin.frankfurtlinmod.items.super_item;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SuperItem extends Item {
    public SuperItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        BlockState blockState = world.getBlockState(blockPos);

        if(blockState.isOf(Blocks.BEDROCK)){
            Frankfurtlinmod.LOGGER.info("frankfurtlin use super item destroy bedrock");
            context.getStack().decrement(1);
            world.playSound(context.getPlayer(), blockPos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.removeBlock(blockPos, false);
        }

        return ActionResult.SUCCESS;
    }


}
