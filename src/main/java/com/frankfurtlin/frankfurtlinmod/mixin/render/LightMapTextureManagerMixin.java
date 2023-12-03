package com.frankfurtlin.frankfurtlinmod.mixin.render;

import com.frankfurtlin.frankfurtlinmod.event.KeyBindings;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

// gamma 值修改
@Mixin(LightmapTextureManager.class)
public abstract class LightMapTextureManagerMixin {
    @Redirect(method = "update", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/client/network/ClientPlayerEntity;hasStatusEffect(Lnet/minecraft/entity/effect/StatusEffect;)Z"))
    private boolean hasStatusEffect(ClientPlayerEntity instance, StatusEffect statusEffect) {
        if (KeyBindings.gamma) {
            return true;
        } else {
            return instance.hasStatusEffect(StatusEffects.NIGHT_VISION);
        }
    }

    @Redirect(method = "update", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/client/render/GameRenderer;getNightVisionStrength(Lnet/minecraft/entity/LivingEntity;F)F"))
    private float getNightVisionStrength(LivingEntity entity, float tickDelta) {
        if (KeyBindings.gamma) {
            return 1.0f;
        } else {
            return GameRenderer.getNightVisionStrength(entity, tickDelta);
        }
    }

}