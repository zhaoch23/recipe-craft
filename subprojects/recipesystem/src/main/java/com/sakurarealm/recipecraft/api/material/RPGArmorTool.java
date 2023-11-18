package com.sakurarealm.recipecraft.api.material;


import com.sakurarealm.recipecraft.api.material.enums.EnumSlot;

import java.util.Optional;

public interface RPGArmorTool extends RPGAttributeMaterial {

    @Override
    default boolean isAttributeActive() {
        return true;
    }

    EnumSlot[] getSlots();

    int getDurability();

    int repairDurability();

    Optional<RPGAttributeMaterial[]> getMaterials();

    Optional<RPGAttributeMaterial[]> getRepairMaterials();

    Optional<RPGAttributeMaterial[]> getDecompositionMaterials();

    Optional<RPGAttributeMaterial[]> getBrokenMaterials();

}
