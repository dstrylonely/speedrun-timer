package io.github.dstrylonely;

import io.github.dstrylonely.event.IEvent;
import io.github.dstrylonely.module.ModuleRepository;
import io.github.nevalackin.radbus.PubSub;
import net.fabricmc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;

public final class SpeedrunTimerMod implements ModInitializer {
    private static SpeedrunTimerMod instance;
    private ModuleRepository moduleRepository;
    private PubSub<IEvent> eventPubSub;

    public SpeedrunTimerMod() {
        this.eventPubSub = PubSub.newInstance(LogManager.getLogger()::error);
        this.moduleRepository = new ModuleRepository();
    }

    @Override
    public void onInitialize() {

    }

    public ModuleRepository getModuleRepository() {
        return moduleRepository;
    }

    public PubSub<IEvent> getEventPubSub() {
        return eventPubSub;
    }

    public static SpeedrunTimerMod getInstance() {
        if (instance == null) instance = new SpeedrunTimerMod();
        return instance;
    }
}
