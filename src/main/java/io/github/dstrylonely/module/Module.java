package io.github.dstrylonely.module;

public class Module {
    private final String name;
    private final String description;

    public Module(final String name, final String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
