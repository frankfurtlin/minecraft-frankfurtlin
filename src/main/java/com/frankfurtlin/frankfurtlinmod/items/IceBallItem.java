package com.frankfurtlin.frankfurtlinmod.items;

import com.frankfurtlin.frankfurtlinmod.entity.IceBallEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.function.Consumer;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/18 21:47
 */
public class IceBallItem extends Item {
    private final int damage;
    private final int coolDown;
    private final Consumer<IceBallEntity> onCollide;

    public IceBallItem(Settings settings, int damage, int coolDown) {
        this(settings, damage, coolDown, ball -> {});
    }

    public IceBallItem(Settings settings, int damage, int coolDown, Consumer<IceBallEntity> onCollide) {
        super(settings);
        this.damage = damage;
        this.coolDown = coolDown;
        this.onCollide = onCollide;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F));
        user.getItemCooldownManager().set(this, coolDown);
        if (!world.isClient) {
            IceBallEntity iceBallEntity = new IceBallEntity(world, user, damage, onCollide);
            iceBallEntity.setItem(itemStack);
            iceBallEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(iceBallEntity);
        }
        user.incrementStat(Stats.USED.getOrCreateStat(this));
        if (!user.getAbilities().creativeMode) {
            itemStack.decrement(1);
        }
        return TypedActionResult.success(itemStack, world.isClient());
    }

}
