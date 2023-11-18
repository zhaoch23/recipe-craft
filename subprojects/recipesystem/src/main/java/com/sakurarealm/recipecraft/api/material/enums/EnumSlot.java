package com.sakurarealm.recipecraft.api.material.enums;

import com.sakurarealm.recipecraft.api.material.TextCompound;
import org.bukkit.event.inventory.InventoryType;

import java.util.Optional;

public enum EnumSlot {
    HEAD,
    CHEST,
    LEGS,
    FEET,
    MAIN_HAND,
    OFF_HAND,
    ANY;

    public Optional<InventoryType.SlotType> getBukkitSlotType() {
        throw new UnsupportedOperationException();
    }

    public TextCompound getDisplayName() {
        return new TextCompound("SlotPlaceholder");
    }
}
