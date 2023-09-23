package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;


/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/9/22 22:51
 */
@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    /**
     * 不死图腾可以在背包里面生效
     * @param livingEntity 实体
     * @param hand 手
     * @return 背包里面的不死图腾物品
     */
    @Redirect(method = "tryUseTotem", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/entity/LivingEntity;getStackInHand(Lnet/minecraft/util/Hand;)Lnet/minecraft/item/ItemStack;"))
    private ItemStack getStackInHandInTryUseTotem(LivingEntity livingEntity, Hand hand) {
        if(ModConfig.INSTANCE.useTotemOFUndyingInInventory){
            if (livingEntity instanceof PlayerEntity) {
                for (int i = 0; i < ((PlayerEntity) livingEntity).getInventory().size(); i++) {
                    ItemStack itemStack = ((PlayerEntity) livingEntity).getInventory().getStack(i);
                    if(itemStack.isOf(Items.TOTEM_OF_UNDYING)){
                        return itemStack;
                    }
                }
            }
            return livingEntity.getMainHandStack();
        }
        else{
            if (hand == Hand.MAIN_HAND) {
                return livingEntity.getEquippedStack(EquipmentSlot.MAINHAND);
            }
            if (hand == Hand.OFF_HAND) {
                return livingEntity.getEquippedStack(EquipmentSlot.OFFHAND);
            }
            throw new IllegalArgumentException("Invalid hand " + hand);
        }
    }

}
