package com.frankfurtlin.frankfurtlinmod.util;

import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/12/3 12:54
 * 锻造模版
 */
public class ModSmithingTemplateItem {
    private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
    private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;

    private static final Text NETHERITE_UPGRADE_APPLIES_TO_TEXT =
        Text.translatable(Util.createTranslationKey("item",
            new Identifier("frankfurtlin", "smithing_template.echo_shard_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text NETHERITE_UPGRADE_INGREDIENTS_TEXT =
        Text.translatable(Util.createTranslationKey("item",
            new Identifier("frankfurtlin", "smithing_template.echo_shard_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text NETHERITE_UPGRADE_TEXT =
        Text.translatable(Util.createTranslationKey("upgrade",
            new Identifier("frankfurtlin", "echo_shard_upgrade"))).formatted(TITLE_FORMATTING);
    private static final Text NETHERITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT =
        Text.translatable(Util.createTranslationKey("item",
            new Identifier("frankfurtlin", "smithing_template.echo_shard_upgrade.base_slot_description")));
    private static final Text NETHERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT =
        Text.translatable(Util.createTranslationKey("item",
            new Identifier("frankfurtlin", "smithing_template.echo_shard_upgrade.additions_slot_description")));

    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new Identifier("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new Identifier("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = new Identifier("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = new Identifier("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = new Identifier("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = new Identifier("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = new Identifier("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_ECHO_SHARD_TEXTURE = new Identifier("frankfurtlin", "item/empty_slot_echo_shard");

    private static List<Identifier> getEchoShardUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE,
            EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE,
            EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE,
            EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE);
    }

    private static List<Identifier> getEchoShardUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_ECHO_SHARD_TEXTURE);
    }

    public static SmithingTemplateItem createEchoShardUpgrade() {
        return new SmithingTemplateItem(
            NETHERITE_UPGRADE_APPLIES_TO_TEXT,
            NETHERITE_UPGRADE_INGREDIENTS_TEXT,
            NETHERITE_UPGRADE_TEXT,
            NETHERITE_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT,
            NETHERITE_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT,
            getEchoShardUpgradeEmptyBaseSlotTextures(),
            getEchoShardUpgradeEmptyAdditionsSlotTextures());
    }

}
