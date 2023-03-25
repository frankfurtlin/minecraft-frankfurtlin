package com.frankfurtlin.frankfurtlinmod.gui.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.Nullable;

public class SuperBackPackInventory implements SidedInventory {
    private final ItemStack stack;
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(54, ItemStack.EMPTY);

    public SuperBackPackInventory(ItemStack itemStack) {
        this.stack = itemStack;
        NbtCompound tag = stack.getSubNbt("backpack");

        if (tag != null)
        {
            Inventories.readNbt(tag, items);
        }
    }

    public DefaultedList<ItemStack> getItems() {
        return items;
    }


    @Override
    public int[] getAvailableSlots(Direction side) {
        int[] result = new int[getItems().size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }

        return result;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, @Nullable Direction dir) {
        return true;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction dir) {
        return true;
    }

    @Override
    public int size() {
        return getItems().size();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < size(); i++) {
            ItemStack stack = getStack(i);

            if (!stack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getStack(int slot) {
        return getItems().get(slot);
    }

    @Override
    public ItemStack removeStack(int slot, int amount) {
        ItemStack result = Inventories.splitStack(getItems(), slot, amount);

        if (!result.isEmpty()) {
            markDirty();
        }

        return result;
    }

    @Override
    public ItemStack removeStack(int slot) {
        return Inventories.removeStack(getItems(), slot);
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        getItems().set(slot, stack);

        if (stack.getCount() > getMaxCountPerStack()) {
            stack.setCount(getMaxCountPerStack());
        }
    }

    @Override
    public void markDirty() {
        NbtCompound tag = stack.getOrCreateSubNbt("backpack");
        Inventories.writeNbt(tag, items);
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        return true;
    }

    @Override
    public void clear() {
        getItems().clear();
    }
}
