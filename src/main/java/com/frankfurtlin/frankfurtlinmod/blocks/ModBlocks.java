package com.frankfurtlin.frankfurtlinmod.blocks;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.blocks.cropBlocks.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
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

    // 白金块
    public static final Block WHITE_GOLD_BLOCK = registerBlock("white_gold_block",
        new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).sounds(BlockSoundGroup.AMETHYST_BLOCK)));



    // ----------------------------------------------------------------------------------------------------------------

    // 荧光棒
    public static final Block GLOW_STICK_BLOCK = registerBlock("glow_stick", new GlowStickBlock(
        AbstractBlock.Settings.create().mapColor(MapColor.CLEAR).noCollision().breakInstantly()
            .luminance((state) -> 14).pistonBehavior(PistonBehavior.DESTROY)));


    // ----------------------------------------------------------------------------------------------------------------

    // 草莓作物
    public static final Block STRAWBERRY_CROP = registerBlock("strawberry_crop", new StrawberryBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    // 黑莓作物
    public static final Block BLACKBERRY_CROP = registerBlock("blackberry_crop", new BlackberryBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    // 蓝莓作物
    public static final Block BLUEBERRY_CROP = registerBlock("blueberry_crop", new BlueberryBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));
    // 玉米作物
    public static final Block CORN_CROP = registerBlock("corn_crop", new CornBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));

    // 葡萄作物
    public static final Block GRAPE_CROP = registerBlock("grape_crop", new GrapeBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));

    // 猕猴桃作物
    public static final Block KIWI_CROP = registerBlock("kiwi_crop", new KiwiBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));

    // 菠萝作物
    public static final Block PINEAPPLE_CROP = registerBlock("pineapple_crop", new PineappleBlock(
        AbstractBlock.Settings.create().nonOpaque().noCollision().ticksRandomly().breakInstantly()
            .sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY)));


    // ----------------------------------------------------------------------------------------------------------------


    private static Block registerBlock(String name, Block block) {
        if(!(block instanceof GlowStickBlock)){
            registerBlockItem(name, block);
        }
        return Registry.register(Registries.BLOCK, new Identifier(Frankfurtlinmod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Frankfurtlinmod.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Frankfurtlinmod.LOGGER.info("Registering Mod blocks for " + Frankfurtlinmod.MOD_ID);
    }
}
