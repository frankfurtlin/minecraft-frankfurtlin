package com.frankfurtlin.frankfurtlinmod.blocks;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class RegisterBlocks {
    public static final CropBlock STRAWBERRY_CROP = new StrawberryBlock(
            AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().
                    breakInstantly().sounds(BlockSoundGroup.CROP));

    public static void register() {
        Registry.register(Registries.BLOCK,
                new Identifier(Frankfurtlinmod.MOD_ID, "strawberry_crop"), STRAWBERRY_CROP);
    }
}
