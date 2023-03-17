package com.frankfurtlin.frankfurtlinmod.mixin.mob;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.MobSpawnerLogic;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobSpawnerLogic.class)
public class MobSpawnerLogicMixin {
    @Shadow private int minSpawnDelay;

    @Shadow private int maxSpawnDelay;

    @Shadow private int spawnCount;

    @Shadow private int maxNearbyEntities;

    /**
     * 增强刷怪笼效率 默认每次刷4个怪 每隔10-40秒刷新一次
     * @param world world
     * @param pos pos
     * @param ci ci
     */
    @Inject(method = "updateSpawns(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V", at = @At("HEAD"))
    private void changeMobSpawnerLogic(World world, BlockPos pos, CallbackInfo ci){
        if(ModConfig.INSTANCE.mobSpawnerEnhance){
            this.minSpawnDelay = 20 * ModConfig.INSTANCE.minSpawnDelay;
            this.maxSpawnDelay = 20 * ModConfig.INSTANCE.maxSpawnDelay;
            this.spawnCount = ModConfig.INSTANCE.spawnCount;
            this.maxNearbyEntities = ModConfig.INSTANCE.spawnCount * 3 / 2;
        }
    }
}
