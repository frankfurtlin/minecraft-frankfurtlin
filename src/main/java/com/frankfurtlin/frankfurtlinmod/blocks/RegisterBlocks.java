package com.frankfurtlin.frankfurtlinmod.blocks;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.items.RegisterItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.CropBlock;
import net.minecraft.block.Material;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class RegisterBlocks {
    // 草莓
    public static final CropBlock STRAWBERRY_CROP = new FrankfurtlinCropBlock(RegisterItems.STRAWBERRY,
            AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().
                    breakInstantly().sounds(BlockSoundGroup.CROP));
    // 黑莓
    public static final CropBlock BLACKBERRY_CROP = new FrankfurtlinCropBlock(RegisterItems.BLACKBERRY,
            AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().
                    breakInstantly().sounds(BlockSoundGroup.CROP));
    // 蓝莓
    public static final CropBlock BLUEBERRY_CROP = new FrankfurtlinCropBlock(RegisterItems.BLUEBERRY,
            AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().
                    breakInstantly().sounds(BlockSoundGroup.CROP));
    // 玉米
    public static final CropBlock CORN_CROP = new FrankfurtlinCropBlock(RegisterItems.CORN,
            AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().
                    breakInstantly().sounds(BlockSoundGroup.CROP));

    // 葡萄
    public static final CropBlock GRAPE_CROP = new FrankfurtlinCropBlock(RegisterItems.CORN,
            AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().
                    breakInstantly().sounds(BlockSoundGroup.CROP));

    // 猕猴桃
    public static final CropBlock KIWI_CROP = new FrankfurtlinCropBlock(RegisterItems.CORN,
            AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().
                    breakInstantly().sounds(BlockSoundGroup.CROP));

    // 菠萝
    public static final CropBlock PINEAPPLE_CROP = new FrankfurtlinCropBlock(RegisterItems.PINEAPPLE,
            AbstractBlock.Settings.of(Material.PLANT).nonOpaque().noCollision().ticksRandomly().
                    breakInstantly().sounds(BlockSoundGroup.CROP));



    public static void register() {
        Registry.register(Registries.BLOCK,
                new Identifier(Frankfurtlinmod.MOD_ID, "strawberry_crop"), STRAWBERRY_CROP);
        Registry.register(Registries.BLOCK,
                new Identifier(Frankfurtlinmod.MOD_ID, "blackberry_crop"), BLACKBERRY_CROP);
        Registry.register(Registries.BLOCK,
                new Identifier(Frankfurtlinmod.MOD_ID, "blueberry_crop"), BLUEBERRY_CROP);
        Registry.register(Registries.BLOCK,
                new Identifier(Frankfurtlinmod.MOD_ID, "corn_crop"), CORN_CROP);
        Registry.register(Registries.BLOCK,
                new Identifier(Frankfurtlinmod.MOD_ID, "grape_crop"), GRAPE_CROP);
        Registry.register(Registries.BLOCK,
                new Identifier(Frankfurtlinmod.MOD_ID, "kiwi_crop"), KIWI_CROP);
        Registry.register(Registries.BLOCK,
                new Identifier(Frankfurtlinmod.MOD_ID, "pineapple_crop"), PINEAPPLE_CROP);


    }
}
