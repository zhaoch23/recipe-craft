package com.sakurarealm.recipecraft.recipecraft.material.utils;

import java.util.List;

public class LoreField {
    private String name;

    private List<String> lore;

    private boolean isHidden;

    public LoreField(String name, List<String> lore) {
        this(name, lore, false);
    }

    public LoreField(String name, List<String> lore, boolean isHidden) {
        this.name = name;
        this.lore = lore;
        this.isHidden = isHidden;
    }

    public String getName() {
        return name;
    }

    public List<String> getLore() {
        return lore;
    }

    public boolean isHidden() {
        return isHidden;
    }

}
