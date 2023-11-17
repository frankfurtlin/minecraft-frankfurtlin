package com.frankfurtlin.frankfurtlinmod.datagen;

import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
            .add(ModItems.WHITE_GOLD_HELMET,
                ModItems.WHITE_GOLD_CHESTPLATE,
                ModItems.WHITE_GOLD_LEGGINGS,
                ModItems.WHITE_GOLD_BOOTS);

        getOrCreateTagBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES)
            .add(ModItems.WHITE_GOLD_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
            .add(ModItems.WHITE_GOLD_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
            .add(ModItems.WHITE_GOLD_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
            .add(ModItems.WHITE_GOLD_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
            .add(ModItems.WHITE_GOLD_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
            .add(ModItems.WHITE_GOLD_HOE);

    }
}
