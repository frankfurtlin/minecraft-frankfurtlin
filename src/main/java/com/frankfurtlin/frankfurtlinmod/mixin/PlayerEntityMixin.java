package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.items.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> entityType, World world) {
        super(entityType, world);
    }

    @Shadow public abstract ItemStack getEquippedStack(EquipmentSlot slot);

    /**
     * 每随机刻检测玩家装备盔甲并给予相应的效果
     * 原能头盔 潮涌核心 抗火 荧光
     * 原能胸甲 抗性提升 抗火 荧光
     * 原能护腿 抗性提升 抗火 荧光
     * 原能战靴 跳跃提升 速度提升 抗火 荧光
     * @param ci CallbackInfo
     */
    @Inject(method = "updateTurtleHelmet()V", at = @At("TAIL"))
    public void updateSuperArmorInject(CallbackInfo ci) {

        ItemStack itemStackHelmet = this.getEquippedStack(EquipmentSlot.HEAD);
        if(itemStackHelmet.isOf(ModItems.SUPER_HELMET)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 200, 0, false, false, false));
        }

        ItemStack itemStackChestplate = this.getEquippedStack(EquipmentSlot.CHEST);
        ItemStack itemStackLeggings = this.getEquippedStack(EquipmentSlot.LEGS);
        if(itemStackChestplate.isOf(ModItems.SUPER_CHESTPLATE) || itemStackLeggings.isOf(ModItems.SUPER_LEGGINGS)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0, false, false, false));
        }

        ItemStack itemStackBoots = this.getEquippedStack(EquipmentSlot.FEET);
        if(itemStackBoots.isOf(ModItems.SUPER_BOOTS)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 0, false, false, false));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0, false, false, false));
        }

        if(itemStackHelmet.isOf(ModItems.SUPER_HELMET) || itemStackChestplate.isOf(ModItems.SUPER_CHESTPLATE) ||
                itemStackLeggings.isOf(ModItems.SUPER_LEGGINGS) || itemStackBoots.isOf(ModItems.SUPER_BOOTS)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false, false));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 200, 0, false, false, false));
        }


    }
}
