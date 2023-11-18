package com.sakurarealm.recipecraft.material;

import org.bukkit.ChatColor;

public enum MaterialTag {
    ANY("any", TagTextCompound("any", 0), 0);

    private static final MaterialTag[] VALUES = values();

    private final String name;
    private final int priority;
    private TextCompound displayName;
    private static final ChatColor[] PriorityColor = {
            ChatColor.WHITE,
            ChatColor.GREEN,
            ChatColor.YELLOW,
            ChatColor.GOLD,
            ChatColor.RED,
            ChatColor.DARK_RED,
            ChatColor.DARK_PURPLE
    };

    public String getName() {
        return name;
    }

    public TextCompound getDisplayName() {
        return displayName;
    }

    public int getPriority() {
        return priority;
    }

    private MaterialTag(String name, TextCompound displayName, int priority) {
        this.name = name;
        this.displayName = displayName;
        this.priority = priority;
    }

    private static TextCompound TagTextCompound(String name, int priority) {
        return new TextCompound(
                '[' + name + ']',
                PriorityColor[priority],
                true, false, false, false,
                "", ""
        );
    }

}
