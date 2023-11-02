package com.frankfurtlin.frankfurtlinmod.entity;

import com.frankfurtlin.frankfurtlinmod.blocks.GlowStickBlock;
import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * 荧光棒实体
 */
public class GlowStickEntity extends ThrownItemEntity{
    public GlowStickEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public GlowStickEntity(World world, LivingEntity owner) {
        super(ModEntities.GLOW_STICK_ENTITY, owner, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.GLOW_STICK;
    }

    @Override
    protected void onCollision(HitResult hitResult) {
        super.onCollision(hitResult);
        if (!this.getWorld().isClient()) {
            this.remove(RemovalReason.DISCARDED);
            BlockPos pos = BlockPos.ofFloored(this.getX(), this.getY(), this.getZ());
            if (this.getWorld().getBlockState(pos).isAir()) {
                this.getWorld().setBlockState(pos, ModBlocks.GLOW_STICK_BLOCK.getDefaultState()
                    .with(GlowStickBlock.FLIPPED, getWorld().getRandom().nextBoolean()));
                this.getWorld().playSound(null, pos.getX(), pos.getY(), pos.getZ(),
                    SoundEvents.BLOCK_GLASS_PLACE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            } else {
                ItemStack stack = new ItemStack(ModItems.GLOW_STICK, 1);
                ItemEntity entity = new ItemEntity(this.getWorld(), this.getX(), this.getY(), this.getZ(), stack);
                this.getWorld().spawnEntity(entity);
            }
        }
    }
}