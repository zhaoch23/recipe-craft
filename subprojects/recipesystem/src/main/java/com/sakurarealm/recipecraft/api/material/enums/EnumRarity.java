package com.sakurarealm.recipecraft.api.material.enums;

import com.sakurarealm.recipecraft.api.material.TextCompound;
import org.bukkit.ChatColor;

public enum EnumRarity { // TODO: 2023/11/14 zhaoch23 we will rename these later
    One(1),
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7);

    private final int rarity;

    EnumRarity(int rarity) {
        this.rarity = rarity;
    }

    public static EnumRarity of(int rarity) {
        switch (rarity) {
            case 2:
                return Two;
            case 3:
                return Three;
            case 4:
                return Four;
            case 5:
                return Five;
            case 6:
                return Six;
            case 7:
                return Seven;
            default:
                return One;
        }
    }

    public TextCompound getDisplayName() {
        return new TextCompound(String.valueOf(this), ChatColor.WHITE, false, false, false, false);
    }
}
