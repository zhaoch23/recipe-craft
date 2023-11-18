package com.sakurarealm.recipecraft.api.material;

import org.bukkit.ChatColor;

public class RPGMaterialTag {
    public final static RPGMaterialTag ANY = new RPGMaterialTag("any", 0);
    private static final ChatColor[] PriorityColor = {
            ChatColor.WHITE,
            ChatColor.GREEN,
            ChatColor.YELLOW,
            ChatColor.GOLD,
            ChatColor.RED,
            ChatColor.DARK_RED,
            ChatColor.DARK_PURPLE
    };
    private final String name;
    private final int priority;
    private final TextCompound displayName;


    private RPGMaterialTag(String name, int priority) {
        this.name = name;
        this.displayName = TagTextCompound(name, priority);
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public TextCompound getDisplayName() {
        return displayName;
    }

    public int getPriority() {
        return priority;
    }

    private TextCompound TagTextCompound(String name, int priority) {
        return new TextCompound(
                "[" + name + "]",
                PriorityColor[priority],
                true, false, false, false,
                "", ""
        );
    }

}
