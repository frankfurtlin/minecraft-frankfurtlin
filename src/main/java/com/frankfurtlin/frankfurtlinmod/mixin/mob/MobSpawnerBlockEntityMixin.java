package com.frankfurtlin.frankfurtlinmod.mixin.mob;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.block.entity.MobSpawnerBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// 刷怪笼 mixin
@Mixin(MobSpawnerBlockEntity.class)
public class MobSpawnerBlockEntityMixin {
    @Inject(method = "copyItemDataRequiresOperator", at = @At("RETURN"), cancellable = true)
    private void injected(CallbackInfoReturnable<Boolean> cir) {
        if(ModConfig.INSTANCE.canBreakSpawner){
            cir.setReturnValue(false);
        }
        else{
            cir.setReturnValue(true);
        }
    }
}