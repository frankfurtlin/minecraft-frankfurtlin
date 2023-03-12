package com.frankfurtlin.frankfurtlinmod.mixin.villager;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.village.TradeOffer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(TradeOffer.class)
public class TradeOfferMixin {

    @Shadow private int uses;

    /**
     * @author Frankfuerlin
     * @reason 村民交易不锁定
     */
    @Overwrite
    public void use() {
        if(ModConfig.INSTANCE.unLockVillager){
            return;
        }
        ++this.uses;
    }
}
