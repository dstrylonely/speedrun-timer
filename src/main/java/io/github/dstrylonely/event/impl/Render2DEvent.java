package io.github.dstrylonely.event.impl;

import io.github.dstrylonely.event.IEvent;
import net.minecraft.client.util.math.MatrixStack;

public class Render2DEvent implements IEvent {
    private MatrixStack matrixStack;

    public void setMatrixStack(final MatrixStack matrixStack) {
        this.matrixStack = matrixStack;
    }

    public MatrixStack getMatrixStack() {
        return matrixStack;
    }
}
