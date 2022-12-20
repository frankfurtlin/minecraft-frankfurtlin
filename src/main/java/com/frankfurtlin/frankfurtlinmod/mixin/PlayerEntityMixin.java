package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.items.RegisterItems;
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
     * 原能头盔 潮涌核心 抗火
     * 原能胸甲 抗性提升 抗火
     * 原能护腿 抗性提升 抗火
     * 原能战靴 跳跃提升 速度提升 抗火
     * @param ci CallbackInfo
     */
    @Inject(method = "updateTurtleHelmet()V", at = @At("TAIL"))
    public void updateSuperArmorInject(CallbackInfo ci) {

        ItemStack itemStackHelmet = this.getEquippedStack(EquipmentSlot.HEAD);
        if(itemStackHelmet.isOf(RegisterItems.SUPER_HELMET)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.CONDUIT_POWER, 200, 0, false, false, true));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false, true));
        }

        ItemStack itemStackChestplate = this.getEquippedStack(EquipmentSlot.CHEST);
        if(itemStackChestplate.isOf(RegisterItems.SUPER_CHESTPLATE)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0, false, false, true));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false, true));
        }

        ItemStack itemStackLeggings = this.getEquippedStack(EquipmentSlot.LEGS);
        if(itemStackLeggings.isOf(RegisterItems.SUPER_LEGGINGS)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 200, 0, false, false, true));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false, true));
        }

        ItemStack itemStackBoots = this.getEquippedStack(EquipmentSlot.FEET);
        if(itemStackBoots.isOf(RegisterItems.SUPER_BOOTS)){
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 200, 0, false, false, true));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 200, 0, false, false, true));
            this.addStatusEffect(new StatusEffectInstance(StatusEffects.SPEED, 200, 0, false, false, true));
        }


    }
}
