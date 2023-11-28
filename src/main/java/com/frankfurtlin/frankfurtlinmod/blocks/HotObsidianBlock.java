package com.frankfurtlin.frankfurtlinmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

/**
 * 熔岩黑曜石（熔岩行者产出）
 */
public class HotObsidianBlock extends Block {

    public static final int MAX_AGE = 5;
    public static final IntProperty AGE = Properties.AGE_5;

    public static BlockState getMeltedState() {
        return Blocks.LAVA.getDefaultState();
    }

    public HotObsidianBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(AGE, 0));
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.scheduledTick(state, world, pos, random);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if ((random.nextInt(3) == 0 || this.canMelt(world, pos, 4))
            && this.increaseAge(state, world, pos)) {
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            for (Direction direction : Direction.values()) {
                mutable.set(pos, direction);
                BlockState blockState = world.getBlockState(mutable);
                if (!blockState.isOf(this) || this.increaseAge(blockState, world, mutable)) continue;
                world.scheduleBlockTick(mutable, this, MathHelper.nextInt(random, 20, 40));
            }
            return;
        }
        world.scheduleBlockTick(pos, this, MathHelper.nextInt(random, 20, 40));
    }

    private boolean increaseAge(BlockState state, World world, BlockPos pos) {
        int i = state.get(AGE);
        if (i < MAX_AGE) {
            world.setBlockState(pos, state.with(AGE, i + 1), Block.NOTIFY_LISTENERS);
            return false;
        }
        this.melt(world, pos);
        return true;
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock,
                               BlockPos sourcePos, boolean notify) {
        if (sourceBlock.getDefaultState().isOf(this) && this.canMelt(world, pos, 2)) {
            this.melt(world, pos);
        }
        super.neighborUpdate(state, world, pos, sourceBlock, sourcePos, notify);
    }

    protected void melt(World world, BlockPos pos) {
        world.setBlockState(pos, getMeltedState());
        world.updateNeighbor(pos, getMeltedState().getBlock(), pos);
    }

    private boolean canMelt(BlockView world, BlockPos pos, int maxNeighbors) {
        int i = 0;
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (Direction direction : Direction.values()) {
            mutable.set(pos, direction);
            if (!world.getBlockState(mutable).isOf(this) || ++i < maxNeighbors) continue;
            return false;
        }
        return true;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    public ItemStack getPickStack(BlockView world, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }
}