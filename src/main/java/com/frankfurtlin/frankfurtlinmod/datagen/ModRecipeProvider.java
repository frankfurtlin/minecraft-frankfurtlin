package com.frankfurtlin.frankfurtlinmod.datagen;

import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
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
            .pattern("I ").pattern(" #")
            .criterion("has_glow_ink_sac", VanillaRecipeProvider.conditionsFromItem(Items.GLOW_INK_SAC)).offerTo(exporter);
        // 水蜡烛
        ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, ModItems.AQUATIC_TORCH, 4)
            .input('#', Items.STICK).input('I', Items.GLOW_INK_SAC)
            .pattern("I").pattern("#")
            .criterion("has_glow_ink_sac", VanillaRecipeProvider.conditionsFromItem(Items.GLOW_INK_SAC)).offerTo(exporter);
        // 冰球
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ICE_BALL, 8)
            .input('#', Items.SNOWBALL).input('I', Items.ICE)
            .pattern("###").pattern("#I#").pattern("###")
            .criterion("has_ice", VanillaRecipeProvider.conditionsFromItem(Items.ICE)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.PACKED_ICE_BALL, 8)
            .input('#', ModItems.ICE_BALL).input('I', Items.PACKED_ICE)
            .pattern("###").pattern("#I#").pattern("###")
            .criterion("has_packed_ice_ball", VanillaRecipeProvider.conditionsFromItem(ModItems.ICE_BALL)).offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.BLUE_ICE_BALL, 8)
            .input('#', ModItems.PACKED_ICE_BALL).input('I', Items.BLUE_ICE)
            .pattern("###").pattern("#I#").pattern("###")
            .criterion("has_blue_ice_ball", VanillaRecipeProvider.conditionsFromItem(ModItems.PACKED_ICE_BALL)).offerTo(exporter);
        // 岩浆海绵
        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.LAVA_SPONGE, 8)
            .input('#', Items.SPONGE).input('M', Blocks.MAGMA_BLOCK)
            .pattern("###").pattern("#M#").pattern("###")
            .criterion("has_sponge", VanillaRecipeProvider.conditionsFromItem(Items.SPONGE)).offerTo(exporter);

        // 实用物品
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

        VanillaRecipeProvider.offerReversibleCompactingRecipes(exporter, RecipeCategory.MISC, Items.ECHO_SHARD,
            RecipeCategory.BUILDING_BLOCKS, ModBlocks.SCULKHYST_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.ECHO_STAFF)
            .input('#', Items.STICK).input('X', Items.ECHO_SHARD).pattern("X").pattern("#").pattern("#")
            .criterion("has_echo_shard", VanillaRecipeProvider.conditionsFromItem(Items.ECHO_SHARD)).offerTo(exporter);

        offerWanderUpgradeRecipe(exporter, Items.DIAMOND_CHESTPLATE, RecipeCategory.COMBAT, ModItems.WARDEN_CHESTPLATE);
        offerWanderUpgradeRecipe(exporter, Items.DIAMOND_LEGGINGS, RecipeCategory.COMBAT, ModItems.WARDEN_LEGGINGS);
        offerWanderUpgradeRecipe(exporter, Items.DIAMOND_HELMET, RecipeCategory.COMBAT, ModItems.WARDEN_HELMET);
        offerWanderUpgradeRecipe(exporter, Items.DIAMOND_BOOTS, RecipeCategory.COMBAT, ModItems.WARDEN_BOOTS);
        offerWanderUpgradeRecipe(exporter, Items.DIAMOND_SWORD, RecipeCategory.COMBAT, ModItems.WARDEN_SWORD);
        offerWanderUpgradeRecipe(exporter, Items.DIAMOND_AXE, RecipeCategory.TOOLS, ModItems.WARDEN_AXE);
        offerWanderUpgradeRecipe(exporter, Items.DIAMOND_PICKAXE, RecipeCategory.TOOLS, ModItems.WARDEN_PICKAXE);
        offerWanderUpgradeRecipe(exporter, Items.DIAMOND_HOE, RecipeCategory.TOOLS, ModItems.WARDEN_HOE);
        offerWanderUpgradeRecipe(exporter, Items.DIAMOND_SHOVEL, RecipeCategory.TOOLS, ModItems.WARDEN_SHOVEL);
        VanillaRecipeProvider.offerSmithingTemplateCopyingRecipe(exporter, ModItems.WARDEN_UPGRADE_SMITHING_TEMPLATE, Items.ECHO_SHARD);
        
    }

    private void createFood(RecipeExporter exporter, Item input, Item output, float experience, int cookingTime){
        CookingRecipeJsonBuilder.createSmelting(Ingredient.ofItems(input),
                RecipeCategory.FOOD, output, experience, cookingTime)
            .criterion("has_" + input, VanillaRecipeProvider.conditionsFromItem(input)).offerTo(exporter);
        RecipeProvider.offerFoodCookingRecipe(exporter, "smoking", RecipeSerializer.SMOKING, cookingTime, input, output, experience);
        RecipeProvider.offerFoodCookingRecipe(exporter, "campfire_cooking", RecipeSerializer.CAMPFIRE_COOKING, cookingTime, input, output, experience);
    }

    private static void offerWanderUpgradeRecipe(RecipeExporter exporter, Item input, RecipeCategory category, Item result) {
        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.WARDEN_UPGRADE_SMITHING_TEMPLATE), 
            Ingredient.ofItems(input), Ingredient.ofItems(Items.ECHO_SHARD), category, result)
            .criterion("has_echo_shard", RecipeProvider.conditionsFromItem(Items.ECHO_SHARD))
            .offerTo(exporter, RecipeProvider.getItemPath(result) + "_smithing");
    }
}
