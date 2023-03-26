package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.items.RegisterItems;
import net.minecraft.block.ComposterBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.block.ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE;

@Mixin(ComposterBlock.class)
public class ComposterBlockMixin {

    /**
     * 草莓种子可堆肥
     * @param ci callback
     */
    @Inject(method = "<init>", at = @At("TAIL"))
    private void makeSeedComposter(CallbackInfo ci){
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.STRAWBERRY_SEED, 0.3f);
    }
}
