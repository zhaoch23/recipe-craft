package com.sakurarealm.recipecraft.material;

public class MaterialTags {

    private final String name;
    private final int priority;
    private TextCompound displayName;

    public MaterialTags(String name, TextCompound displayName, int priority) {
        this.name = name;
        this.displayName = displayName;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public TextCompound getDisplayName() {
        return displayName;
    }

    public void setDisplayName(TextCompound displayName) {
        this.displayName = displayName;
    }

    public int getPriority() {
        return priority;
    }


}
