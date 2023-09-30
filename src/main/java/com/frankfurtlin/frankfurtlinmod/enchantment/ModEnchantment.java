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
public class ModEnchantment {
    public static Enchantment AUTO_SMELT = registerEnchantment("auto_smelt", new AutoSmeltEnchantment());

    private static Enchantment registerEnchantment(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(Frankfurtlinmod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        Frankfurtlinmod.LOGGER.info("Registering Mod enchantments for " + Frankfurtlinmod.MOD_ID);
    }
}
