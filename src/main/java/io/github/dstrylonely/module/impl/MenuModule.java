package io.github.dstrylonely.module.impl;

import io.github.dstrylonely.event.impl.Render2DEvent;
import io.github.dstrylonely.module.Module;
import io.github.nevalackin.radbus.Listen;
import net.minecraft.client.MinecraftClient;

public final class MenuModule extends Module {
    public MenuModule() {
        super("Menu", "Displays a menu.");
    }

    @Listen
    public void listenRender(final Render2DEvent event) {

    }
}
