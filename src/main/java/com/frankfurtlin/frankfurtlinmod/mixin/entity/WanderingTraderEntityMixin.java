package com.frankfurtlin.frankfurtlinmod.mixin.entity;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.WanderingTraderEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOfferList;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/10/6 22:32
 * 流浪商人 mixin
 */
@Mixin(WanderingTraderEntity.class)
public abstract class WanderingTraderEntityMixin extends MerchantEntity {

    public WanderingTraderEntityMixin(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    /**
     * 添加流浪商人交易选项
     */
    @Inject(method = "fillRecipes", at = @At("TAIL"))
    private void addTradeOfferList(CallbackInfo ci){
        if(ModConfig.INSTANCE.replaceWanderTrade){
            TradeOfferList tradeOfferList = getOffers();

            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.COAL_CANE, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.IRON_CANE, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.COPPER_CANE, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.GOLD_CANE, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.LAPIS_CANE, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.EMERALD_CANE, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.DIAMOND_CANE, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.REDSTONE_CANE, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.QUARTZ_CANE, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.NETHERITE_CANE, 1),
                1, 20, 0.02f));
        }

    }

}
