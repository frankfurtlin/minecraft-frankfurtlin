package com.frankfurtlin.frankfurtlinmod.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/10/16 20:31
 */
@Mixin(OreConfiguredFeatures.class)
public class OreConfiguredFeaturesMixin {
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_MAGMA;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_SOUL_SAND;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_NETHER_GOLD;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_QUARTZ;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_GRAVEL_NETHER;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_BLACKSTONE;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_DIRT;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_GRAVEL;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_GRANITE;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_DIORITE;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_ANDESITE;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_TUFF;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_COAL;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_COAL_BURIED;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_IRON;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_IRON_SMALL;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_GOLD;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_GOLD_BURIED;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_REDSTONE;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_SMALL;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_LARGE;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_BURIED;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_DIAMOND_MEDIUM;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_LAPIS;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_LAPIS_BURIED;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_INFESTED;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_EMERALD;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_ANCIENT_DEBRIS_LARGE;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_ANCIENT_DEBRIS_SMALL;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_COPPER_SMALL;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_COPPER_LARGE;
    @Shadow @Final public static RegistryKey<ConfiguredFeature<?, ?>> ORE_CLAY;


    /**
     * @author frankfurtlin
     * @reason 修改矿物生成
     */
    @Overwrite
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
        TagMatchRuleTest ruleTest = new TagMatchRuleTest(BlockTags.BASE_STONE_OVERWORLD);
        TagMatchRuleTest ruleTest2 = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        TagMatchRuleTest ruleTest3 = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        BlockMatchRuleTest ruleTest4 = new BlockMatchRuleTest(Blocks.NETHERRACK);
        TagMatchRuleTest ruleTest5 = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);
        List<OreFeatureConfig.Target> list = List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.IRON_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.DEEPSLATE_IRON_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> list2 = List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.GOLD_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.DEEPSLATE_GOLD_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> list3 = List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.DIAMOND_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.DEEPSLATE_DIAMOND_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> list4 = List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.LAPIS_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.DEEPSLATE_LAPIS_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> list5 = List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.COPPER_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.DEEPSLATE_COPPER_ORE.getDefaultState()));
        List<OreFeatureConfig.Target> list6 = List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.COAL_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.DEEPSLATE_COAL_ORE.getDefaultState()));
        ConfiguredFeatures.register(featureRegisterable, ORE_MAGMA, Feature.ORE, new OreFeatureConfig(ruleTest4, Blocks.MAGMA_BLOCK.getDefaultState(), 33));
        ConfiguredFeatures.register(featureRegisterable, ORE_SOUL_SAND, Feature.ORE, new OreFeatureConfig(ruleTest4, Blocks.SOUL_SAND.getDefaultState(), 12));
        ConfiguredFeatures.register(featureRegisterable, ORE_NETHER_GOLD, Feature.ORE, new OreFeatureConfig(ruleTest4, Blocks.NETHER_GOLD_ORE.getDefaultState(), 30));
        ConfiguredFeatures.register(featureRegisterable, ORE_QUARTZ, Feature.ORE, new OreFeatureConfig(ruleTest4, Blocks.NETHER_QUARTZ_ORE.getDefaultState(), 42));
        ConfiguredFeatures.register(featureRegisterable, ORE_GRAVEL_NETHER, Feature.ORE, new OreFeatureConfig(ruleTest4, Blocks.GRAVEL.getDefaultState(), 33));
        ConfiguredFeatures.register(featureRegisterable, ORE_BLACKSTONE, Feature.ORE, new OreFeatureConfig(ruleTest4, Blocks.BLACKSTONE.getDefaultState(), 33));
        ConfiguredFeatures.register(featureRegisterable, ORE_DIRT, Feature.ORE, new OreFeatureConfig(ruleTest, Blocks.DIRT.getDefaultState(), 33));
        ConfiguredFeatures.register(featureRegisterable, ORE_GRAVEL, Feature.ORE, new OreFeatureConfig(ruleTest, Blocks.GRAVEL.getDefaultState(), 33));
        ConfiguredFeatures.register(featureRegisterable, ORE_GRANITE, Feature.ORE, new OreFeatureConfig(ruleTest, Blocks.GRANITE.getDefaultState(), 64));
        ConfiguredFeatures.register(featureRegisterable, ORE_DIORITE, Feature.ORE, new OreFeatureConfig(ruleTest, Blocks.DIORITE.getDefaultState(), 64));
        ConfiguredFeatures.register(featureRegisterable, ORE_ANDESITE, Feature.ORE, new OreFeatureConfig(ruleTest, Blocks.ANDESITE.getDefaultState(), 64));
        ConfiguredFeatures.register(featureRegisterable, ORE_TUFF, Feature.ORE, new OreFeatureConfig(ruleTest, Blocks.TUFF.getDefaultState(), 64));
        ConfiguredFeatures.register(featureRegisterable, ORE_COAL, Feature.ORE, new OreFeatureConfig(list6, 51));
        ConfiguredFeatures.register(featureRegisterable, ORE_COAL_BURIED, Feature.ORE, new OreFeatureConfig(list6, 51, 0.5f));
        ConfiguredFeatures.register(featureRegisterable, ORE_IRON, Feature.ORE, new OreFeatureConfig(list, 27));
        ConfiguredFeatures.register(featureRegisterable, ORE_IRON_SMALL, Feature.ORE, new OreFeatureConfig(list, 12));
        ConfiguredFeatures.register(featureRegisterable, ORE_GOLD, Feature.ORE, new OreFeatureConfig(list2, 27));
        ConfiguredFeatures.register(featureRegisterable, ORE_GOLD_BURIED, Feature.ORE, new OreFeatureConfig(list2, 27, 0.5f));
        ConfiguredFeatures.register(featureRegisterable, ORE_REDSTONE, Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.REDSTONE_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.DEEPSLATE_REDSTONE_ORE.getDefaultState())), 24));
        ConfiguredFeatures.register(featureRegisterable, ORE_DIAMOND_SMALL, Feature.ORE, new OreFeatureConfig(list3, 12, 0.5f));
        ConfiguredFeatures.register(featureRegisterable, ORE_DIAMOND_LARGE, Feature.ORE, new OreFeatureConfig(list3, 36, 0.7f));
        ConfiguredFeatures.register(featureRegisterable, ORE_DIAMOND_BURIED, Feature.ORE, new OreFeatureConfig(list3, 24, 1.0f));
        ConfiguredFeatures.register(featureRegisterable, ORE_DIAMOND_MEDIUM, Feature.ORE, new OreFeatureConfig(list3, 24, 0.5f));
        ConfiguredFeatures.register(featureRegisterable, ORE_LAPIS, Feature.ORE, new OreFeatureConfig(list4, 21));
        ConfiguredFeatures.register(featureRegisterable, ORE_LAPIS_BURIED, Feature.ORE, new OreFeatureConfig(list4, 21, 1.0f));
        ConfiguredFeatures.register(featureRegisterable, ORE_INFESTED, Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.INFESTED_STONE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.INFESTED_DEEPSLATE.getDefaultState())), 27));
        ConfiguredFeatures.register(featureRegisterable, ORE_EMERALD, Feature.ORE, new OreFeatureConfig(List.of(OreFeatureConfig.createTarget(ruleTest2, Blocks.EMERALD_ORE.getDefaultState()), OreFeatureConfig.createTarget(ruleTest3, Blocks.DEEPSLATE_EMERALD_ORE.getDefaultState())), 9));
        ConfiguredFeatures.register(featureRegisterable, ORE_ANCIENT_DEBRIS_LARGE, Feature.SCATTERED_ORE, new OreFeatureConfig(ruleTest5, Blocks.ANCIENT_DEBRIS.getDefaultState(), 30, 0.1f));
        ConfiguredFeatures.register(featureRegisterable, ORE_ANCIENT_DEBRIS_SMALL, Feature.SCATTERED_ORE, new OreFeatureConfig(ruleTest5, Blocks.ANCIENT_DEBRIS.getDefaultState(), 20, 0.1f));
        ConfiguredFeatures.register(featureRegisterable, ORE_COPPER_SMALL, Feature.ORE, new OreFeatureConfig(list5, 30));
        ConfiguredFeatures.register(featureRegisterable, ORE_COPPER_LARGE, Feature.ORE, new OreFeatureConfig(list5, 60));
        ConfiguredFeatures.register(featureRegisterable, ORE_CLAY, Feature.ORE, new OreFeatureConfig(ruleTest, Blocks.CLAY.getDefaultState(), 33));
    }
}
