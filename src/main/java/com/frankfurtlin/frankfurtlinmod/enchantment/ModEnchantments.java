package com.frankfurtlin.frankfurtlinmod.enchantment;

import com.frankfurtlin.frankfurtlinmod.Frankfurtlinmod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/30 10:53
 */
public class ModEnchantments {
    public static Enchantment AUTO_SMELT = registerEnchantment("auto_smelt", new AutoSmeltEnchantment());
    public static Enchantment DROP_ON_PLAYER = registerEnchantment("drop_on_player", new DropOnPlayerEnchantment());
    public static Enchantment ATTRACTION = registerEnchantment("attraction", new AttractionEnchantment());
    public static Enchantment BOOST_JUMP = registerEnchantment("boost_jump", new BoostJumpEnchantment());
    public static Enchantment WALK_ON_FLUID = registerEnchantment("walk_on_fluid", new WalkOnFluidEnchantment());
    public static Enchantment REFLECTION = registerEnchantment("reflection", new ReflectionEnchantment());
    public static Enchantment LAVA_WALKER = registerEnchantment("lava_walker", new HotWalkerEnchantment());

    private static Enchantment registerEnchantment(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(Frankfurtlinmod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        Frankfurtlinmod.LOGGER.info("Registering Mod enchantments for " + Frankfurtlinmod.MOD_ID);
    }
}
