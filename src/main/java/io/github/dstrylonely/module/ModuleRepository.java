package io.github.dstrylonely.module;


import java.util.HashMap;
import java.util.Map;

public final class ModuleRepository {
    public final Map<String, Module> moduleCache;

    public ModuleRepository() {
        this.moduleCache = new HashMap<>();
    }


    public Module getModuleByName(final String name) {
        return this.moduleCache.get(name);
    }

    public <T extends Module> T getModuleByClass(final Class<T> clazz) {
        return clazz.cast(moduleCache.get(clazz));
    }

    public void addModules(final Module... baseModules) {
        for (final Module module : baseModules) {
            this.moduleCache.put(module.getName(), module);
        }
    }
}
