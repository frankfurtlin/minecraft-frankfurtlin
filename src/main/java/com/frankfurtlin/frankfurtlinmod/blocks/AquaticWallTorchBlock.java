package com.frankfurtlin.frankfurtlinmod.blocks;

import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

/**
 * 墙壁水蜡烛
 */
public class AquaticWallTorchBlock extends WallTorchBlock implements Waterloggable {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    public static final IntProperty FLOWING_WATER = IntProperty.of("water_level", 1, 8);

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     *
     * @param settings settings
     * @param particle particle
     */
    public AquaticWallTorchBlock(Settings settings, ParticleEffect particle) {
        super(settings, particle);
        setDefaultState(this.stateManager.getDefaultState().with(WATERLOGGED, false).with(FLOWING_WATER, 8));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, FLOWING_WATER, WATERLOGGED);
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockstate = this.getDefaultState();
        WorldView worldView = ctx.getWorld();
        BlockPos blockpos = ctx.getBlockPos();
        Direction[] adirection = ctx.getPlacementDirections();

        for(Direction direction : adirection) {
            if (direction.getAxis().isHorizontal()) {
                Direction direction1 = direction.getOpposite();
                blockstate = blockstate.with(FACING, direction1);
                if (blockstate.canPlaceAt(worldView, blockpos)) {
                    break;
                }
            }
        }

        FluidState fluidstate = ctx.getWorld().getFluidState(ctx.getBlockPos());
        boolean flag = fluidstate.getFluid() == Fluids.WATER || fluidstate.getFluid() == Fluids.FLOWING_WATER;
        boolean is_flowing = fluidstate.getFluid() == Fluids.FLOWING_WATER;
        return blockstate.with(WATERLOGGED, flag).with(FLOWING_WATER, is_flowing ? fluidstate.getLevel() : 8);

    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction,
                                                BlockState neighborState, WorldAccess world,
                                                BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED)) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        if (direction.getOpposite() == state.get(FACING) && !state.isFullCube(world, pos)) {
            return Blocks.AIR.getDefaultState();
        } else {
            return state;
        }
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED) && state.get(FLOWING_WATER) == 8) {
            return Fluids.WATER.getStill(false);
        } else if (state.get(WATERLOGGED) && state.get(FLOWING_WATER) != 8) {
            return Fluids.WATER.getFlowing(state.get(FLOWING_WATER), false);
        }
        return Fluids.EMPTY.getDefaultState();
    }


    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction direction = state.get(FACING);
        double d = (double)pos.getX() + 0.5;
        double e = (double)pos.getY() + 0.7;
        double f = (double)pos.getZ() + 0.5;
        Direction direction2 = direction.getOpposite();
        world.addParticle(ParticleTypes.UNDERWATER, d + 0.27 * (double)direction2.getOffsetX(), e + 0.22, f + 0.27 * (double)direction2.getOffsetZ(), 0.0, 0.0, 0.0);
        world.addParticle(this.particle, d + 0.27 * (double)direction2.getOffsetX(), e + 0.22, f + 0.27 * (double)direction2.getOffsetZ(), 0.0, 0.0, 0.0);
    }

}