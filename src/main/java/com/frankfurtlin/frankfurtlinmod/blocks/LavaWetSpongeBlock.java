package com.frankfurtlin.frankfurtlinmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/22 11:59
 */
public class LavaWetSpongeBlock extends Block {
    public LavaWetSpongeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBlockAdded(BlockState state, World world, BlockPos pos, BlockState oldState, boolean notify) {
        if (!world.getDimension().ultrawarm()) {
            world.setBlockState(pos, ModBlocks.LAVA_SPONGE.getDefaultState(), Block.NOTIFY_ALL);
            world.syncWorldEvent(WorldEvents.WET_SPONGE_DRIES_OUT, pos, 0);
            world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS,
                1.0f, (1.0f + world.getRandom().nextFloat() * 0.2f) * 0.7f);
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        Direction direction = Direction.random(random);
        if (direction == Direction.UP) {
            return;
        }
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        if (state.isOpaque() && blockState.isSideSolidFullSquare(world, blockPos, direction.getOpposite())) {
            return;
        }
        double d = pos.getX();
        double e = pos.getY();
        double f = pos.getZ();
        if (direction == Direction.DOWN) {
            e -= 0.05;
            d += random.nextDouble();
            f += random.nextDouble();
        } else {
            e += random.nextDouble() * 0.8;
            if (direction.getAxis() == Direction.Axis.X) {
                f += random.nextDouble();
                if (direction == Direction.EAST) {
                    d += 1.1;
                } else {
                    d += 0.05;
                }
            } else {
                d += random.nextDouble();
                if (direction == Direction.SOUTH) {
                    f += 1.1;
                } else {
                    f += 0.05;
                }
            }
        }
        world.addParticle(ParticleTypes.DRIPPING_LAVA, d, e, f, 0.0, 0.0, 0.0);
    }
}
