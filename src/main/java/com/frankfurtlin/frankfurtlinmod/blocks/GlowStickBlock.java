package com.frankfurtlin.frankfurtlinmod.blocks;

import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

/**
 * 荧光棒
 */
@SuppressWarnings("deprecation")
public class GlowStickBlock extends FallingBlock {
    public static final VoxelShape shape = Block.createCuboidShape(2, 0, 2, 14, 2, 14);
    public static final BooleanProperty FLIPPED = BooleanProperty.of("flipped");
    public GlowStickBlock(AbstractBlock.Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(FLIPPED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FLIPPED);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }

    @Override
    public Item asItem() {
        return ModItems.GLOW_STICK;
    }
}