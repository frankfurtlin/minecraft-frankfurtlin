package com.frankfurtlin.frankfurtlinmod.mixin.mob;

import net.minecraft.block.BlockState;
import net.minecraft.block.SpawnerBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/10/6 10:06
 * 精准采集可以采集刷怪笼
 */
@Mixin(SpawnerBlock.class)
public class SpawnerBlockMixin {
    @Inject(method = "onStacksDropped", at = @At("HEAD"), locals = LocalCapture.CAPTURE_FAILHARD, cancellable = true)
    private void injected(BlockState state, ServerWorld world, BlockPos pos, ItemStack tool, boolean dropExperience, CallbackInfo ci) {
        if (EnchantmentHelper.hasSilkTouch(tool)) {
            ci.cancel();
        }
    }
}
