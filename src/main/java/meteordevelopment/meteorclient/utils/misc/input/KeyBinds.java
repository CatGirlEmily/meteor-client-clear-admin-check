/*
 * This file is part of the Meteor Client distribution (https://github.com/MeteorDevelopment/meteor-client).
 * Copyright (c) Meteor Development.
 */

package meteordevelopment.meteorclient.utils.misc.input;

import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyBinds {

    
    public static final KeyBinding OPEN_GUI = new KeyBinding(
        "key.meteor-client.open-gui",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_RIGHT_SHIFT,
        null
    );

    public static final KeyBinding OPEN_COMMANDS = new KeyBinding(
        "key.meteor-client.open-commands",
        InputUtil.Type.KEYSYM,
        GLFW.GLFW_KEY_APOSTROPHE,
        null
    );

    private KeyBinds() {}

    public static KeyBinding[] apply(KeyBinding[] binds) {
        return binds;
    }
}
