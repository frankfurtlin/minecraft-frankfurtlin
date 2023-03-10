package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public class FishingBobberEntityMixin {
    @Shadow
    private boolean caughtFish;

    /**
     * 钓到鱼时自动收杆放杆
     * @param data TrackedData
     * @param ci CallbackInfo
     * @throws InterruptedException 中断异常
     */
    @Inject(at = @At("TAIL"), method = "onTrackedDataSet")
    public void onTrackedDataSet(TrackedData<?> data, CallbackInfo ci) throws InterruptedException {

        MinecraftClient client = MinecraftClient.getInstance();
        if (caughtFish && ModConfig.INSTANCE.autoFish) {
            if (client.interactionManager != null) {
                client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            }
            Thread.sleep(5L);
            if (client.interactionManager != null) {
                client.interactionManager.interactItem(client.player, Hand.MAIN_HAND);
            }
        }
    }
}
