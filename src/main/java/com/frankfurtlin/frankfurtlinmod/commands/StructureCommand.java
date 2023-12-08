package com.frankfurtlin.frankfurtlinmod.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.StructureStart;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.gen.structure.Structure;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/12/7 18:30
 * /structure 获取当前位置的结构
 */
public class StructureCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        String commandString = "structure";

        LiteralCommandNode<ServerCommandSource> source = dispatcher.register(CommandManager.literal(commandString)
            .executes(cs -> listStructuresAtSpot(cs.getSource().getServer().getOverworld(),
                Objects.requireNonNull(cs.getSource().getPlayer()).getBlockPos(), cs.getSource()))
        );

        dispatcher.register(CommandManager.literal(commandString).redirect(source));
    }

    private static int listStructuresAtSpot(ServerWorld world, BlockPos centerPos,
                                             ServerCommandSource source) {

        List<StructureStart> structureStarts =
            world.getStructureAccessor().getStructureStarts(new ChunkPos(centerPos), s -> true);
        List<Structure> structures = structureStarts.stream()
                .filter(ss -> ss.getBoundingBox().contains(centerPos))
                .map(StructureStart::getStructure).toList();

        if (structures.isEmpty()) {
            source.sendFeedback(() -> Text.literal("There's no structures at your location."), false);
            return Command.SINGLE_SUCCESS;
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Structures at your location:");

        for (Structure structure : structures) {
            Optional<RegistryKey<Structure>> key = world.getRegistryManager().get(RegistryKeys.STRUCTURE).getKey(structure);
            key.ifPresent(structureRegistryKey -> stringBuilder.append("§r\n - §6").append(structureRegistryKey.getValue()));
        }

        source.sendFeedback(() -> Text.literal(stringBuilder.toString()), false);
        return Command.SINGLE_SUCCESS;
    }
}