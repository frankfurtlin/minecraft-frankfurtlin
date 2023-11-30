package com.frankfurtlin.frankfurtlinmod.mixin.entity;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.block.entity.ChiseledBookshelfBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/30 20:23
 * 雕纹书架可以放置唱片
 */
@Mixin(ChiseledBookshelfBlockEntity.class)
public abstract class ChiseledBookshelfBlockEntityMixin {
    @Final
    @Shadow
    private
    DefaultedList<ItemStack> inventory;

    @Shadow
    protected abstract void updateState(int slot);

    @Shadow public abstract ItemStack getStack(int slot);

    @Shadow public abstract ItemStack removeStack(int slot, int amount);

    /**
     * @author frankfurtlin
     * @reason 雕纹书架可以放置唱片
     */
    @Overwrite
    public boolean isValid(int slot, ItemStack stack) {
        if(!ModConfig.INSTANCE.chiseledBookshelfStoreMusicDiscs){
            return stack.isIn(ItemTags.BOOKSHELF_BOOKS) && getStack(slot).isEmpty();
        }
        return (
            stack.isIn(ItemTags.BOOKSHELF_BOOKS)
                || stack.isIn(ItemTags.MUSIC_DISCS)
        ) && ((ChiseledBookshelfBlockEntity)(Object)this).getStack(slot).isEmpty();
    }


    /**
     * @author frankfurtlin
     * @reason 雕纹书架可以放置唱片
     */
    @Overwrite
    public void setStack(int slot, ItemStack stack) {
        if(!ModConfig.INSTANCE.chiseledBookshelfStoreMusicDiscs){
            if (stack.isIn(ItemTags.BOOKSHELF_BOOKS)) {
                this.inventory.set(slot, stack);
                this.updateState(slot);
            } else if (stack.isEmpty()) {
                removeStack(slot, 1);
            }
        }
        else{
            if (stack.isIn(ItemTags.BOOKSHELF_BOOKS) || stack.isIn(ItemTags.MUSIC_DISCS)) {
                this.inventory.set(slot, stack);
                this.updateState(slot);
            } else if (stack.isEmpty()) {
                removeStack(slot, 1);
            }
        }


    }
}
