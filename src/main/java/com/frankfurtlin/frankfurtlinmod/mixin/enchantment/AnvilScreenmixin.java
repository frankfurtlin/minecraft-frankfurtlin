package com.frankfurtlin.frankfurtlinmod.mixin.enchantment;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(AnvilScreen.class)
public class AnvilScreenmixin {

    /**
     * 消除附魔经验上限
     * @param limit 上限
     * @return 最大整形
     */
    @ModifyConstant(method = "drawForeground", constant = @Constant(intValue = 40))
    public int modifyLimit(int limit) {
        if(ModConfig.INSTANCE.removeAnvilLimit){
            return Integer.MAX_VALUE;
        }
        return 40;
    }
}
