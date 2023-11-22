package com.frankfurtlin.frankfurtlinmod.datagen;

import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
            .add(ModBlocks.BUDDING_COAL)
            .add(ModBlocks.BUDDING_IRON)
            .add(ModBlocks.BUDDING_COPPER)
            .add(ModBlocks.BUDDING_LAPIS)
            .add(ModBlocks.BUDDING_GOLD)
            .add(ModBlocks.BUDDING_EMERALD)
            .add(ModBlocks.BUDDING_DIAMOND)
            .add(ModBlocks.BUDDING_REDSTONE)
            .add(ModBlocks.BUDDING_QUARTZ)
            .add(ModBlocks.BUDDING_NETHERITE)

            .add(ModBlocks.COAL_CLUSTER)
            .add(ModBlocks.IRON_CLUSTER)
            .add(ModBlocks.COPPER_CLUSTER)
            .add(ModBlocks.GOLD_CLUSTER)
            .add(ModBlocks.LAPIS_CLUSTER)
            .add(ModBlocks.EMERALD_CLUSTER)
            .add(ModBlocks.DIAMOND_CLUSTER)
            .add(ModBlocks.REDSTONE_CLUSTER)
            .add(ModBlocks.QUARTZ_CLUSTER)
            .add(ModBlocks.NETHERITE_CLUSTER)

            .add(ModBlocks.SMALL_COAL_BUD)
            .add(ModBlocks.SMALL_IRON_BUD)
            .add(ModBlocks.SMALL_COPPER_BUD)
            .add(ModBlocks.SMALL_GOLD_BUD)
            .add(ModBlocks.SMALL_LAPIS_BUD)
            .add(ModBlocks.SMALL_EMERALD_BUD)
            .add(ModBlocks.SMALL_DIAMOND_BUD)
            .add(ModBlocks.SMALL_REDSTONE_BUD)
            .add(ModBlocks.SMALL_QUARTZ_BUD)
            .add(ModBlocks.SMALL_NETHERITE_BUD)

            .add(ModBlocks.MEDIUM_COAL_BUD)
            .add(ModBlocks.MEDIUM_IRON_BUD)
            .add(ModBlocks.MEDIUM_COPPER_BUD)
            .add(ModBlocks.MEDIUM_GOLD_BUD)
            .add(ModBlocks.MEDIUM_LAPIS_BUD)
            .add(ModBlocks.MEDIUM_EMERALD_BUD)
            .add(ModBlocks.MEDIUM_DIAMOND_BUD)
            .add(ModBlocks.MEDIUM_REDSTONE_BUD)
            .add(ModBlocks.MEDIUM_QUARTZ_BUD)
            .add(ModBlocks.MEDIUM_NETHERITE_BUD)

            .add(ModBlocks.LARGE_COAL_BUD)
            .add(ModBlocks.LARGE_IRON_BUD)
            .add(ModBlocks.LARGE_COPPER_BUD)
            .add(ModBlocks.LARGE_GOLD_BUD)
            .add(ModBlocks.LARGE_LAPIS_BUD)
            .add(ModBlocks.LARGE_EMERALD_BUD)
            .add(ModBlocks.LARGE_DIAMOND_BUD)
            .add(ModBlocks.LARGE_REDSTONE_BUD)
            .add(ModBlocks.LARGE_QUARTZ_BUD)
            .add(ModBlocks.LARGE_NETHERITE_BUD);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
            .add(ModBlocks.BUDDING_COAL)
            .add(ModBlocks.BUDDING_IRON)
            .add(ModBlocks.BUDDING_COPPER)
            .add(ModBlocks.BUDDING_QUARTZ)

            .add(ModBlocks.COAL_CLUSTER)
            .add(ModBlocks.IRON_CLUSTER)
            .add(ModBlocks.COPPER_CLUSTER)
            .add(ModBlocks.QUARTZ_CLUSTER)

            .add(ModBlocks.SMALL_COAL_BUD)
            .add(ModBlocks.SMALL_IRON_BUD)
            .add(ModBlocks.SMALL_COPPER_BUD)
            .add(ModBlocks.SMALL_QUARTZ_BUD)

            .add(ModBlocks.MEDIUM_COAL_BUD)
            .add(ModBlocks.MEDIUM_IRON_BUD)
            .add(ModBlocks.MEDIUM_COPPER_BUD)
            .add(ModBlocks.MEDIUM_QUARTZ_BUD)

            .add(ModBlocks.LARGE_COAL_BUD)
            .add(ModBlocks.LARGE_IRON_BUD)
            .add(ModBlocks.LARGE_COPPER_BUD)
            .add(ModBlocks.LARGE_QUARTZ_BUD);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
            .add(ModBlocks.BUDDING_LAPIS)
            .add(ModBlocks.BUDDING_GOLD)
            .add(ModBlocks.BUDDING_EMERALD)
            .add(ModBlocks.BUDDING_DIAMOND)
            .add(ModBlocks.BUDDING_REDSTONE)

            .add(ModBlocks.GOLD_CLUSTER)
            .add(ModBlocks.LAPIS_CLUSTER)
            .add(ModBlocks.EMERALD_CLUSTER)
            .add(ModBlocks.DIAMOND_CLUSTER)
            .add(ModBlocks.REDSTONE_CLUSTER)

            .add(ModBlocks.SMALL_GOLD_BUD)
            .add(ModBlocks.SMALL_LAPIS_BUD)
            .add(ModBlocks.SMALL_EMERALD_BUD)
            .add(ModBlocks.SMALL_DIAMOND_BUD)
            .add(ModBlocks.SMALL_REDSTONE_BUD)

            .add(ModBlocks.MEDIUM_GOLD_BUD)
            .add(ModBlocks.MEDIUM_LAPIS_BUD)
            .add(ModBlocks.MEDIUM_EMERALD_BUD)
            .add(ModBlocks.MEDIUM_DIAMOND_BUD)
            .add(ModBlocks.MEDIUM_REDSTONE_BUD)

            .add(ModBlocks.LARGE_GOLD_BUD)
            .add(ModBlocks.LARGE_LAPIS_BUD)
            .add(ModBlocks.LARGE_EMERALD_BUD)
            .add(ModBlocks.LARGE_DIAMOND_BUD)
            .add(ModBlocks.LARGE_REDSTONE_BUD);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
            .add(ModBlocks.BUDDING_NETHERITE)
            .add(ModBlocks.NETHERITE_CLUSTER)
            .add(ModBlocks.SMALL_NETHERITE_BUD)
            .add(ModBlocks.MEDIUM_NETHERITE_BUD)
            .add(ModBlocks.LARGE_NETHERITE_BUD);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
            .add(ModBlocks.LAVA_SPONGE)
            .add(ModBlocks.LAVA_WET_SPONGE);

    }
}
