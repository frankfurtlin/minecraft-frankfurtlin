package com.frankfurtlin.frankfurtlinmod.enchantment;

import com.frankfurtlin.frankfurtlinmod.blocks.HotObsidianBlock;
import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/28 17:56
 * 熔岩行者附魔
 */
public class HotWalkerEnchantment extends Enchantment {
    protected HotWalkerEnchantment() {
        super(Rarity.RARE, EnchantmentTarget.ARMOR_FEET, new EquipmentSlot[]{EquipmentSlot.FEET});
    }

    @Override
    public int getMinPower(int level) {
        return level * 10;
    }

    @Override
    public int getMaxPower(int level) {
        return this.getMinPower(level) + 15;
    }

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    public static void hotLava(LivingEntity entity, World world, BlockPos blockPos, int level) {
        if (!entity.isOnGround()) {
            return;
        }
        BlockState blockState = ModBlocks.HOT_OBSIDIAN.getDefaultState();
        int i = Math.min(16, 2 + level);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (BlockPos blockPos2 : BlockPos.iterate(blockPos.add(-i, -1, -i), blockPos.add(i, -1, i))) {
            if (!blockPos2.isWithinDistance(entity.getPos(), i)) continue;
            mutable.set(blockPos2.getX(), blockPos2.getY() + 1, blockPos2.getZ());
            BlockState blockState2 = world.getBlockState(mutable);
            if (!blockState2.isAir() || world.getBlockState(blockPos2) != HotObsidianBlock.getMeltedState()
                || !blockState.canPlaceAt(world, blockPos2)
                || !world.canPlace(blockState, blockPos2, ShapeContext.absent())) continue;
            world.setBlockState(blockPos2, blockState);
            world.scheduleBlockTick(blockPos2, ModBlocks.HOT_OBSIDIAN,
                MathHelper.nextInt(entity.getRandom(), 60, 120));
        }
    }

    @Override
    public boolean canAccept(Enchantment other) {
        return super.canAccept(other) && other != ModEnchantments.WALK_ON_FLUID;
    }
}
