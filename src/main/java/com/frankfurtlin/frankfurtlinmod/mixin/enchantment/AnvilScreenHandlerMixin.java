package com.frankfurtlin.frankfurtlinmod.mixin.enchantment;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.screen.AnvilScreenHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import java.util.Random;

@Mixin(AnvilScreenHandler.class)
public class AnvilScreenHandlerMixin {
    /**
     * 消除附魔经验上限
     * @param limit 上限
     * @return 最大整形
     */
    @ModifyConstant(method = "updateResult", constant = @Constant(intValue = 40), require = 0)
    public int modifyLimit(int limit) {
        if(ModConfig.INSTANCE.removeAnvilLimit){
            return Integer.MAX_VALUE;
        }
        return 40;
    }

    /**
     * @author frankfurtlin
     * @reason 消除指数级附魔经验增长
     */
    @Overwrite
    public static int getNextCost(int cost) {
        if(!ModConfig.INSTANCE.removeAnvilExponentialIncrease){
            return cost * 2 + 1;
        }
        else{
            if(cost < 30){
                return cost * 2 + 1;
            }
            else{
                Random random = new Random();
                return cost + random.nextInt(20);
            }
        }

    }
}
