package com.frankfurtlin.frankfurtlinmod.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBindings {
    private static final String CATEGORY = "key.categories.frankfurtlin";
    // 是否开启gamma
    public static boolean gamma = false;

    private KeyBindings() {
    }

    public static void registerBindings() {
        registerGammaToggleKey();
    }

    private static void registerGammaToggleKey() {
        KeyBinding gammaToggleKey = new KeyBinding("key.frankfurtlin.gamma_toggle",
            InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_G, CATEGORY);
        KeyBindingHelper.registerKeyBinding(gammaToggleKey);

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (gammaToggleKey.wasPressed()) {
                gamma = !gamma;
            }
        });
    }

}