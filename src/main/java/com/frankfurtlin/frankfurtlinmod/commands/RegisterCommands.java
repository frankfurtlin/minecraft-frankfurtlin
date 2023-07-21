package com.frankfurtlin.frankfurtlinmod.commands;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

/**
 * @author Frankfurtlin
 * @version 1.0
 * @date 2023/4/17 9:28
 */
public class RegisterCommands {
    public static void register(){
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) ->
                WhereCommand.register(dispatcher));
    }
}
