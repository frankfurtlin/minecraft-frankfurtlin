package com.frankfurtlin.frankfurtlinmod.mixin.block;

import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.Slice;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/5 20:07
 */
@Mixin(Blocks.class)
public class BlocksMixin {
    @Redirect(slice = @Slice(from = @At(value = "CONSTANT", args = {"stringValue=budding_amethyst"}, ordinal = 0)),
        at = @At(value = "NEW", target = "(Lnet/minecraft/block/AbstractBlock$Settings;)Lnet/minecraft/block/BuddingAmethystBlock;", ordinal = 0),
        method = "<clinit>")
    private static BuddingAmethystBlock buddingAmethyst(AbstractBlock.Settings settings) {
        return new BuddingAmethystBlock(AbstractBlock.Settings.create().mapColor(MapColor.PURPLE).ticksRandomly()
            .strength(1.5f).sounds(BlockSoundGroup.AMETHYST_BLOCK).pistonBehavior(PistonBehavior.DESTROY));
    }

}
