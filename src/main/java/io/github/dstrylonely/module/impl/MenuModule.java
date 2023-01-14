package io.github.dstrylonely.module.impl;

import imgui.ImGui;
import imgui.gl3.ImGuiImplGl3;
import imgui.glfw.ImGuiImplGlfw;
import io.github.dstrylonely.SpeedrunTimerMod;
import io.github.dstrylonely.event.impl.Render2DEvent;
import io.github.dstrylonely.module.Module;
import io.github.nevalackin.radbus.Listen;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;

public final class MenuModule extends Module {
    private final ImGuiImplGlfw imguiGlfw;
    private final ImGuiImplGl3 imguiGl3;
    private long windowPointer;

    public MenuModule() {
        super("Menu", "Displays a menu.");
        this.imguiGlfw = new ImGuiImplGlfw();
        this.imguiGl3 = new ImGuiImplGl3();
        this.setKeybind(GLFW.GLFW_KEY_RIGHT_SHIFT);
    }

    @Listen
    public void listenRender(final Render2DEvent event) {
        imguiGlfw.newFrame();
        ImGui.newFrame();
        for (final Module module : SpeedrunTimerMod.getInstance().getModuleRepository().moduleCache.values()) {
            if (ImGui.checkbox(module.getName(), module.isEnabled())) {
                module.setEnabled(!module.isEnabled());
            }
        }
        ImGui.render();
        imguiGl3.renderDrawData(ImGui.getDrawData());
    }

    @Override
    public void onEnable() {
        if (this.windowPointer == 0) {
            this.windowPointer = MinecraftClient.getInstance().getWindow().getHandle();
            ImGui.createContext();
            imguiGlfw.init(windowPointer, true);
            imguiGl3.init();
        }
        super.onEnable();
    }

    @Override
    public void onDisable() {
//        imguiGl3.dispose();
//        imguiGlfw.dispose();
//        ImGui.destroyContext();
        super.onDisable();
    }
}
