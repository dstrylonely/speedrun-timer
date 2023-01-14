package io.github.dstrylonely.module;

import io.github.dstrylonely.SpeedrunTimerMod;
import io.github.dstrylonely.event.impl.KeyPressEvent;
import io.github.nevalackin.radbus.Listen;

public final class BindListener {
    @Listen
    public void listenBind(final KeyPressEvent event) {
        for (final Module module : SpeedrunTimerMod.getInstance().getModuleRepository().moduleCache.values()) {
            if (event.getKeyPress() == module.getKeybind()) {
                module.setEnabled(!module.isEnabled());
            }
        }
    }
}
