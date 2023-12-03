package com.frankfurtlin.frankfurtlinmod.worldgen.placed_feature;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/30 15:31
 */
public class ModPlacedFeature {

    public static final RegistryKey<PlacedFeature> COAL_GEODE = of("coal_geode");
    public static final RegistryKey<PlacedFeature> IRON_GEODE = of("iron_geode");
    public static final RegistryKey<PlacedFeature> COPPER_GEODE = of("copper_geode");
    public static final RegistryKey<PlacedFeature> GOLD_GEODE = of("gold_geode");
    public static final RegistryKey<PlacedFeature> LAPIS_GEODE = of("lapis_geode");
    public static final RegistryKey<PlacedFeature> EMERALD_GEODE = of("emerald_geode");
    public static final RegistryKey<PlacedFeature> DIAMOND_GEODE = of("diamond_geode");
    public static final RegistryKey<PlacedFeature> REDSTONE_GEODE = of("redstone_geode");
    public static final RegistryKey<PlacedFeature> QUARTZ_GEODE = of("quartz_geode");
    public static final RegistryKey<PlacedFeature> NETHERITE_GEODE = of("netherite_geode");
    public static final RegistryKey<PlacedFeature> SCULKHYST_GEODE = of("sculkhyst_geode");

    public static RegistryKey<PlacedFeature> of(String id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier(Frankfurtlinmod.MOD_ID, id));
    }
}
