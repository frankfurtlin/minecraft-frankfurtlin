package com.frankfurtlin.frankfurtlinmod;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

/**
 * cloth config annotation develop
 * <a href="https://shedaniel.gitbook.io/cloth-config/auto-config/annotations">...</a>
 */
@Config(name = "frankfurtlin")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.Excluded
    public static ModConfig INSTANCE;

    public static void init()
    {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
        INSTANCE = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }

    /**
     * 特性
     */
    @ConfigEntry.Gui.PrefixText()
    @Comment("If true, when you throw a fishing rod, you can automatically fish")
    public boolean autoFish = false;
    @Comment("If true, villager trade will be infinity")
    public boolean unLockVillager = true;
    @Comment("set the experience drop by experience bottle")
    @ConfigEntry.BoundedDiscrete(min = 5, max = 100)
    public int experienceBottle = 100;

    /**
     * 物品相关
     */
    @ConfigEntry.Gui.PrefixText()
    @Comment("If true, you can use TOTEM_OF_UNDYING in your inventory")
    public boolean useTotemOFUndyingInInventory = true;
    @Comment("If true, TOTEM_OF_UNDYING can be stack to 64")
    public boolean canTotemOFUndyingBeStack = true;

    /**
     * 铁砧附魔增强
     */
    @ConfigEntry.Gui.PrefixText()
    @Comment("If true, remove anvil enchantment level limit")
    public boolean removeAnvilLimit = true;
    @Comment("If true, remove anvil enchantment level exponential increase")
    public boolean removeAnvilExponentialIncrease = true;

    /**
     * 附魔冲突解决
     */
    @ConfigEntry.Gui.PrefixText()
    @Comment("If true, remove SHARPNESS, SMITE, BANE_OF_ARTHROPODS conflict")
    public boolean removeDamageEnchantmentConflict = true;
    @Comment("If true, remove INFINITY, MENDING conflict")
    public boolean removeInfinityEnchantmentConflict = true;
    @Comment("If true, remove PROTECTION, FIRE_PROTECTION, BLAST_PROTECTION, PROJECTILE_PROTECTION conflict")
    public boolean removeProtectionEnchantmentConflict = true;

    /**
     * 怪物刷怪笼
     */
    @ConfigEntry.Gui.PrefixText()
    @Comment("If true, enhance mob spawner logic")
    public boolean mobSpawnerEnhance = true;
    @Comment("set the min mob spawner delay second")
    @ConfigEntry.BoundedDiscrete(min = 1, max = 20)
    public int minSpawnDelay = 10;
    @Comment("set the max mob spawner delay second")
    @ConfigEntry.BoundedDiscrete(min = 4, max = 60)
    public int maxSpawnDelay = 40;
    @Comment("set the mob spawner count")
    @ConfigEntry.BoundedDiscrete(min = 1, max = 8)
    public int spawnCount = 4;

    /**
     * 僵尸猪灵、凋零骷髅武器掉落优化
     */
    @ConfigEntry.Gui.PrefixText()
    @Comment("If true, zombified piglin don't drop golden sword")
    public boolean zombifiedPiglinLootTableOptimize = true;
    @Comment("If true, wither skeleton don't drop stone sword")
    public boolean witherSkeletonLootTableOptimize = true;

    /**
     * 溺尸生成概率、武器装备概率、武器掉落概率
     */
    @ConfigEntry.Gui.PrefixText()
    @Comment("set the spawn change in river of drowned, the smaller the better")
    @ConfigEntry.BoundedDiscrete(min = 1, max = 15)
    public int drownedSpawnInRiverRate = 15;
    @Comment("set the spawn change in ocean of drowned, the smaller the better")
    @ConfigEntry.BoundedDiscrete(min = 5, max = 40)
    public int drownedSpawnInOceanRate = 40;
    @Comment("set the change drowned with equipment")
    public double drownedSpawnWithEquipment = 0.1;
    @Comment("If true, drowned always drop weapon")
    public boolean drownedAlwaysDropWeapon = true;

}
