package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.items.ModItems;
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
    @Inject(method = "registerCompostableItem", at = @At("TAIL"))
    private static void makeComposter(CallbackInfo ci){
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.STRAWBERRY, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BLACKBERRY, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BLUEBERRY, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.BANANA, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CHERRY, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.COCONUT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CORN, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.DRAGONFRUIT, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.GRAPE, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.KIWI, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.LEMON, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.MANGO, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.ORANGE, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.PINEAPPLE, 0.3f);
        ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.STARFRUIT, 0.3f);
    }

}
