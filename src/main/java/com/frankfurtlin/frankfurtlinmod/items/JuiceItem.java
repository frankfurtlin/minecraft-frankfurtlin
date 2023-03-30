package com.frankfurtlin.frankfurtlinmod.items;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 * 饮品类，赋予每种饮料 tooltip
 */

public class JuiceItem extends Item {
    private final String juiceName;

    public JuiceItem(String name, Settings settings) {
        super(settings);
        this.juiceName = name;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        String key = "item.frankfurtlin." + juiceName + ".tooltip";
        tooltip.add(Text.translatable(key).formatted(Formatting.RED));
    }
}
