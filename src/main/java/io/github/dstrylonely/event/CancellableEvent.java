package io.github.dstrylonely.event;

public class CancellableEvent implements IEvent {
    private boolean cancelled;

    public final boolean isCancelled() {
        return cancelled;
    }

    public final void cancel() {
        this.cancelled = true;
    }

    public final void setCancelled(final boolean cancelled) {
        this.cancelled = cancelled;
    }
}
