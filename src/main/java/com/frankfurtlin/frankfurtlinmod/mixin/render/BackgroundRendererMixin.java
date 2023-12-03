package com.frankfurtlin.frankfurtlinmod.mixin.render;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.CameraSubmersionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = BackgroundRenderer.class, priority = 1001)
public class BackgroundRendererMixin {
    
    // Override fog at the TAIL to avoid conflicts with other mods such as Origins that did redirection which I used to do
    @Inject(method = "applyFog", at = @At(value = "TAIL"))
    private static void changeForInLava(Camera camera, BackgroundRenderer.FogType fogType,
                                        float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
        CameraSubmersionType cameraSubmersionType = camera.getSubmersionType();

        if (cameraSubmersionType == CameraSubmersionType.LAVA && ModConfig.INSTANCE.canSeeInLava) {
            RenderSystem.setShaderFogStart(0);
            RenderSystem.setShaderFogEnd(150F);
        }
    }
}