package com.sakurarealm.recipecraft.material.enums;

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
}
