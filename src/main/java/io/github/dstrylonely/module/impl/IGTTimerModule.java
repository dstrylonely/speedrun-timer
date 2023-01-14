package io.github.dstrylonely.module.impl;

import io.github.dstrylonely.SpeedrunTimerMod;
import io.github.dstrylonely.event.impl.Render2DEvent;
import io.github.dstrylonely.module.Module;
import io.github.nevalackin.radbus.Listen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.Window;

public final class IGTTimerModule extends Module {
    public IGTTimerModule() {
        super("IGT Timer", "Displays a IGT Timer.");
    }

    @Listen
    public final void listenRender(final Render2DEvent event) {
        final Window window = MinecraftClient.getInstance().getWindow();
        final TextRenderer textRenderer = MinecraftClient.getInstance().textRenderer;
        final String text = "IGT: ";
        textRenderer.drawWithShadow(event.getMatrixStack(), text, window.getScaledWidth() - textRenderer.getWidth(text), 1, -1);
    }
}
