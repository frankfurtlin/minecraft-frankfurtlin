package com.frankfurtlin.frankfurtlinmod.datagen;

import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.*;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.book.RecipeCategory;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        // 荧光棒
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.GLOW_STICK, 3)
            .input('#', Items.STICK).input('I', Items.GLOW_INK_SAC)
            .pattern("I").pattern("#")
            .criterion("has_glow_ink_sac", VanillaRecipeProvider.conditionsFromItem(Items.GLOW_INK_SAC)).offerTo(exporter);
        
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SUPER_BACKPACK).input('X', Items.LEATHER)
            .pattern("X X").pattern(" X ").pattern("X X")
            .criterion("has_leather", VanillaRecipeProvider.conditionsFromItem(Items.LEATHER)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SUPER_ENDER_PACK)
            .input('B', ModItems.SUPER_BACKPACK).input('E', Items.ENDER_PEARL)
            .pattern("B").pattern("E")
            .criterion("has_backpack", VanillaRecipeProvider.conditionsFromItem(ModItems.SUPER_BACKPACK)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SUPER_CRAFTING_TABLE)
            .input('T', Items.CRAFTING_TABLE).input('S', Items.STICK)
            .pattern("T ").pattern(" S")
            .criterion("has_table", VanillaRecipeProvider.conditionsFromItem(Items.CRAFTING_TABLE)).offerTo(exporter);

        // 饮料
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.STRAWBERRY_JUICE)
            .input('S', ModItems.STRAWBERRY).input('B', Items.GLASS_BOTTLE)
            .pattern("SSS").pattern(" B ")
            .criterion("has_strawberry", VanillaRecipeProvider.conditionsFromItem(ModItems.STRAWBERRY)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.COCONUT_JUICE)
            .input('C', ModItems.COCONUT).input('B', Items.GLASS_BOTTLE)
            .pattern("CCC").pattern(" B ")
            .criterion("has_coconut", VanillaRecipeProvider.conditionsFromItem(ModItems.COCONUT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GRAPE_JUICE)
            .input('G', ModItems.GRAPE).input('B', Items.GLASS_BOTTLE)
            .pattern("GGG").pattern(" B ")
            .criterion("has_grape", VanillaRecipeProvider.conditionsFromItem(ModItems.GRAPE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.LEMONADE)
            .input('L', ModItems.LEMON).input('B', Items.GLASS_BOTTLE)
            .pattern("LLL").pattern(" B ")
            .criterion("has_lemon", VanillaRecipeProvider.conditionsFromItem(ModItems.LEMON)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MANGO_JUICE)
            .input('M', ModItems.MANGO).input('B', Items.GLASS_BOTTLE)
            .pattern("MMM").pattern(" B ")
            .criterion("has_mango", VanillaRecipeProvider.conditionsFromItem(ModItems.MANGO)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ORANGE_JUICE)
            .input('O', ModItems.ORANGE).input('B', Items.GLASS_BOTTLE)
            .pattern("OOO").pattern(" B ")
            .criterion("has_orange", VanillaRecipeProvider.conditionsFromItem(ModItems.ORANGE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.BEER)
            .input('C', ModItems.CORN).input('B', Items.GLASS_BOTTLE)
            .pattern("CCC").pattern(" B ")
            .criterion("has_corn", VanillaRecipeProvider.conditionsFromItem(ModItems.CORN)).offerTo(exporter);

        createFood(exporter, ModItems.SHRIMP, ModItems.FRIED_SHRIMP, 0.35f, 200);
        createFood(exporter, ModItems.CRAB, ModItems.STEAMED_CRAB, 0.5f, 300);

        VanillaRecipeProvider.offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, ModItems.WHITE_GOLD_INGOT,
            RecipeCategory.BUILDING_BLOCKS, ModBlocks.WHITE_GOLD_BLOCK);

        // 工具
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.WHITE_GOLD_AXE)
            .input('#', Items.STICK).input('X', ModItems.WHITE_GOLD_INGOT)
            .pattern("XX").pattern("X#").pattern(" #")
            .criterion("has_white_gold_ingot", VanillaRecipeProvider.conditionsFromItem(ModItems.WHITE_GOLD_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.WHITE_GOLD_HOE)
            .input('#', Items.STICK).input('X', ModItems.WHITE_GOLD_INGOT)
            .pattern("XX").pattern(" #").pattern(" #")
            .criterion("has_white_gold_ingot", VanillaRecipeProvider.conditionsFromItem(ModItems.WHITE_GOLD_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.WHITE_GOLD_PICKAXE)
            .input('#', Items.STICK).input('X', ModItems.WHITE_GOLD_INGOT)
            .pattern("XXX").pattern(" # ").pattern(" # ")
            .criterion("has_white_gold_ingot", VanillaRecipeProvider.conditionsFromItem(ModItems.WHITE_GOLD_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.WHITE_GOLD_SHOVEL)
            .input('#', Items.STICK).input('X', ModItems.WHITE_GOLD_INGOT)
            .pattern("X").pattern("#").pattern("#")
            .criterion("has_white_gold_ingot", VanillaRecipeProvider.conditionsFromItem(ModItems.WHITE_GOLD_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WHITE_GOLD_SWORD)
            .input('#', Items.STICK).input('X', ModItems.WHITE_GOLD_INGOT).pattern("X").pattern("X").pattern("#")
            .criterion("has_white_gold_ingot", VanillaRecipeProvider.conditionsFromItem(ModItems.WHITE_GOLD_INGOT)).offerTo(exporter);

        // 装备
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WHITE_GOLD_BOOTS)
            .input('X', ModItems.WHITE_GOLD_INGOT).pattern("X X").pattern("X X")
            .criterion("has_white_gold_ingot", VanillaRecipeProvider.conditionsFromItem(ModItems.WHITE_GOLD_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WHITE_GOLD_CHESTPLATE)
            .input('X', ModItems.WHITE_GOLD_INGOT).input('E', Items.ELYTRA)
            .pattern("X X").pattern("XEX").pattern("XXX")
            .criterion("has_white_gold_ingot", VanillaRecipeProvider.conditionsFromItem(ModItems.WHITE_GOLD_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WHITE_GOLD_HELMET)
            .input('X', ModItems.WHITE_GOLD_INGOT).pattern("XXX").pattern("X X")
            .criterion("has_white_gold_ingot", VanillaRecipeProvider.conditionsFromItem(ModItems.WHITE_GOLD_INGOT)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.WHITE_GOLD_LEGGINGS)
            .input('X', ModItems.WHITE_GOLD_INGOT).pattern("XXX").pattern("X X").pattern("X X")
            .criterion("has_white_gold_ingot", VanillaRecipeProvider.conditionsFromItem(ModItems.WHITE_GOLD_INGOT)).offerTo(exporter);

    }

    private void createFood(RecipeExporter exporter, Item input, Item output, float experience, int cookingTime){
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(input),
                RecipeCategory.FOOD, output, experience, cookingTime)
            .criterion("has_" + input, VanillaRecipeProvider.conditionsFromItem(input)).offerTo(exporter);
        RecipeProvider.offerFoodCookingRecipe(exporter, "smoking", RecipeSerializer.SMOKING, cookingTime, input, output, experience);
        RecipeProvider.offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, cookingTime, input, output, experience);
    }
}
