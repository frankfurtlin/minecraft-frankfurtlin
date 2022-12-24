package com.frankfurtlin.frankfurtlinmod.mixin;

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

    /**
     * 增强刷怪笼效率 每次刷6个怪 每隔1-4秒刷新一次
     * @param world world
     * @param pos pos
     * @param ci ci
     */
    @Inject(method = "updateSpawns(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;)V", at = @At("HEAD"))
    public void changeMobSpawnerLogic(World world, BlockPos pos, CallbackInfo ci){
        this.minSpawnDelay = 20;
        this.maxSpawnDelay = 80;
        this.spawnCount = 6;
    }
}
