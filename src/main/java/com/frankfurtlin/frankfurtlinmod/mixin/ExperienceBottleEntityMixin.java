package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.entity.projectile.thrown.ExperienceBottleEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ExperienceBottleEntity.class)
public class ExperienceBottleEntityMixin {

    /**
     * 设置经验瓶掉落经验
     * @param value 值
     * @return ModConfig.INSTANCE.experienceBottle
     */
    @ModifyConstant(method = "onCollision", constant = @Constant(intValue = 5))
    private int changeExperienceBottleValue(int value){

        return ModConfig.INSTANCE.experienceBottle;
    }
}
