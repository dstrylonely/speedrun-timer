package io.github.dstrylonely;

import io.github.dstrylonely.event.IEvent;
import io.github.dstrylonely.module.BindListener;
import io.github.dstrylonely.module.ModuleRepository;
import io.github.nevalackin.radbus.PubSub;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SpeedrunTimerMod implements ModInitializer {
    private static SpeedrunTimerMod instance;
    private final ModuleRepository moduleRepository;
    private final Logger logger;
    private final PubSub<IEvent> eventPubSub;

    public SpeedrunTimerMod() {
        this.logger = LoggerFactory.getLogger("speedrun-timer");
        this.eventPubSub = PubSub.newInstance(logger::error);
        this.moduleRepository = new ModuleRepository();
        this.eventPubSub.subscribe(new BindListener());
    }

    @Override
    public void onInitialize() {

    }

    public ModuleRepository getModuleRepository() {
        return moduleRepository;
    }

    public final Logger getLogger() {
        return logger;
    }

    public PubSub<IEvent> getEventPubSub() {
        return eventPubSub;
    }

    public static SpeedrunTimerMod getInstance() {
        if (instance == null) instance = new SpeedrunTimerMod();
        return instance;
    }
}
