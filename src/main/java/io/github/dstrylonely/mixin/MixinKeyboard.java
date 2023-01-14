package io.github.dstrylonely.mixin;


import io.github.dstrylonely.SpeedrunTimerMod;
import io.github.dstrylonely.event.impl.KeyPressEvent;
import net.minecraft.client.Keyboard;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public final class MixinKeyboard {
    @Inject(method = "onKey", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/NarratorManager;isActive()Z"), cancellable = true)
    private void injectOnKey(final long window, final int key, final int scancode, final int action, final int modifiers, final CallbackInfo callbackInfo) {
        if (action == GLFW.GLFW_PRESS) {
            final KeyPressEvent event = new KeyPressEvent(key);
            SpeedrunTimerMod.getInstance().getEventPubSub().publish(event);
            if (event.isCancelled()) callbackInfo.cancel();
        }
    }
}
