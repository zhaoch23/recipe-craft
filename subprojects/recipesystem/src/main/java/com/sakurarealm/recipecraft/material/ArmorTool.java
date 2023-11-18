package com.sakurarealm.recipecraft.material;


import com.sakurarealm.recipecraft.material.enums.EnumSlot;

import java.util.Optional;

public interface ArmorTool extends RPGAttributes {

    @Override
    default boolean isAttributeActive() {
        return true;
    }

    EnumSlot[] getSlots();

    int getDurability();

    int repairDurability();

    Optional<RPGAttributes[]> getMaterials();

    Optional<RPGAttributes[]> getRepairMaterials();

    Optional<RPGAttributes[]> getDecompositionMaterials();

    Optional<RPGAttributes[]> getBrokenMaterials();

}
