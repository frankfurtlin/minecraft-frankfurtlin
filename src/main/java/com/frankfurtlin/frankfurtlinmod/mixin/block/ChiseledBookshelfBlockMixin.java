package com.frankfurtlin.frankfurtlinmod.mixin.block;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChiseledBookshelfBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.ChiseledBookshelfBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.state.property.Property;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/30 19:57
 * 雕纹书架可以放置唱片
 */
@Mixin(ChiseledBookshelfBlock.class)
public class ChiseledBookshelfBlockMixin {
    @Invoker("getHitPos")
    static Optional<Vec2f> getHitPos(BlockHitResult hit, Direction facing){
        throw new AssertionError();
    }

    @Invoker("getSlotForHitPos")
    static int getSlotForHitPos(Vec2f hitPos){
        throw new AssertionError();
    }

    @Inject(
        method = "onUse",
        at = @At("HEAD"),
        cancellable = true
    )
    public void onUsingRecord(
            BlockState state,
            World world,
            BlockPos pos,
            PlayerEntity player,
            Hand hand,
            BlockHitResult hit,
            CallbackInfoReturnable<ActionResult> callbackInfo) {
        if(!ModConfig.INSTANCE.chiseledBookshelfStoreMusicDiscs){
            return;
        }
        BlockEntity maybeBookshelf = world.getBlockEntity(pos);
        if (maybeBookshelf instanceof ChiseledBookshelfBlockEntity chiseledBookshelfBlockEntity) {
            Optional<Vec2f> shelf = getHitPos(hit, state.get(HorizontalFacingBlock.FACING));
            if (shelf.isPresent()) {
                int slot = getSlotForHitPos(shelf.get());
                if (!(Boolean)state.get((Property<?>)ChiseledBookshelfBlock.SLOT_OCCUPIED_PROPERTIES.get(slot)))
                {
                    ItemStack itemStack = player.getStackInHand(hand);
                    if (itemStack.isIn(ItemTags.MUSIC_DISCS)) {
                        tryAddRecord(world, pos, player, chiseledBookshelfBlockEntity, itemStack, slot);
                        callbackInfo.setReturnValue(ActionResult.success(world.isClient));
                        callbackInfo.cancel();
                    }
                }
            }
        }
    }

    @Unique
    private static void tryAddRecord(World world, BlockPos pos, PlayerEntity player,
                                     ChiseledBookshelfBlockEntity blockEntity, ItemStack stack, int slot) {
        if (!world.isClient) {
            // treat it like an enchanted book
            player.incrementStat(Stats.USED.getOrCreateStat(stack.getItem()));
            SoundEvent soundEvent = SoundEvents.BLOCK_CHISELED_BOOKSHELF_INSERT_ENCHANTED;
            blockEntity.setStack(slot, stack.split(1));
            world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, 1.0F, 1.0F);
            if (player.isCreative()) {
                stack.increment(1);
            }
            world.emitGameEvent(player, GameEvent.BLOCK_CHANGE, pos);
        }
    }
}
