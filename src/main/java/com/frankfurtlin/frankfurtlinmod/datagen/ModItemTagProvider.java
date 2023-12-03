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
            .add(ModItems.WARDEN_HELMET,
                ModItems.WARDEN_CHESTPLATE,
                ModItems.WARDEN_LEGGINGS,
                ModItems.WARDEN_BOOTS);

        getOrCreateTagBuilder(ItemTags.CLUSTER_MAX_HARVESTABLES)
            .add(ModItems.WARDEN_PICKAXE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
            .add(ModItems.WARDEN_SWORD);

        getOrCreateTagBuilder(ItemTags.PICKAXES)
            .add(ModItems.WARDEN_PICKAXE);

        getOrCreateTagBuilder(ItemTags.AXES)
            .add(ModItems.WARDEN_AXE);

        getOrCreateTagBuilder(ItemTags.SHOVELS)
            .add(ModItems.WARDEN_SHOVEL);

        getOrCreateTagBuilder(ItemTags.HOES)
            .add(ModItems.WARDEN_HOE);

    }
}
