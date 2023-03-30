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
     * 植物、水果可堆肥
     * @param ci callback
     */
    @Inject(method = "<init>", at = @At("TAIL"))
    private void makeSeedComposter(CallbackInfo ci){
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.STRAWBERRY, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.BLACKBERRY, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.BLUEBERRY, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.BANANA, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.CHERRY, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.COCONUT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.CORN, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.DRAGONFRUIT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.GRAPE, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.KIWI, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.LEMON, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.MANGO, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.ORANGE, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.PINEAPPLE, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(RegisterItems.STARFRUIT, 0.3f);
    }
}
