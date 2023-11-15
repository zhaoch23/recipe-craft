package com.sakurarealm.recipecraft.material.enums;

import com.sakurarealm.recipecraft.material.TextCompound;

public enum EnumRarity {
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

    public static EnumRarity getRarity(int rarity) {
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
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
