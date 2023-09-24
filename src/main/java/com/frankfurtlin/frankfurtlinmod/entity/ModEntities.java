package com.frankfurtlin.frankfurtlinmod.entity;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/24 16:23
 */
public class ModEntities {
    public static final EntityType<GlowStickEntity> GLOW_STICK_ENTITY = registerEntity("glow_stick",
        FabricEntityTypeBuilder.<GlowStickEntity>create(SpawnGroup.MISC, GlowStickEntity::new)
            .dimensions(EntityDimensions.fixed(0.25f, 0.25f))
            .trackRangeBlocks(4).trackedUpdateRate(10).build());

    private static EntityType<GlowStickEntity> registerEntity(String name, EntityType<GlowStickEntity> entity) {
        return Registry.register(Registries.ENTITY_TYPE, new Identifier(Frankfurtlinmod.MOD_ID, name), entity);
    }

    public static void registerModEntities() {
        Frankfurtlinmod.LOGGER.info("Registering Mod entities for " + Frankfurtlinmod.MOD_ID);
    }
}
