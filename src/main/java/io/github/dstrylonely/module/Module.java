package io.github.dstrylonely.module;

import io.github.dstrylonely.SpeedrunTimerMod;
import org.lwjgl.glfw.GLFW;

public class Module {
    private final String name;
    private final String description;
    private boolean enabled;
    private int keybind = GLFW.GLFW_KEY_UNKNOWN;

    protected Module(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public final boolean isEnabled() {
        return enabled;
    }

    public final void setEnabled(final boolean state) {
        this.enabled = state;
        if (this.enabled)
            onEnable();
        else onDisable();
    }

    public void onDisable() {
        this.enabled = false;
        SpeedrunTimerMod.getInstance().getEventPubSub().unsubscribe(this);
    }

    public void onEnable() {
        this.enabled = true;
        SpeedrunTimerMod.getInstance().getEventPubSub().subscribe(this);
    }

    public final void setKeybind(final int keybind) {
        this.keybind = keybind;
    }

    public final int getKeybind() {
        return keybind;
    }

    public final String getDescription() {
        return description;
    }

    public final String getName() {
        return name;
    }
}
