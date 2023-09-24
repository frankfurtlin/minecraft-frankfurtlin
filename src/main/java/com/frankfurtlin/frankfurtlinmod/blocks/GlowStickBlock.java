package com.frankfurtlin.frankfurtlinmod.blocks;

import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.minecraft.block.*;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class GlowStickBlock extends FallingBlock {
    public static final VoxelShape shape = Block.createCuboidShape(2, 0, 2, 14, 2, 14);
    public GlowStickBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return shape;
    }

    @Override
    public Item asItem() {
        return ModItems.GLOW_STICK;
    }
}