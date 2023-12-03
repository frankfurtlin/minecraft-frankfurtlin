package com.frankfurtlin.frankfurtlinmod.mixin.render;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.client.gui.hud.InGameOverlayRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/12/3 14:45
 */
@Mixin(InGameOverlayRenderer.class)
public class InGameOverlayRendererMixin {
    /*@Inject(method = "renderFireOverlay", at = @At(value = "HEAD"), cancellable = true)
    private static void removeFireOverlay(MinecraftClient client, MatrixStack matrices, CallbackInfo ci) {
        LavaConfig lavaConfig = ModConfig.get().lavaConfig;
        if (client.player != null
            && ((lavaConfig.removeFireScreenEffectInLava && client.player.isInLava())
            || (lavaConfig.removeFireScreenEffectIfOnFire && client.player.isOnFire()))) {
            ci.cancel();
        }
    }*/
    @ModifyConstant(method = "renderFireOverlay", constant = @Constant(floatValue = 0.5f))
    private static float miniFireOverlay(float constant){
        return ModConfig.INSTANCE.fireOverlayPercent;
    }

}
