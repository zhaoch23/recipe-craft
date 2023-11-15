package com.sakurarealm.recipecraft.material;


import com.sakurarealm.recipecraft.material.enums.EnumSlot;

import java.util.Optional;

public interface Equipment extends AttributeMaterial {

    @Override
    default boolean isAttributeActive() {
        return true;
    }

    EnumSlot[] getSlots();

    int getDurability();

    int repairDurability();

    Optional<AttributeMaterial[]> getMaterials();

    Optional<AttributeMaterial[]> getRepairMaterials();

    Optional<AttributeMaterial[]> getDecompositionMaterials();

    Optional<AttributeMaterial[]> getBrokenMaterials();

}
