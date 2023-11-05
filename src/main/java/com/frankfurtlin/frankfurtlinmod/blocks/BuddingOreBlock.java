package com.frankfurtlin.frankfurtlinmod.blocks;

import net.minecraft.block.*;
import net.minecraft.fluid.Fluids;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;

public class BuddingOreBlock
extends Block {
    private static final Direction[] DIRECTIONS = Direction.values();

    private final String type;
    private final int growChance;

    public BuddingOreBlock(String type, int growChange, AbstractBlock.Settings settings) {
        super(settings);
        this.type = type;
        this.growChance = growChange;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(growChance) != 0) {
            return;
        }

        Direction direction = DIRECTIONS[random.nextInt(DIRECTIONS.length)];
        BlockPos blockPos = pos.offset(direction);
        BlockState blockState = world.getBlockState(blockPos);
        Block block = null;

        if (BuddingOreBlock.canGrowIn(blockState)) {
            block = getBlockFromTypeAndAge(type, 1);
        } else if (blockState.getBlock() instanceof OreClusterBlock
            && ((OreClusterBlock) blockState.getBlock()).age == 1
            && blockState.get(OreClusterBlock.FACING) == direction) {
            block = getBlockFromTypeAndAge(type, 2);
        } else if (blockState.getBlock() instanceof OreClusterBlock
            && ((OreClusterBlock) blockState.getBlock()).age == 2
            && blockState.get(OreClusterBlock.FACING) == direction) {
            block = getBlockFromTypeAndAge(type, 3);
        } else if (blockState.getBlock() instanceof OreClusterBlock
            && ((OreClusterBlock) blockState.getBlock()).age == 3
            && blockState.get(OreClusterBlock.FACING) == direction) {
            block = getBlockFromTypeAndAge(type, 4);
        }
        if (block != null) {
            BlockState blockState2 = block.getDefaultState()
                    .with(OreClusterBlock.FACING, direction)
                .with(OreClusterBlock.WATERLOGGED, blockState.getFluidState().getFluid() == Fluids.WATER);
            world.setBlockState(blockPos, blockState2);
        }
    }

    private static boolean canGrowIn(BlockState state) {
        return state.isAir() || state.isOf(Blocks.WATER) && state.getFluidState().getLevel() == 8;
    }

    private Block getBlockFromTypeAndAge(String type, int age){
        switch (type){
            case "coal" -> {
                if(age == 1){
                    return ModBlocks.SMALL_COAL_BUD;
                }
                else if(age == 2){
                    return ModBlocks.MEDIUM_COAL_BUD;
                }
                else if(age == 3){
                    return ModBlocks.LARGE_COAL_BUD;
                }
                else if(age == 4){
                    return ModBlocks.COAL_CLUSTER;
                }
            }
            case "iron" -> {
                if(age == 1){
                    return ModBlocks.SMALL_IRON_BUD;
                }
                else if(age == 2){
                    return ModBlocks.MEDIUM_IRON_BUD;
                }
                else if(age == 3){
                    return ModBlocks.LARGE_IRON_BUD;
                }
                else if(age == 4){
                    return ModBlocks.IRON_CLUSTER;
                }
            }
            case "copper" -> {
                if(age == 1){
                    return ModBlocks.SMALL_COPPER_BUD;
                }
                else if(age == 2){
                    return ModBlocks.MEDIUM_COPPER_BUD;
                }
                else if(age == 3){
                    return ModBlocks.LARGE_COPPER_BUD;
                }
                else if(age == 4){
                    return ModBlocks.COPPER_CLUSTER;
                }
            }
            case "gold" -> {
                if(age == 1){
                    return ModBlocks.SMALL_GOLD_BUD;
                }
                else if(age == 2){
                    return ModBlocks.MEDIUM_GOLD_BUD;
                }
                else if(age == 3){
                    return ModBlocks.LARGE_GOLD_BUD;
                }
                else if(age == 4){
                    return ModBlocks.GOLD_CLUSTER;
                }
            }
            case "lapis" -> {
                if(age == 1){
                    return ModBlocks.SMALL_LAPIS_BUD;
                }
                else if(age == 2){
                    return ModBlocks.MEDIUM_LAPIS_BUD;
                }
                else if(age == 3){
                    return ModBlocks.LARGE_LAPIS_BUD;
                }
                else if(age == 4){
                    return ModBlocks.LAPIS_CLUSTER;
                }
            }
            case "redstone" -> {
                if(age == 1){
                    return ModBlocks.SMALL_REDSTONE_BUD;
                }
                else if(age == 2){
                    return ModBlocks.MEDIUM_REDSTONE_BUD;
                }
                else if(age == 3){
                    return ModBlocks.LARGE_REDSTONE_BUD;
                }
                else if(age == 4){
                    return ModBlocks.REDSTONE_CLUSTER;
                }
            }
            case "diamond" -> {
                if(age == 1){
                    return ModBlocks.SMALL_DIAMOND_BUD;
                }
                else if(age == 2){
                    return ModBlocks.MEDIUM_DIAMOND_BUD;
                }
                else if(age == 3){
                    return ModBlocks.LARGE_DIAMOND_BUD;
                }
                else if(age == 4){
                    return ModBlocks.DIAMOND_CLUSTER;
                }
            }
            case "emerald" -> {
                if(age == 1){
                    return ModBlocks.SMALL_EMERALD_BUD;
                }
                else if(age == 2){
                    return ModBlocks.MEDIUM_EMERALD_BUD;
                }
                else if(age == 3){
                    return ModBlocks.LARGE_EMERALD_BUD;
                }
                else if(age == 4){
                    return ModBlocks.EMERALD_CLUSTER;
                }
            }
            case "quartz" -> {
                if(age == 1){
                    return ModBlocks.SMALL_QUARTZ_BUD;
                }
                else if(age == 2){
                    return ModBlocks.MEDIUM_QUARTZ_BUD;
                }
                else if(age == 3){
                    return ModBlocks.LARGE_QUARTZ_BUD;
                }
                else if(age == 4){
                    return ModBlocks.QUARTZ_CLUSTER;
                }
            }
            case "netherite" -> {
                if(age == 1){
                    return ModBlocks.SMALL_NETHERITE_BUD;
                }
                else if(age == 2){
                    return ModBlocks.MEDIUM_NETHERITE_BUD;
                }
                else if(age == 3){
                    return ModBlocks.LARGE_NETHERITE_BUD;
                }
                else if(age == 4){
                    return ModBlocks.NETHERITE_CLUSTER;
                }
            }


        }
        return Blocks.AIR;

    }


}