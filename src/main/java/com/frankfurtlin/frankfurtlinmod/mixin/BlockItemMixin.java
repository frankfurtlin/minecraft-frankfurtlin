package com.frankfurtlin.frankfurtlinmod.mixin;

import com.frankfurtlin.frankfurtlinmod.ModConfig;
import net.minecraft.block.Block;
import net.minecraft.block.SpawnerBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/11/2 16:27
 * 方块实体 mixin
 */
@Mixin(BlockItem.class)
public class BlockItemMixin extends Item {

    public BlockItemMixin(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        Item item = stack.getItem();
        if(ModConfig.INSTANCE.canSpawnerUseOnEntity && !user.getWorld().isClient && Block.getBlockFromItem(item) instanceof SpawnerBlock){

            if(stack.getNbt() != null){
                NbtCompound entityNbt = stack.getNbt().getCompound("BlockEntityTag").getCompound("SpawnData").getCompound("entity");
                entityNbt.putString("id", Registries.ENTITY_TYPE.getId(entity.getType()).toString());
                stack.getNbt().getCompound("BlockEntityTag").getCompound("SpawnData").put("entity", entityNbt);
            }

            return ActionResult.success(true);
        }
        return ActionResult.PASS;
    }
}
