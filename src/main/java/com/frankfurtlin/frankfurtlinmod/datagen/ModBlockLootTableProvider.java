package com.frankfurtlin.frankfurtlinmod.datagen;

import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.CropBlock;
import net.minecraft.data.server.loottable.vanilla.VanillaBlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.tag.ItemTags;

public class ModBlockLootTableProvider extends FabricBlockLootTableProvider {
    public ModBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.GLOW_STICK_BLOCK);
        addDrop(ModBlocks.AQUATIC_TORCH);
        addDrop(ModBlocks.AQUATIC_WALL_TORCH);
        addDrop(ModBlocks.LAVA_SPONGE);
        addDrop(ModBlocks.LAVA_WET_SPONGE);
        addDrop(ModBlocks.HOT_OBSIDIAN, VanillaBlockLootTableGenerator.dropsNothing());

        addDrop(ModBlocks.WHITE_GOLD_BLOCK);

        // 水果蔬菜
        addDrop(ModBlocks.STRAWBERRY_CROP, applyExplosionDecay(ModBlocks.STRAWBERRY_CROP,
            LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(ModItems.STRAWBERRY))).pool(LootPool.builder()
                .conditionally(cropBlockDrops(ModBlocks.STRAWBERRY_CROP)).with(ItemEntry.builder(ModItems.STRAWBERRY)
                    .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3))))));
        addDrop(ModBlocks.BLACKBERRY_CROP, applyExplosionDecay(ModBlocks.BLACKBERRY_CROP,
            LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(ModItems.BLACKBERRY))).pool(LootPool.builder()
                .conditionally(cropBlockDrops(ModBlocks.BLACKBERRY_CROP)).with(ItemEntry.builder(ModItems.BLACKBERRY)
                    .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3))))));
        addDrop(ModBlocks.BLUEBERRY_CROP, applyExplosionDecay(ModBlocks.BLUEBERRY_CROP,
            LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(ModItems.BLUEBERRY))).pool(LootPool.builder()
                .conditionally(cropBlockDrops(ModBlocks.BLUEBERRY_CROP)).with(ItemEntry.builder(ModItems.BLUEBERRY)
                    .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3))))));
        addDrop(ModBlocks.CORN_CROP, applyExplosionDecay(ModBlocks.CORN_CROP,
            LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(ModItems.CORN))).pool(LootPool.builder()
                .conditionally(cropBlockDrops(ModBlocks.CORN_CROP)).with(ItemEntry.builder(ModItems.CORN)
                    .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3))))));
        addDrop(ModBlocks.GRAPE_CROP, applyExplosionDecay(ModBlocks.GRAPE_CROP,
            LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(ModItems.GRAPE))).pool(LootPool.builder()
                .conditionally(cropBlockDrops(ModBlocks.GRAPE_CROP)).with(ItemEntry.builder(ModItems.GRAPE)
                    .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3))))));
        addDrop(ModBlocks.KIWI_CROP, applyExplosionDecay(ModBlocks.KIWI_CROP,
            LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(ModItems.KIWI))).pool(LootPool.builder()
                .conditionally(cropBlockDrops(ModBlocks.KIWI_CROP)).with(ItemEntry.builder(ModItems.KIWI)
                    .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3))))));
        addDrop(ModBlocks.PINEAPPLE_CROP, applyExplosionDecay(ModBlocks.PINEAPPLE_CROP,
            LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(ModItems.PINEAPPLE))).pool(LootPool.builder()
                .conditionally(cropBlockDrops(ModBlocks.PINEAPPLE_CROP)).with(ItemEntry.builder(ModItems.PINEAPPLE)
                    .apply(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286f, 3))))));

        // 矿物簇母岩
        addDropWithSilkTouch(ModBlocks.BUDDING_COAL);
        addDropWithSilkTouch(ModBlocks.BUDDING_IRON);
        addDropWithSilkTouch(ModBlocks.BUDDING_COPPER);
        addDropWithSilkTouch(ModBlocks.BUDDING_GOLD);
        addDropWithSilkTouch(ModBlocks.BUDDING_EMERALD);
        addDropWithSilkTouch(ModBlocks.BUDDING_LAPIS);
        addDropWithSilkTouch(ModBlocks.BUDDING_DIAMOND);
        addDropWithSilkTouch(ModBlocks.BUDDING_REDSTONE);
        addDropWithSilkTouch(ModBlocks.BUDDING_QUARTZ);
        addDropWithSilkTouch(ModBlocks.BUDDING_NETHERITE);
        // 矿物簇
        addDrop(ModBlocks.COAL_CLUSTER, oreClusterDrops(ModBlocks.COAL_CLUSTER, Items.COAL));
        addDrop(ModBlocks.IRON_CLUSTER, oreClusterDrops(ModBlocks.IRON_CLUSTER, Items.IRON_INGOT));
        addDrop(ModBlocks.COPPER_CLUSTER, oreClusterDrops(ModBlocks.COPPER_CLUSTER, Items.COPPER_INGOT));
        addDrop(ModBlocks.GOLD_CLUSTER, oreClusterDrops(ModBlocks.GOLD_CLUSTER, Items.GOLD_INGOT));
        addDrop(ModBlocks.LAPIS_CLUSTER, oreClusterDrops(ModBlocks.LAPIS_CLUSTER, Items.LAPIS_LAZULI));
        addDrop(ModBlocks.EMERALD_CLUSTER, oreClusterDrops(ModBlocks.EMERALD_CLUSTER, Items.EMERALD));
        addDrop(ModBlocks.DIAMOND_CLUSTER, oreClusterDrops(ModBlocks.DIAMOND_CLUSTER, Items.DIAMOND));
        addDrop(ModBlocks.REDSTONE_CLUSTER, oreClusterDrops(ModBlocks.REDSTONE_CLUSTER, Items.REDSTONE));
        addDrop(ModBlocks.QUARTZ_CLUSTER, oreClusterDrops(ModBlocks.QUARTZ_CLUSTER, Items.QUARTZ));
        addDrop(ModBlocks.NETHERITE_CLUSTER, oreClusterDrops(ModBlocks.NETHERITE_CLUSTER, Items.NETHERITE_INGOT));
        // 小型矿物簇
        addDropWithSilkTouch(ModBlocks.SMALL_COAL_BUD);
        addDropWithSilkTouch(ModBlocks.SMALL_IRON_BUD);
        addDropWithSilkTouch(ModBlocks.SMALL_COPPER_BUD);
        addDropWithSilkTouch(ModBlocks.SMALL_GOLD_BUD);
        addDropWithSilkTouch(ModBlocks.SMALL_LAPIS_BUD);
        addDropWithSilkTouch(ModBlocks.SMALL_EMERALD_BUD);
        addDropWithSilkTouch(ModBlocks.SMALL_DIAMOND_BUD);
        addDropWithSilkTouch(ModBlocks.SMALL_REDSTONE_BUD);
        addDropWithSilkTouch(ModBlocks.SMALL_QUARTZ_BUD);
        addDropWithSilkTouch(ModBlocks.SMALL_NETHERITE_BUD);
        // 中型矿物簇
        addDropWithSilkTouch(ModBlocks.MEDIUM_COAL_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_IRON_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_COPPER_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_GOLD_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_LAPIS_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_EMERALD_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_DIAMOND_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_REDSTONE_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_QUARTZ_BUD);
        addDropWithSilkTouch(ModBlocks.MEDIUM_NETHERITE_BUD);
        // 大型矿物簇
        addDropWithSilkTouch(ModBlocks.LARGE_COAL_BUD);
        addDropWithSilkTouch(ModBlocks.LARGE_IRON_BUD);
        addDropWithSilkTouch(ModBlocks.LARGE_COPPER_BUD);
        addDropWithSilkTouch(ModBlocks.LARGE_GOLD_BUD);
        addDropWithSilkTouch(ModBlocks.LARGE_LAPIS_BUD);
        addDropWithSilkTouch(ModBlocks.LARGE_EMERALD_BUD);
        addDropWithSilkTouch(ModBlocks.LARGE_DIAMOND_BUD);
        addDropWithSilkTouch(ModBlocks.LARGE_REDSTONE_BUD);
        addDropWithSilkTouch(ModBlocks.LARGE_QUARTZ_BUD);
        addDropWithSilkTouch(ModBlocks.LARGE_NETHERITE_BUD);
        // 矿物甘蔗
        addDrop(ModBlocks.COAL_CANE);
        addDrop(ModBlocks.IRON_CANE);
        addDrop(ModBlocks.COPPER_CANE);
        addDrop(ModBlocks.GOLD_CANE);
        addDrop(ModBlocks.LAPIS_CANE);
        addDrop(ModBlocks.EMERALD_CANE);
        addDrop(ModBlocks.DIAMOND_CANE);
        addDrop(ModBlocks.REDSTONE_CANE);
        addDrop(ModBlocks.QUARTZ_CANE);
        addDrop(ModBlocks.NETHERITE_CANE);

    }

    private BlockStatePropertyLootCondition.Builder cropBlockDrops(Block block){
        return BlockStatePropertyLootCondition.builder(block).properties(StatePredicate.Builder.create().exactMatch(CropBlock.AGE, 7));
    }

    private LootTable.Builder oreClusterDrops(Block block, Item item) {
        return VanillaBlockLootTableGenerator.dropsWithSilkTouch(block,
            ((LootPoolEntry.Builder<?>) ((LeafEntry.Builder<?>)ItemEntry.builder(item)
                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(4.0f))))
                .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE)))
                .conditionally(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                    .tag(ItemTags.CLUSTER_MAX_HARVESTABLES))).alternatively(
                    this.applyExplosionDecay(block,
                        ItemEntry.builder(item)
                            .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(2.0f))))));
    }
}
