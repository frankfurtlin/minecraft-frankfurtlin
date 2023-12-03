package com.frankfurtlin.frankfurtlinmod.mixin.block;

import net.minecraft.block.AbstractBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Optional;

/**
 * 消除花放置的偏移量
 */
@Mixin(AbstractBlock.Settings.class)
public abstract class AbstractBlockMixin {
    @Shadow
    Optional<AbstractBlock.Offsetter> offsetter;

    @Inject(at = @At("HEAD"), method = "offset", cancellable = true)
    public void offset(AbstractBlock.OffsetType offsetType, CallbackInfoReturnable<AbstractBlock.Settings> cir){

        this.offsetter = Optional.empty();
        cir.setReturnValue((AbstractBlock.Settings)(Object)this);
        cir.cancel();

    }

}