package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import com.frankfurtlin.frankfurtlinmod.blocks.ModBlocks;
import com.frankfurtlin.frankfurtlinmod.items.ModItems;
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
                new ItemStack(ModItems.WHITE_GOLD_INGOT, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BUDDING_COAL, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BUDDING_IRON, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BUDDING_COPPER, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BUDDING_GOLD, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BUDDING_LAPIS, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BUDDING_EMERALD, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BUDDING_DIAMOND, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BUDDING_REDSTONE, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BUDDING_QUARTZ, 1),
                1, 20, 0.02f));
            tradeOfferList.add(new TradeOffer(
                new ItemStack(Items.EMERALD, 1),
                new ItemStack(ModBlocks.BUDDING_NETHERITE, 1),
                1, 20, 0.02f));
        }

    }

}
