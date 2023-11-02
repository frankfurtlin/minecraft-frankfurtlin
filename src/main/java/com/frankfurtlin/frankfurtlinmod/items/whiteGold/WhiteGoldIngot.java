package com.frankfurtlin.frankfurtlinmod.items.whiteGold;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 白金锭，可破坏基岩
 */

public class WhiteGoldIngot extends Item {
    public WhiteGoldIngot(Settings settings) {
        super(settings);
    }

    /**
     * 白金锭右键消耗可破坏基岩
     * @param context the usage context
     * @return SUCCESS
     */
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        BlockPos blockPos = context.getBlockPos();
        World world = context.getWorld();
        BlockState blockState = world.getBlockState(blockPos);

        if(blockState.isOf(Blocks.BEDROCK)){
            context.getStack().decrement(1);
            world.playSound(context.getPlayer(), blockPos, SoundEvents.BLOCK_STONE_BREAK, SoundCategory.BLOCKS, 1f, 1f);
            world.removeBlock(blockPos, false);
        }

        return ActionResult.CONSUME;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.frankfurtlin.white_gold_ingot.tooltip").formatted(Formatting.RED));
    }
}
