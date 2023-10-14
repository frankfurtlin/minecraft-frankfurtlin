package com.frankfurtlin.frankfurtlinmod.mixin.mob;

import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {

    /**
     *
     * @param entity entity
     * @param cir cir
     * @param iterable iterable
     * @param var2 var2
     * @param itemStack itemStack
     * 猪灵看到白金盔甲无仇恨
     */
    @Inject(method = "wearsGoldArmor(Lnet/minecraft/entity/LivingEntity;)Z", at = @At(value = "INVOKE_ASSIGN",
            target = "Lnet/minecraft/item/ItemStack;getItem()Lnet/minecraft/item/Item;"),
            cancellable = true, locals = LocalCapture.CAPTURE_FAILHARD)
    private static void wearWhiteGoldArmorInject(LivingEntity entity, CallbackInfoReturnable<Boolean> cir,
                                             Iterable<ItemStack> iterable, Iterator<ItemStack> var2, ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (item instanceof ArmorItem && ((ArmorItem)item).getMaterial() == ModItems.WHITE_GOLD_ARMOR_MATERIAL){
            cir.setReturnValue(true);
        }

    }
}
