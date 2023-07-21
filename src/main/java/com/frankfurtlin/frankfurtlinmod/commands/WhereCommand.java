package com.frankfurtlin.frankfurtlinmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;


/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/4/17 8:30
 * /where target 获取目标位置
 */
public class WhereCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher){

        dispatcher.register(CommandManager.literal("where")
                .then(CommandManager.argument("target", EntityArgumentType.player())
                .executes(context -> WhereCommand.execute(context.getSource(),
                        EntityArgumentType.getPlayer(context, "target"))))
        );
    }


    public static int execute(ServerCommandSource source, ServerPlayerEntity target) {

        BlockPos playerPos = target.getBlockPos();
        String pos = "(" + playerPos.getX() + ", " + playerPos.getY() + ", " + playerPos.getZ() + ") in " +
                target.world.getRegistryKey().getValue().toString();

        String text = target.getEntityName() + "'s position is: " + pos;
        source.sendFeedback(Text.literal(text), true);

        return Command.SINGLE_SUCCESS;
    }


}
