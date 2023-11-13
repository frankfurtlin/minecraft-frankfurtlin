package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/23 11:07
 */
@Mixin(Item.class)
public abstract class ItemMixin {
    @Shadow public abstract Item asItem();

    /**
     * 对某些物品改变其堆叠数量
     * @param cir cir
     */
    @Inject(method = "getMaxCount", at = @At("HEAD"), cancellable = true)
    private void changeItemsStack(CallbackInfoReturnable<Integer> cir){
        if((this.asItem() == Items.TOTEM_OF_UNDYING || this.asItem() == Items.SADDLE || this.asItem() == Items.POTION
           || this.asItem() == Items.WATER_BUCKET || this.asItem() == Items.LAVA_BUCKET)
            && ModConfig.INSTANCE.canStackTo64){
            cir.setReturnValue(Item.DEFAULT_MAX_COUNT);
        }
    }
}
