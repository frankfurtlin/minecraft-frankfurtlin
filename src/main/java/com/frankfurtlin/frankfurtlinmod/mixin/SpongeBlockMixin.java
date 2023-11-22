package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.block.SpongeBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/22 15:59
 * 修改海绵的吸收范围
 */
@Mixin(SpongeBlock.class)
public class SpongeBlockMixin {
    @ModifyConstant(method = "absorbWater", constant = @Constant(intValue = 6))
    private int changeMaxDepth(int constant){
        return ModConfig.INSTANCE.maxDepth;
    }

    @ModifyConstant(method = "absorbWater", constant = @Constant(intValue = 65))
    private int changeMaxIterations(int constant){
        return ModConfig.INSTANCE.maxIterations;
    }
}
