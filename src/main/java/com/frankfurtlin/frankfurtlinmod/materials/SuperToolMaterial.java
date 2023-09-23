package com.frankfurtlin.frankfurtlinmod.materials;

import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.fabricmc.yarn.constants.MiningLevels;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/23 15:36
 * 原能工具材料
 */
public enum SuperToolMaterial implements ToolMaterial {
    SUPER_ITEM_MATERIAL(MiningLevels.NETHERITE + 1, 3031, 15.0f, 6.0f, 30,
        () -> Ingredient.ofItems(ModItems.SUPER_ITEM));

    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairIngredient;

    SuperToolMaterial(int miningLevel, int itemDurability, float miningSpeed, float attackDamage,
                      int enchantability, Supplier<Ingredient> repairIngredient) {
        this.miningLevel = miningLevel;
        this.itemDurability = itemDurability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability() {
        return this.itemDurability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}