package com.frankfurtlin.frankfurtlinmod.datagen;

import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.item.ArmorItem;
import net.minecraft.state.property.Properties;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SCULKHYST_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LAVA_SPONGE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.LAVA_WET_SPONGE);
        blockStateModelGenerator.registerTorch(ModBlocks.AQUATIC_TORCH, ModBlocks.AQUATIC_WALL_TORCH);
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(ModBlocks.HOT_OBSIDIAN)
            .coordinate(BlockStateVariantMap.create(Properties.AGE_5)
                .register(0, BlockStateVariant.create().put(VariantSettings.MODEL,
                    blockStateModelGenerator.createSubModel(ModBlocks.HOT_OBSIDIAN, "_0", Models.CUBE_ALL, TextureMap::all)))
                .register(1, BlockStateVariant.create().put(VariantSettings.MODEL,
                    blockStateModelGenerator.createSubModel(ModBlocks.HOT_OBSIDIAN, "_1", Models.CUBE_ALL, TextureMap::all)))
                .register(2, BlockStateVariant.create().put(VariantSettings.MODEL,
                    blockStateModelGenerator.createSubModel(ModBlocks.HOT_OBSIDIAN, "_2", Models.CUBE_ALL, TextureMap::all)))
                .register(3, BlockStateVariant.create().put(VariantSettings.MODEL,
                    blockStateModelGenerator.createSubModel(ModBlocks.HOT_OBSIDIAN, "_3", Models.CUBE_ALL, TextureMap::all)))
                .register(4, BlockStateVariant.create().put(VariantSettings.MODEL,
                    blockStateModelGenerator.createSubModel(ModBlocks.HOT_OBSIDIAN, "_4", Models.CUBE_ALL, TextureMap::all)))
                .register(5, BlockStateVariant.create().put(VariantSettings.MODEL,
                    blockStateModelGenerator.createSubModel(ModBlocks.HOT_OBSIDIAN, "_5", Models.CUBE_ALL, TextureMap::all)))));
        blockStateModelGenerator.registerItemModel(ModBlocks.HOT_OBSIDIAN, "_0");

        // 蔬菜水果
        blockStateModelGenerator.registerCrop(ModBlocks.STRAWBERRY_CROP, Properties.AGE_7, 0, 1, 1, 1, 2, 2, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.BLACKBERRY_CROP, Properties.AGE_7, 0, 1, 1, 1, 2, 2, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.BLUEBERRY_CROP, Properties.AGE_7, 0, 1, 1, 1, 2, 2, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, Properties.AGE_7, 0, 1, 1, 1, 2, 2, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.KIWI_CROP, Properties.AGE_7, 0, 1, 1, 1, 2, 2, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.PINEAPPLE_CROP, Properties.AGE_7, 0, 1, 1, 1, 2, 2, 2, 3);
        blockStateModelGenerator.registerCrop(ModBlocks.GRAPE_CROP, Properties.AGE_7, 0, 1, 1, 1, 2, 2, 2, 3);

        // 矿物簇母岩
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_COAL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_IRON);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_COPPER);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_GOLD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_EMERALD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_LAPIS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_DIAMOND);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_REDSTONE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_QUARTZ);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_NETHERITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BUDDING_SCULKHYST);

        // 矿物簇
        blockStateModelGenerator.registerAmethyst(ModBlocks.COAL_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.IRON_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.COPPER_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.GOLD_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LAPIS_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.EMERALD_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.DIAMOND_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.REDSTONE_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.QUARTZ_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.NETHERITE_CLUSTER);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SCULKHYST_CLUSTER);

        blockStateModelGenerator.registerItemModel(ModBlocks.COAL_CLUSTER);
        blockStateModelGenerator.registerItemModel(ModBlocks.IRON_CLUSTER);
        blockStateModelGenerator.registerItemModel(ModBlocks.COPPER_CLUSTER);
        blockStateModelGenerator.registerItemModel(ModBlocks.GOLD_CLUSTER);
        blockStateModelGenerator.registerItemModel(ModBlocks.LAPIS_CLUSTER);
        blockStateModelGenerator.registerItemModel(ModBlocks.EMERALD_CLUSTER);
        blockStateModelGenerator.registerItemModel(ModBlocks.DIAMOND_CLUSTER);
        blockStateModelGenerator.registerItemModel(ModBlocks.REDSTONE_CLUSTER);
        blockStateModelGenerator.registerItemModel(ModBlocks.QUARTZ_CLUSTER);
        blockStateModelGenerator.registerItemModel(ModBlocks.NETHERITE_CLUSTER);
        blockStateModelGenerator.registerItemModel(ModBlocks.SCULKHYST_CLUSTER);

        // 小型矿物簇
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_COAL_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_IRON_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_COPPER_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_GOLD_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_LAPIS_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_EMERALD_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_DIAMOND_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_REDSTONE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_QUARTZ_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_NETHERITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.SMALL_SCULKHYST_BUD);

        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_COAL_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_IRON_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_COPPER_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_GOLD_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_LAPIS_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_EMERALD_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_DIAMOND_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_REDSTONE_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_QUARTZ_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_NETHERITE_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.SMALL_SCULKHYST_BUD);

        // 中型矿物簇
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_COAL_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_IRON_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_COPPER_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_GOLD_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_LAPIS_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_EMERALD_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_DIAMOND_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_REDSTONE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_QUARTZ_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_NETHERITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.MEDIUM_SCULKHYST_BUD);

        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_COAL_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_IRON_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_COPPER_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_GOLD_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_LAPIS_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_EMERALD_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_DIAMOND_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_REDSTONE_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_QUARTZ_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_NETHERITE_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.MEDIUM_SCULKHYST_BUD);

        // 大型矿物簇
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_COAL_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_IRON_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_COPPER_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_GOLD_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_LAPIS_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_EMERALD_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_DIAMOND_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_REDSTONE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_QUARTZ_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_NETHERITE_BUD);
        blockStateModelGenerator.registerAmethyst(ModBlocks.LARGE_SCULKHYST_BUD);

        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_COAL_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_IRON_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_COPPER_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_GOLD_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_LAPIS_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_EMERALD_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_DIAMOND_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_REDSTONE_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_QUARTZ_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_NETHERITE_BUD);
        blockStateModelGenerator.registerItemModel(ModBlocks.LARGE_SCULKHYST_BUD);

        // 矿物甘蔗
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.COAL_CANE, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.IRON_CANE, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.COPPER_CANE, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.GOLD_CANE, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.LAPIS_CANE, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.EMERALD_CANE, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.DIAMOND_CANE, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.REDSTONE_CANE, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.QUARTZ_CANE, BlockStateModelGenerator.TintType.TINTED);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.NETHERITE_CANE, BlockStateModelGenerator.TintType.TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // 实用物品
        itemModelGenerator.register(ModItems.SUPER_BACKPACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUPER_ENDER_PACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUPER_CRAFTING_TABLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLOW_STICK, Models.GENERATED);
        itemModelGenerator.register(ModItems.ICE_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.PACKED_ICE_BALL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BLUE_ICE_BALL, Models.GENERATED);

        // 水果
        itemModelGenerator.register(ModItems.BANANA, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORANGE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STARFRUIT, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANGO, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCONUT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAGONFRUIT, Models.GENERATED);

        // 虾蟹
        itemModelGenerator.register(ModItems.CRAB, Models.GENERATED);
        itemModelGenerator.register(ModItems.STEAMED_CRAB, Models.GENERATED);
        itemModelGenerator.register(ModItems.SHRIMP, Models.GENERATED);
        itemModelGenerator.register(ModItems.FRIED_SHRIMP, Models.GENERATED);

        // 水果汁
        itemModelGenerator.register(ModItems.STRAWBERRY_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.COCONUT_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRAPE_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MANGO_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ORANGE_JUICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LEMONADE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEER, Models.GENERATED);

        // 坚守者法杖
        itemModelGenerator.register(ModItems.ECHO_STAFF, Models.GENERATED);
        // 坚守者锻造模板
        itemModelGenerator.register(ModItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, Models.GENERATED);

        // 坚守者工具
        itemModelGenerator.register(ModItems.WARDEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARDEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARDEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARDEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.WARDEN_HOE, Models.HANDHELD);

        // 坚守者盔甲
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.WARDEN_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.WARDEN_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.WARDEN_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.WARDEN_BOOTS));


    }
}
