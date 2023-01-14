package io.github.dstrylonely.mixin;

import io.github.dstrylonely.SpeedrunTimerMod;
import io.github.dstrylonely.event.impl.Render2DEvent;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@SuppressWarnings("unused")
@Mixin(InGameHud.class)
public final class MixinInGameHud {
    @Inject(method = "render", at = {@At(value = "INVOKE", ordinal = 0, target = "Lnet/minecraft/client/MinecraftClient;getLastFrameDuration()F")})
    public void render(MatrixStack matrixStack, float tickDelta, CallbackInfo ci) {
        final Render2DEvent event = new Render2DEvent();
        event.setMatrixStack(matrixStack);
        SpeedrunTimerMod.getInstance().getEventPubSub().publish(event);
    }
}
