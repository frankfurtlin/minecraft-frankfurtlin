package com.frankfurtlin.frankfurtlinmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.TorchBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

/**
 * 水蜡烛
 */
public class AquaticTorchBlock extends TorchBlock implements Waterloggable {
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final IntProperty FLOWING_WATER = IntProperty.of("water_level", 1, 8);

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     *
     * @param settings settings
     * @param particle particle
     */
    public AquaticTorchBlock(Settings settings, ParticleEffect particle) {
        super(settings, particle);
        this.setDefaultState(this.getDefaultState().with(WATERLOGGED, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FLOWING_WATER, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext placeContext) {
        FluidState fluidstate = placeContext.getWorld().getFluidState(placeContext.getBlockPos());
        boolean flag = fluidstate.getFluid() == Fluids.WATER || fluidstate.getFluid() == Fluids.FLOWING_WATER;
        boolean is_flowing = fluidstate.getFluid() == Fluids.FLOWING_WATER;
        return this.getDefaultState().with(WATERLOGGED, flag).with(FLOWING_WATER, is_flowing ? fluidstate.getLevel() : 8);
    }

    @Override
    public FluidState getFluidState(BlockState blockState) {
        if (blockState.get(WATERLOGGED) && blockState.get(FLOWING_WATER) == 8) {
            return Fluids.WATER.getStill(false);
        } else if (blockState.get(WATERLOGGED) && blockState.get(FLOWING_WATER) != 8) {
            return Fluids.WATER.getFlowing(blockState.get(FLOWING_WATER), false);
        }
        return Fluids.EMPTY.getDefaultState();
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        double d = (double)pos.getX() + 0.5;
        double e = (double)pos.getY() + 0.7;
        double f = (double)pos.getZ() + 0.5;
        world.addParticle(ParticleTypes.UNDERWATER, d, e, f, 0.0, 0.0, 0.0);
        world.addParticle(this.particle, d, e, f, 0.0, 0.0, 0.0);
    }

}