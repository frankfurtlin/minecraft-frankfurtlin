package com.frankfurtlin.frankfurtlinmod.datagen;

import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.function.Consumer;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/18 11:32
 */
public class ModAdvancementProvider extends FabricAdvancementProvider {
    public ModAdvancementProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateAdvancement(Consumer<AdvancementEntry> consumer) {

        // -------------------------------------------------------------------------------------------------------------
        AdvancementEntry superRootAdvancement = Advancement.Builder.create()
            .display(
                Items.ECHO_SHARD, // The display icon
                Text.translatable("advancements.frankfurtlin.super.root.title"),
                Text.translatable("advancements.frankfurtlin.super.root.description"),
                new Identifier("minecraft:textures/gui/advancements/backgrounds/stone.png"), // Background image used
                AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                true, // Show toast top right
                true, // Announce to chat
                false // Hidden in the advancement tab
            )
            // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
            .criterion("got_echo_shard", InventoryChangedCriterion.Conditions.items(Items.ECHO_SHARD))
            .build(consumer, "frankfurtlin" + "/super/root");

        Advancement.Builder.create().parent(superRootAdvancement)
            .display(
                ModItems.WARDEN_CHESTPLATE,
                Text.translatable("advancements.frankfurtlin.super.warden_armor.title"),
                Text.translatable("advancements.frankfurtlin.super.warden_armor.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(1000))
            .criterion("got_warden_helmet", InventoryChangedCriterion.Conditions.items(ModItems.WARDEN_HELMET))
            .criterion("got_warden_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.WARDEN_CHESTPLATE))
            .criterion("got_warden_leggings", InventoryChangedCriterion.Conditions.items(ModItems.WARDEN_LEGGINGS))
            .criterion("got_warden_boots", InventoryChangedCriterion.Conditions.items(ModItems.WARDEN_BOOTS))
            .build(consumer, "frankfurtlin" + "/super/warden_armors");

        Advancement.Builder.create().parent(superRootAdvancement)
            .display(
                ModItems.WARDEN_PICKAXE,
                Text.translatable("advancements.frankfurtlin.super.warden_tool.title"),
                Text.translatable("advancements.frankfurtlin.super.warden_tool.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(1000))
            .criterion("got_warden_sword", InventoryChangedCriterion.Conditions.items(ModItems.WARDEN_SWORD))
            .criterion("got_warden_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.WARDEN_PICKAXE))
            .criterion("got_warden_axe", InventoryChangedCriterion.Conditions.items(ModItems.WARDEN_AXE))
            .criterion("got_warden_shovel", InventoryChangedCriterion.Conditions.items(ModItems.WARDEN_SHOVEL))
            .criterion("got_warden_hoe", InventoryChangedCriterion.Conditions.items(ModItems.WARDEN_HOE))
            .build(consumer, "frankfurtlin" + "/super/warden_tools");

        Advancement.Builder.create().parent(superRootAdvancement)
            .display(
                ModBlocks.DIAMOND_CLUSTER,
                Text.translatable("advancements.frankfurtlin.super.cluster.title"),
                Text.translatable("advancements.frankfurtlin.super.cluster.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(1000))
            .criterion("amethyst_cluster", InventoryChangedCriterion.Conditions.items(Blocks.AMETHYST_CLUSTER))
            .criterion("coal_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.COAL_CLUSTER))
            .criterion("iron_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.IRON_CLUSTER))
            .criterion("copper_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.COPPER_CLUSTER))
            .criterion("gold_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.GOLD_CLUSTER))
            .criterion("lapis_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.LAPIS_CLUSTER))
            .criterion("emerald_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.EMERALD_CLUSTER))
            .criterion("diamond_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.DIAMOND_CLUSTER))
            .criterion("redstone_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.REDSTONE_CLUSTER))
            .criterion("quartz_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.QUARTZ_CLUSTER))
            .criterion("netherite_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.NETHERITE_CLUSTER))
            .criterion("sculkhyst_cluster", InventoryChangedCriterion.Conditions.items(ModBlocks.SCULKHYST_CLUSTER))
            .build(consumer, "frankfurtlin" + "/super/cluster");

        Advancement.Builder.create().parent(superRootAdvancement)
            .display(
                ModBlocks.BUDDING_DIAMOND,
                Text.translatable("advancements.frankfurtlin.super.budding.title"),
                Text.translatable("advancements.frankfurtlin.super.budding.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(1000))
            .criterion("budding_amethyst", InventoryChangedCriterion.Conditions.items(Blocks.BUDDING_AMETHYST))
            .criterion("budding_coal", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_COAL))
            .criterion("budding_iron", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_IRON))
            .criterion("budding_copper", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_COPPER))
            .criterion("budding_gold", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_GOLD))
            .criterion("budding_lapis", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_LAPIS))
            .criterion("budding_emerald", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_EMERALD))
            .criterion("budding_diamond", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_DIAMOND))
            .criterion("budding_redstone", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_REDSTONE))
            .criterion("budding_quartz", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_QUARTZ))
            .criterion("budding_netherite", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_NETHERITE))
            .criterion("budding_sculkhyst", InventoryChangedCriterion.Conditions.items(ModBlocks.BUDDING_SCULKHYST))
            .build(consumer, "frankfurtlin" + "/super/budding");





        // -------------------------------------------------------------------------------------------------------------

        AdvancementEntry additionRootAdvancement = Advancement.Builder.create()
            .display(
                Items.LEATHER, // The display icon
                Text.translatable("advancements.frankfurtlin.addition.root.title"),
                Text.translatable("advancements.frankfurtlin.addition.root.description"),
                new Identifier("minecraft:textures/gui/advancements/backgrounds/adventure.png"), // Background image used
                AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                false, // Show toast top right
                false, // Announce to chat
                false // Hidden in the advancement tab
            )
            // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
            .criterion("got_leather", InventoryChangedCriterion.Conditions.items(Items.LEATHER))
            .build(consumer, "frankfurtlin" + "/addition/root");

        Advancement.Builder.create().parent(additionRootAdvancement)
            .display(
                ModItems.SUPER_CRAFTING_TABLE,
                Text.translatable("advancements.frankfurtlin.addition.crafting_table.title"),
                Text.translatable("advancements.frankfurtlin.addition.crafting_table.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(100))
            .criterion("got_crafting_table", InventoryChangedCriterion.Conditions.items(ModItems.SUPER_CRAFTING_TABLE))
            .build(consumer, "frankfurtlin" + "/addition/crafting_table");

        AdvancementEntry gotBackpack = Advancement.Builder.create().parent(additionRootAdvancement)
            .display(
                ModItems.SUPER_BACKPACK,
                Text.translatable("advancements.frankfurtlin.addition.backpack.title"),
                Text.translatable("advancements.frankfurtlin.addition.backpack.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(100))
            .criterion("got_backpack", InventoryChangedCriterion.Conditions.items(ModItems.SUPER_BACKPACK))
            .build(consumer, "frankfurtlin" + "/addition/backpack");

        Advancement.Builder.create().parent(gotBackpack)
            .display(
                ModItems.SUPER_ENDER_PACK,
                Text.translatable("advancements.frankfurtlin.addition.ender_pack.title"),
                Text.translatable("advancements.frankfurtlin.addition.ender_pack.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(100))
            .criterion("got_ender_pack", InventoryChangedCriterion.Conditions.items(ModItems.SUPER_ENDER_PACK))
            .build(consumer, "frankfurtlin" + "/addition/ender_pack");

        Advancement.Builder.create().parent(additionRootAdvancement)
            .display(
                ModItems.GLOW_STICK,
                Text.translatable("advancements.frankfurtlin.addition.glow_stick.title"),
                Text.translatable("advancements.frankfurtlin.addition.glow_stick.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(100))
            .criterion("got_glow_stick", InventoryChangedCriterion.Conditions.items(ModItems.GLOW_STICK))
            .build(consumer, "frankfurtlin" + "/addition/glow_stick");

        Advancement.Builder.create().parent(additionRootAdvancement)
            .display(
                ModItems.AQUATIC_TORCH,
                Text.translatable("advancements.frankfurtlin.addition.aquatic_torch.title"),
                Text.translatable("advancements.frankfurtlin.addition.aquatic_torch.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(100))
            .criterion("got_aquatic_torch", InventoryChangedCriterion.Conditions.items(ModItems.AQUATIC_TORCH))
            .build(consumer, "frankfurtlin" + "/addition/aquatic_torch");

        Advancement.Builder.create().parent(additionRootAdvancement)
            .display(
                ModItems.BLUE_ICE_BALL,
                Text.translatable("advancements.frankfurtlin.addition.ice_ball.title"),
                Text.translatable("advancements.frankfurtlin.addition.ice_ball.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(1000))
            .criterion("use_ice_ball", InventoryChangedCriterion.Conditions.items(ModItems.ICE_BALL))
            .criterion("use_packed_ice_ball", InventoryChangedCriterion.Conditions.items(ModItems.PACKED_ICE_BALL))
            .criterion("use_blue_ice_ball", InventoryChangedCriterion.Conditions.items(ModItems.BLUE_ICE_BALL))
            .build(consumer, "frankfurtlin" + "/addition/ice_ball");


        // -------------------------------------------------------------------------------------------------------------
        AdvancementEntry foodRootAdvancement = Advancement.Builder.create()
            .display(
                Items.WHEAT_SEEDS, // The display icon
                Text.translatable("advancements.frankfurtlin.foods.root.title"),
                Text.translatable("advancements.frankfurtlin.foods.root.description"),
                new Identifier("minecraft:textures/gui/advancements/backgrounds/husbandry.png"), // Background image used
                AdvancementFrame.TASK, // Options: TASK, CHALLENGE, GOAL
                false, // Show toast top right
                false, // Announce to chat
                false // Hidden in the advancement tab
            )
            // The first string used in criterion is the name referenced by other advancements when they want to have 'requirements'
            .criterion("got_wheat_seed", InventoryChangedCriterion.Conditions.items(Items.WHEAT_SEEDS))
            .build(consumer, "frankfurtlin" + "/foods/root");

        Advancement.Builder.create().parent(foodRootAdvancement)
            .display(
                ModItems.SHRIMP,
                Text.translatable("advancements.frankfurtlin.foods.seafood.title"),
                Text.translatable("advancements.frankfurtlin.foods.seafood.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(100))
            .criterion("got_shrimp", InventoryChangedCriterion.Conditions.items(ModItems.SHRIMP))
            .criterion("got_crab", InventoryChangedCriterion.Conditions.items(ModItems.CRAB))
            .build(consumer, "frankfurtlin" + "/foods/seafood");

        AdvancementEntry cornAdvancement = Advancement.Builder.create().parent(foodRootAdvancement)
            .display(
                ModItems.CORN,
                Text.translatable("advancements.frankfurtlin.foods.corn.title"),
                Text.translatable("advancements.frankfurtlin.foods.corn.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(100))
            .criterion("got_corn", InventoryChangedCriterion.Conditions.items(ModItems.CORN))
            .build(consumer, "frankfurtlin" + "/foods/corn");

        Advancement.Builder.create().parent(cornAdvancement)
            .display(
                ModItems.BEER,
                Text.translatable("advancements.frankfurtlin.foods.beer.title"),
                Text.translatable("advancements.frankfurtlin.foods.beer.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(100))
            .criterion("got_beer", InventoryChangedCriterion.Conditions.items(ModItems.BEER))
            .build(consumer, "frankfurtlin" + "/foods/beer");

        Advancement.Builder.create().parent(foodRootAdvancement)
            .display(
                ModItems.STARFRUIT,
                Text.translatable("advancements.frankfurtlin.foods.all_fruits.title"),
                Text.translatable("advancements.frankfurtlin.foods.all_fruits.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(1000))
            .criterion("got_strawberry", InventoryChangedCriterion.Conditions.items(ModItems.STRAWBERRY))
            .criterion("got_blackberry", InventoryChangedCriterion.Conditions.items(ModItems.BLACKBERRY))
            .criterion("got_blueberry", InventoryChangedCriterion.Conditions.items(ModItems.BLUEBERRY))
            .criterion("got_banana", InventoryChangedCriterion.Conditions.items(ModItems.BANANA))
            .criterion("got_cherry", InventoryChangedCriterion.Conditions.items(ModItems.CHERRY))
            .criterion("got_coconut", InventoryChangedCriterion.Conditions.items(ModItems.COCONUT))
            .criterion("got_starfruit", InventoryChangedCriterion.Conditions.items(ModItems.STARFRUIT))
            .criterion("got_grape", InventoryChangedCriterion.Conditions.items(ModItems.GRAPE))
            .criterion("got_kiwi", InventoryChangedCriterion.Conditions.items(ModItems.KIWI))
            .criterion("got_mango", InventoryChangedCriterion.Conditions.items(ModItems.MANGO))
            .criterion("got_lemon", InventoryChangedCriterion.Conditions.items(ModItems.LEMON))
            .criterion("got_orange", InventoryChangedCriterion.Conditions.items(ModItems.ORANGE))
            .criterion("got_dragonfruit", InventoryChangedCriterion.Conditions.items(ModItems.DRAGONFRUIT))
            .criterion("got_pineapple", InventoryChangedCriterion.Conditions.items(ModItems.PINEAPPLE))
            .build(consumer, "frankfurtlin" + "/foods/all_fruits");

        Advancement.Builder.create().parent(foodRootAdvancement)
            .display(
                ModItems.LEMONADE,
                Text.translatable("advancements.frankfurtlin.foods.all_juice.title"),
                Text.translatable("advancements.frankfurtlin.foods.all_juice.description"),
                null, // children to parent advancements don't need a background set
                AdvancementFrame.TASK,
                true,
                true,
                false
            )
            .rewards(AdvancementRewards.Builder.experience(1000))
            .criterion("got_coconut_juice", InventoryChangedCriterion.Conditions.items(ModItems.COCONUT_JUICE))
            .criterion("got_lemonade", InventoryChangedCriterion.Conditions.items(ModItems.LEMONADE))
            .criterion("got_grape_juice", InventoryChangedCriterion.Conditions.items(ModItems.GRAPE_JUICE))
            .criterion("got_mango_juice", InventoryChangedCriterion.Conditions.items(ModItems.MANGO_JUICE))
            .criterion("got_strawberry_juice", InventoryChangedCriterion.Conditions.items(ModItems.STRAWBERRY_JUICE))
            .criterion("got_orange_juice", InventoryChangedCriterion.Conditions.items(ModItems.ORANGE_JUICE))
            .build(consumer, "frankfurtlin" + "/foods/all_juices");
    }
}
