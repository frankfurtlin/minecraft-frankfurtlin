package com.frankfurtlin.frankfurtlinmod.blocks;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.blocks.cropBlocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/24 16:47
 */
public class ModBlocks {
    // ----------------------------------------------------------------------------------------------------------------

    // 发光棒
    public static final Block GLOW_STICK_BLOCK = registerBlock("glow_stick", new GlowStickBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().breakInstantly()
            .luminance((state) -> 14).pistonBehavior(PistonBehavior.DESTROY)));


    // ----------------------------------------------------------------------------------------------------------------

    // 草莓
    public static final Block STRAWBERRY_CROP = registerBlock("strawberry_crop", new StrawberryBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    // 黑莓
    public static final Block BLACKBERRY_CROP = registerBlock("blackberry_crop", new BlackberryBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    // 蓝莓
    public static final Block BLUEBERRY_CROP = registerBlock("blueberry_crop", new BlueberryBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    // 玉米
    public static final Block CORN_CROP = registerBlock("corn_crop", new CornBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));

    // 葡萄
    public static final Block GRAPE_CROP = registerBlock("grape_crop", new GrapeBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));

    // 猕猴桃
    public static final Block KIWI_CROP = registerBlock("kiwi_crop", new KiwiBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));

    // 菠萝
    public static final Block PINEAPPLE_CROP = registerBlock("pineapple_crop", new PineappleBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));


    // ----------------------------------------------------------------------------------------------------------------


    private static Block registerBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(Frankfurtlinmod.MOD_ID, name), block);
    }

    public static void registerModBlocks() {
        Frankfurtlinmod.LOGGER.info("Registering Mod blocks for " + Frankfurtlinmod.MOD_ID);
    }
}
