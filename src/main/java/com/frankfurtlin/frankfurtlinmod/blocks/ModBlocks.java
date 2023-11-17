package com.frankfurtlin.frankfurtlinmod.blocks;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import com.frankfurtlin.frankfurtlinmod.blocks.cropBlocks.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.particle.ParticleTypes;
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

    // 煤炭簇
    public static final Block BUDDING_COAL = registerBlock("budding_coal",
        new BuddingOreBlock("coal", 2, AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY)
            .ticksRandomly().strength(1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block COAL_CLUSTER = registerBlock("coal_cluster",
        new OreClusterBlock(4, 7, 3, AbstractBlock.Settings.create()
            .mapColor(MapColor.STONE_GRAY).solid().nonOpaque().ticksRandomly()
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.0f).luminance(state -> 5)));
    public static final Block LARGE_COAL_BUD = registerBlock("large_coal_bud",
        new OreClusterBlock(3, 5, 3, AbstractBlock.Settings.copy(COAL_CLUSTER)
            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance(state -> 4)));
    public static final Block MEDIUM_COAL_BUD = registerBlock("medium_coal_bud",
        new OreClusterBlock(2, 4, 3, AbstractBlock.Settings.copy(COAL_CLUSTER)
            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance(state -> 2)));
    public static final Block SMALL_COAL_BUD = registerBlock("small_coal_bud",
        new OreClusterBlock(1, 3, 4, AbstractBlock.Settings.copy(COAL_CLUSTER)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance(state -> 1)));

    // 铁簇
    public static final Block BUDDING_IRON = registerBlock("budding_iron",
        new BuddingOreBlock("iron", 3, AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY)
            .ticksRandomly().strength(1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block IRON_CLUSTER = registerBlock("iron_cluster",
        new OreClusterBlock(4, 7, 3, AbstractBlock.Settings.create()
            .mapColor(MapColor.IRON_GRAY).solid().nonOpaque().ticksRandomly()
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.0f).luminance(state -> 5)));
    public static final Block LARGE_IRON_BUD = registerBlock("large_iron_bud",
        new OreClusterBlock(3, 5, 3, AbstractBlock.Settings.copy(IRON_CLUSTER)
            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance(state -> 4)));
    public static final Block MEDIUM_IRON_BUD = registerBlock("medium_iron_bud",
        new OreClusterBlock(2, 4, 3, AbstractBlock.Settings.copy(IRON_CLUSTER)
            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance(state -> 2)));
    public static final Block SMALL_IRON_BUD = registerBlock("small_iron_bud",
        new OreClusterBlock(1, 3, 4, AbstractBlock.Settings.copy(IRON_CLUSTER)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance(state -> 1)));

    // 铜簇
    public static final Block BUDDING_COPPER = registerBlock("budding_copper",
        new BuddingOreBlock("copper", 3, AbstractBlock.Settings.create().mapColor(MapColor.ORANGE)
            .ticksRandomly().strength(1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block COPPER_CLUSTER = registerBlock("copper_cluster",
        new OreClusterBlock(4, 7, 3, AbstractBlock.Settings.create()
            .mapColor(MapColor.ORANGE).solid().nonOpaque().ticksRandomly()
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.0f).luminance(state -> 5)));
    public static final Block LARGE_COPPER_BUD = registerBlock("large_copper_bud",
        new OreClusterBlock(3, 5, 3, AbstractBlock.Settings.copy(COPPER_CLUSTER)
            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance(state -> 4)));
    public static final Block MEDIUM_COPPER_BUD = registerBlock("medium_copper_bud",
        new OreClusterBlock(2, 4, 3, AbstractBlock.Settings.copy(COPPER_CLUSTER)
            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance(state -> 2)));
    public static final Block SMALL_COPPER_BUD = registerBlock("small_copper_bud",
        new OreClusterBlock(1, 3, 4, AbstractBlock.Settings.copy(COPPER_CLUSTER)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance(state -> 1)));

    // 金簇
    public static final Block BUDDING_GOLD = registerBlock("budding_gold",
        new BuddingOreBlock("gold", 3, AbstractBlock.Settings.create().mapColor(MapColor.GOLD)
            .ticksRandomly().strength(1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block GOLD_CLUSTER = registerBlock("gold_cluster",
        new OreClusterBlock(4, 7, 3, AbstractBlock.Settings.create()
            .mapColor(MapColor.GOLD).solid().nonOpaque().ticksRandomly()
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.0f).luminance(state -> 5)));
    public static final Block LARGE_GOLD_BUD = registerBlock("large_gold_bud",
        new OreClusterBlock(3, 5, 3, AbstractBlock.Settings.copy(GOLD_CLUSTER)
            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance(state -> 4)));
    public static final Block MEDIUM_GOLD_BUD = registerBlock("medium_gold_bud",
        new OreClusterBlock(2, 4, 3, AbstractBlock.Settings.copy(GOLD_CLUSTER)
            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance(state -> 2)));
    public static final Block SMALL_GOLD_BUD = registerBlock("small_gold_bud",
        new OreClusterBlock(1, 3, 4, AbstractBlock.Settings.copy(GOLD_CLUSTER)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance(state -> 1)));

    // 青金石簇
    public static final Block BUDDING_LAPIS = registerBlock("budding_lapis",
        new BuddingOreBlock("lapis", 3, AbstractBlock.Settings.create().mapColor(MapColor.LAPIS_BLUE)
            .ticksRandomly().strength(1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block LAPIS_CLUSTER = registerBlock("lapis_cluster",
        new OreClusterBlock(4, 7, 3, AbstractBlock.Settings.create()
            .mapColor(MapColor.LAPIS_BLUE).solid().nonOpaque().ticksRandomly()
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.0f).luminance(state -> 5)));
    public static final Block LARGE_LAPIS_BUD = registerBlock("large_lapis_bud",
        new OreClusterBlock(3, 5, 3, AbstractBlock.Settings.copy(LAPIS_CLUSTER)
            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance(state -> 4)));
    public static final Block MEDIUM_LAPIS_BUD = registerBlock("medium_lapis_bud",
        new OreClusterBlock(2, 4, 3, AbstractBlock.Settings.copy(LAPIS_CLUSTER)
            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance(state -> 2)));
    public static final Block SMALL_LAPIS_BUD = registerBlock("small_lapis_bud",
        new OreClusterBlock(1, 3, 4, AbstractBlock.Settings.copy(LAPIS_CLUSTER)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance(state -> 1)));

    // 红石簇
    public static final Block BUDDING_REDSTONE = registerBlock("budding_redstone",
        new BuddingOreBlock("redstone", 3, AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_RED)
            .ticksRandomly().strength(1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block REDSTONE_CLUSTER = registerBlock("redstone_cluster",
        new OreClusterBlock(4, 7, 3, AbstractBlock.Settings.create()
            .mapColor(MapColor.BRIGHT_RED).solid().nonOpaque().ticksRandomly()
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.0f).luminance(state -> 5)));
    public static final Block LARGE_REDSTONE_BUD = registerBlock("large_redstone_bud",
        new OreClusterBlock(3, 5, 3, AbstractBlock.Settings.copy(REDSTONE_CLUSTER)
            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance(state -> 4)));
    public static final Block MEDIUM_REDSTONE_BUD = registerBlock("medium_redstone_bud",
        new OreClusterBlock(2, 4, 3, AbstractBlock.Settings.copy(REDSTONE_CLUSTER)
            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance(state -> 2)));
    public static final Block SMALL_REDSTONE_BUD = registerBlock("small_redstone_bud",
        new OreClusterBlock(1, 3, 4, AbstractBlock.Settings.copy(REDSTONE_CLUSTER)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance(state -> 1)));

    // 钻石簇
    public static final Block BUDDING_DIAMOND = registerBlock("budding_diamond",
        new BuddingOreBlock("diamond", 4, AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE)
            .ticksRandomly().strength(1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block DIAMOND_CLUSTER = registerBlock("diamond_cluster",
        new OreClusterBlock(4, 7, 3, AbstractBlock.Settings.create()
            .mapColor(MapColor.DIAMOND_BLUE).solid().nonOpaque().ticksRandomly()
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.0f).luminance(state -> 5)));
    public static final Block LARGE_DIAMOND_BUD = registerBlock("large_diamond_bud",
        new OreClusterBlock(3, 5, 3, AbstractBlock.Settings.copy(DIAMOND_CLUSTER)
            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance(state -> 4)));
    public static final Block MEDIUM_DIAMOND_BUD = registerBlock("medium_diamond_bud",
        new OreClusterBlock(2, 4, 3, AbstractBlock.Settings.copy(DIAMOND_CLUSTER)
            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance(state -> 2)));
    public static final Block SMALL_DIAMOND_BUD = registerBlock("small_diamond_bud",
        new OreClusterBlock(1, 3, 4, AbstractBlock.Settings.copy(DIAMOND_CLUSTER)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance(state -> 1)));

    // 绿宝石簇
    public static final Block BUDDING_EMERALD = registerBlock("budding_emerald",
        new BuddingOreBlock("emerald", 4, AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN)
            .ticksRandomly().strength(1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block EMERALD_CLUSTER = registerBlock("emerald_cluster",
        new OreClusterBlock(4, 7, 3, AbstractBlock.Settings.create()
            .mapColor(MapColor.EMERALD_GREEN).solid().nonOpaque().ticksRandomly()
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.0f).luminance(state -> 5)));
    public static final Block LARGE_EMERALD_BUD = registerBlock("large_emerald_bud",
        new OreClusterBlock(3, 5, 3, AbstractBlock.Settings.copy(EMERALD_CLUSTER)
            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance(state -> 4)));
    public static final Block MEDIUM_EMERALD_BUD = registerBlock("medium_emerald_bud",
        new OreClusterBlock(2, 4, 3, AbstractBlock.Settings.copy(EMERALD_CLUSTER)
            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance(state -> 2)));
    public static final Block SMALL_EMERALD_BUD = registerBlock("small_emerald_bud",
        new OreClusterBlock(1, 3, 4, AbstractBlock.Settings.copy(EMERALD_CLUSTER)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance(state -> 1)));

    // 石英簇
    public static final Block BUDDING_QUARTZ = registerBlock("budding_quartz",
        new BuddingOreBlock("quartz", 2, AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE)
            .ticksRandomly().strength(1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block QUARTZ_CLUSTER = registerBlock("quartz_cluster",
        new OreClusterBlock(4, 7, 3, AbstractBlock.Settings.create()
            .mapColor(MapColor.OFF_WHITE).solid().nonOpaque().ticksRandomly()
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.0f).luminance(state -> 5)));
    public static final Block LARGE_QUARTZ_BUD = registerBlock("large_quartz_bud",
        new OreClusterBlock(3, 5, 3, AbstractBlock.Settings.copy(QUARTZ_CLUSTER)
            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance(state -> 4)));
    public static final Block MEDIUM_QUARTZ_BUD = registerBlock("medium_quartz_bud",
        new OreClusterBlock(2, 4, 3, AbstractBlock.Settings.copy(QUARTZ_CLUSTER)
            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance(state -> 2)));
    public static final Block SMALL_QUARTZ_BUD = registerBlock("small_quartz_bud",
        new OreClusterBlock(1, 3, 4, AbstractBlock.Settings.copy(QUARTZ_CLUSTER)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance(state -> 1)));

    // 远古残骸簇
    public static final Block BUDDING_NETHERITE = registerBlock("budding_netherite",
        new BuddingOreBlock("netherite", 4, AbstractBlock.Settings.create().mapColor(MapColor.BLACK)
            .ticksRandomly().strength(1.0f).sounds(BlockSoundGroup.AMETHYST_BLOCK)));
    public static final Block NETHERITE_CLUSTER = registerBlock("netherite_cluster",
        new OreClusterBlock(4, 7, 3, AbstractBlock.Settings.create()
            .mapColor(MapColor.BLACK).solid().nonOpaque().ticksRandomly()
            .sounds(BlockSoundGroup.AMETHYST_CLUSTER).strength(1.0f).luminance(state -> 5)));
    public static final Block LARGE_NETHERITE_BUD = registerBlock("large_netherite_bud",
        new OreClusterBlock(3, 5, 3, AbstractBlock.Settings.copy(NETHERITE_CLUSTER)
            .sounds(BlockSoundGroup.MEDIUM_AMETHYST_BUD).solid().luminance(state -> 4)));
    public static final Block MEDIUM_NETHERITE_BUD = registerBlock("medium_netherite_bud",
        new OreClusterBlock(2, 4, 3, AbstractBlock.Settings.copy(NETHERITE_CLUSTER)
            .sounds(BlockSoundGroup.LARGE_AMETHYST_BUD).solid().luminance(state -> 2)));
    public static final Block SMALL_NETHERITE_BUD = registerBlock("small_netherite_bud",
        new OreClusterBlock(1, 3, 4, AbstractBlock.Settings.copy(NETHERITE_CLUSTER)
            .sounds(BlockSoundGroup.SMALL_AMETHYST_BUD).solid().luminance(state -> 1)));

    //矿物甘蔗方块
    public static final Block COAL_CANE = registerBlock("coal_cane",
        new OreCaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.STONE_GRAY).noCollision()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block IRON_CANE = registerBlock("iron_cane",
        new OreCaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.IRON_GRAY).noCollision()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block COPPER_CANE = registerBlock("copper_cane",
        new OreCaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).noCollision()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block GOLD_CANE = registerBlock("gold_cane",
        new OreCaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.GOLD).noCollision()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block LAPIS_CANE = registerBlock("lapis_cane",
        new OreCaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.LAPIS_BLUE).noCollision()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block EMERALD_CANE = registerBlock("emerald_cane",
        new OreCaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.EMERALD_GREEN).noCollision()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block DIAMOND_CANE = registerBlock("diamond_cane",
        new OreCaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.DIAMOND_BLUE).noCollision()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block REDSTONE_CANE = registerBlock("redstone_cane",
        new OreCaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.BRIGHT_RED).noCollision()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block QUARTZ_CANE = registerBlock("quartz_cane",
        new OreCaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.OFF_WHITE).noCollision()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));
    public static final Block NETHERITE_CANE = registerBlock("netherite_cane",
        new OreCaneBlock(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).noCollision()
            .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.GRASS).pistonBehavior(PistonBehavior.DESTROY)));



    // ----------------------------------------------------------------------------------------------------------------

    // 荧光棒
    public static final Block GLOW_STICK_BLOCK = registerBlock("glow_stick", new GlowStickBlock(
        AbstractBlock.Settings.create().mapColor(MapColor.CLEAR).noCollision().breakInstantly()
            .luminance((state) -> 14).pistonBehavior(PistonBehavior.DESTROY)));
    // 水蜡烛
    public static final Block AQUATIC_TORCH = registerBlock("aquatic_torch", new AquaticTorchBlock(
        AbstractBlock.Settings.create().noCollision().breakInstantly().luminance(state -> 14)
            .sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY), ParticleTypes.GLOW_SQUID_INK));
    // 墙壁水蜡烛
    public static final Block AQUATIC_WALL_TORCH = registerBlock("aquatic_wall_torch", new AquaticWallTorchBlock(
        AbstractBlock.Settings.create().noCollision().breakInstantly().luminance(state -> 14)
            .sounds(BlockSoundGroup.WOOD).pistonBehavior(PistonBehavior.DESTROY), ParticleTypes.GLOW_SQUID_INK));


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
        if(!(block instanceof GlowStickBlock) && !(block instanceof CropBlock) && !(block instanceof TorchBlock)){
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
