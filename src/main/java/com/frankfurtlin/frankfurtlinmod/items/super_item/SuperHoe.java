package com.frankfurtlin.frankfurtlinmod.items.super_item;

import net.minecraft.item.HoeItem;
import net.minecraft.item.ToolMaterial;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/23 16:44
 */
public class SuperHoe extends HoeItem {
    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     *
     * @param material 材料
     * @param attackDamage 伤害
     * @param attackSpeed 攻击速度
     * @param settings 设置
     */
    public SuperHoe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
}
