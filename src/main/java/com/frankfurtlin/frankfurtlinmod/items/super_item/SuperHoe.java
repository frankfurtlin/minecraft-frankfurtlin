package com.frankfurtlin.frankfurtlinmod.items.super_item;

import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.predicate.entity.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/23 16:44
 * 一键收割农作物、并且补种
 * 一键捡掉落物
 */
public class SuperHoe extends HoeItem {
    private static final int rangeRadius = 10;
    private static final int rangeHeight = 10;

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     *
     * @param material     材料
     * @param attackDamage 伤害
     * @param attackSpeed  攻击速度
     * @param settings     设置
     */
    public SuperHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user == null) {
            return TypedActionResult.pass(null);
        }
        ItemStack itemStack = user.getStackInHand(hand);
        if (world == null) {
            return TypedActionResult.pass(itemStack);
        }
        applyBreakCrops(
            world,
            user,
            user.getBlockPos()
        );
        return TypedActionResult.success(itemStack, true);
    }

    /**
     * 收获周围的农作物
     * 捡取周围的掉落物
     *
     * @param world world
     * @param pos   pos
     */
    private void applyBreakCrops(World world, PlayerEntity user, BlockPos pos) {
        BlockPos.iterateOutwards(pos, SuperHoe.rangeRadius, SuperHoe.rangeHeight, SuperHoe.rangeRadius).forEach(blockPos -> {
            BlockState blockState = world.getBlockState(blockPos);
            Block block = blockState.getBlock();
            BlockState defaultState = block.getDefaultState();

            if(block instanceof Fertilizable){
                if(!((Fertilizable) block).isFertilizable(world, blockPos, blockState)){
                    if(block instanceof CropBlock){
                        world.breakBlock(blockPos, true);
                        world.setBlockState(blockPos, defaultState);
                    }
                    else if (block instanceof CaveVinesBodyBlock || block instanceof CaveVinesHeadBlock) {
                        if (CaveVines.hasBerries(blockState)) {
                            CaveVines.pickBerries(user, blockState, world, blockPos);
                        }
                    }
                    else if (block instanceof CocoaBlock) {
                        world.breakBlock(blockPos, true);
                        world.setBlockState(blockPos, defaultState);
                    }
                    else if (block instanceof BambooBlock) {
                        Block floorBlock = world.getBlockState(blockPos.down()).getBlock();
                        if (!(floorBlock instanceof BambooBlock) && !(floorBlock instanceof BambooSaplingBlock) && floorBlock != Blocks.AIR) {
                            world.breakBlock(blockPos.up(), true);
                            world.setBlockState(blockPos, Blocks.BAMBOO_SAPLING.getDefaultState());
                        }
                    }
                } else if (block instanceof MelonBlock || block instanceof PumpkinBlock) {
                    world.breakBlock(blockPos, true);
                } else if (block instanceof SugarCaneBlock) {
                    Block floorBlock = world.getBlockState(blockPos.down()).getBlock();
                    if (!(floorBlock instanceof SugarCaneBlock)) {
                        world.breakBlock(blockPos.up(), true);
                    }
                } else if (block instanceof CactusBlock) {
                    Block floorBlock = world.getBlockState(blockPos.down()).getBlock();
                    if (!(floorBlock instanceof CactusBlock)) {
                        world.breakBlock(blockPos.up(), true);
                    }
                } else if (block instanceof ChorusPlantBlock) {
                    BlockState floor = world.getBlockState(blockPos.down());
                    if (floor.getBlock() == Blocks.END_STONE) {
                        AtomicBoolean foundMatureFlower = new AtomicBoolean(false);
                        BlockPos.iterateOutwards(pos, 5, 50, 5).forEach(chorusPos -> {
                            BlockState chorusBlockState = world.getBlockState(chorusPos);
                            Block chorusBlock = chorusBlockState.getBlock();
                            if (chorusBlock instanceof ChorusFlowerBlock) {
                                if (chorusBlockState.get(ChorusFlowerBlock.AGE) >= 3) {
                                    foundMatureFlower.set(true);
                                    BlockHitResult hitResult = new BlockHitResult(new Box(chorusPos).getCenter(), Direction.WEST, chorusPos, false);
                                    chorusBlockState.onProjectileHit(world, blockState, hitResult, EntityType.SNOWBALL.create(world));
                                }
                            }
                        });

                        if (foundMatureFlower.get()) {
                            world.setBlockState(blockPos, Blocks.CHORUS_FLOWER.getDefaultState());
                        }
                    }
                }
            }
        });
        pickupDrops(world, pos, user);
    }

    private void pickupDrops(World world, BlockPos pos, PlayerEntity player) {
        BlockPos pos1 = new BlockPos(pos.getX() - rangeRadius, pos.getY() - rangeHeight, pos.getZ() - rangeRadius);
        BlockPos pos2 = new BlockPos(pos.getX() + rangeRadius, pos.getY() + rangeHeight, pos.getZ() + rangeRadius);
        List<ItemEntity> drops = world.getEntitiesByClass(ItemEntity.class, new Box(pos1, pos2), EntityPredicates.VALID_ENTITY);
        drops.forEach(item -> {
            ItemStack stack = item.getStack();
            player.getInventory().insertStack(stack);
            if (stack.getCount() <= 0){
                item.discard();
            }
        });

    }
}
