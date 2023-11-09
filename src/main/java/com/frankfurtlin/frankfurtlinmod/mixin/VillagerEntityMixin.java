package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.entity.passive.VillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/9 9:54
 */
@Mixin(VillagerEntity.class)
public class VillagerEntityMixin {
    @ModifyConstant(method = "fillRecipes", constant = @Constant(intValue = 2))
    private int addMoreRecipeCount(int count){
        return ModConfig.INSTANCE.tradeCount;
    }
}
