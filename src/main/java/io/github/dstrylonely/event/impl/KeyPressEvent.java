package io.github.dstrylonely.event.impl;

import io.github.dstrylonely.event.CancellableEvent;

public class KeyPressEvent extends CancellableEvent {

    private final int keyPress;

    public KeyPressEvent(int keyPress) {
        this.keyPress = keyPress;
    }

    public int getKeyPress() {
        return keyPress;
    }
}
