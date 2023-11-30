package com.frankfurtlin.frankfurtlinmod.worldgen;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.worldgen.placed_feature.ModPlacedFeature;
import net.fabricmc.fabric.api.biome.v1.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.function.BiConsumer;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/30 15:37
 */
public class ModFeatures {
    public static void placeFeaturesInBiomes() {

        BiomeModification modification = BiomeModifications.create(
            new Identifier(Frankfurtlinmod.MOD_ID, "geode_additions")
        );

        modification
            .add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                modifier(
                    ModPlacedFeature.COAL_GEODE
                )
            )
            .add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                modifier(
                    ModPlacedFeature.IRON_GEODE
                )
            )
            .add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                modifier(
                    ModPlacedFeature.COPPER_GEODE
                )
            )
            .add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                modifier(
                    ModPlacedFeature.GOLD_GEODE
                )
            )
            .add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                modifier(
                    ModPlacedFeature.LAPIS_GEODE
                )
            )
            .add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                modifier(
                    ModPlacedFeature.EMERALD_GEODE
                )
            )
            .add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                modifier(
                    ModPlacedFeature.DIAMOND_GEODE
                )
            )
            .add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(BiomeTags.IS_OVERWORLD),
                modifier(
                    ModPlacedFeature.REDSTONE_GEODE
                )
            )
            .add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(BiomeTags.IS_NETHER),
                modifier(
                    ModPlacedFeature.QUARTZ_GEODE
                )
            )
            .add(
                ModificationPhase.ADDITIONS,
                BiomeSelectors.tag(BiomeTags.IS_NETHER),
                modifier(
                    ModPlacedFeature.NETHERITE_GEODE
                )
            );
    }

    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext>
        modifier(RegistryKey<PlacedFeature> feature) {
            return (biomesSelectionContext, biomesModificationContext) ->
                biomesModificationContext.getGenerationSettings().addFeature(
                    GenerationStep.Feature.UNDERGROUND_DECORATION,
                    feature
                );
        }
}
