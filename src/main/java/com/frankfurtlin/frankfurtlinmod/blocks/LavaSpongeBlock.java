package com.frankfurtlin.frankfurtlinmod.blocks;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/22 11:51
 */
public class LavaSpongeBlock extends Block {

    private static final Direction[] values = Direction.values();

    public LavaSpongeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (oldState.isOf(state.getBlock())) {
            return;
        }
        this.update(world, pos);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos,
                               Block sourceBlock, BlockPos sourcePos, boolean notify) {
        this.update(world, pos);
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    protected void update(World world, BlockPos pos) {
        if (this.absorbLava(world, pos)) {
            world.setBlockState(pos, ModBlocks.LAVA_WET_SPONGE.getDefaultState(), Block.NOTIFY_LISTENERS);
            world.playSound(null, pos, SoundEvents.BLOCK_SPONGE_ABSORB,
                SoundCategory.BLOCKS, 1.0f, 1.0f);
        }
    }

    private boolean absorbLava(World world, BlockPos pos) {
        return BlockPos.iterateRecursively(pos, ModConfig.INSTANCE.maxDepth, ModConfig.INSTANCE.maxIterations, (currentPos, queue) -> {
            for (Direction direction : values) {
                queue.accept(currentPos.offset(direction));
            }
        }, currentPos -> {
            if (currentPos.equals(pos)) {
                return true;
            }
            BlockState blockState = world.getBlockState(currentPos);
            FluidState fluidState = world.getFluidState(currentPos);
            if (!fluidState.isIn(FluidTags.LAVA)) {
                return false;
            }
            Block block = blockState.getBlock();
            if (block instanceof FluidDrainable &&
                !((FluidDrainable) block).tryDrainFluid(null, world, currentPos, blockState).isEmpty()) {
                return true;
            }
            if (blockState.getBlock() instanceof FluidBlock) {
                world.setBlockState(currentPos, Blocks.AIR.getDefaultState(), Block.NOTIFY_ALL);
            } else {
                return false;
            }
            return true;
        }) > 1;
    }
}
