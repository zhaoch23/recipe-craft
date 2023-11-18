package com.sakurarealm.recipecraft.api.material;

import com.sakurarealm.recipecraft.api.material.enums.EnumRarity;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public interface RPGMaterial {

    /**
     * @return The name of the material.
     */
    String getName();

    /**
     * @return The display name of the material.
     */
    TextCompound getDisplayName();

    /**
     * @return The rarity of the material.
     */
    EnumRarity getRarity();

    /**
     * @return The tags of the material.
     * @see RPGMaterialTag
     */
    RPGMaterialTag[] getTags();

    /**
     * @return The description of the material.
     */
    Optional<TextCompound[]> getDescription();

    /**
     * @return The description of the material when shift is pressed.
     */
    Optional<TextCompound[]> getShiftDescription();

    /**
     * @return The description of the material when ctrl is pressed.
     */
    Optional<TextCompound[]> getCtrlDescription();

    /**
     * @return The hidden description of the material.
     */
    Optional<TextCompound[]> getHiddenDescription();

    /**
     * @return The Minecraft material of the material (if any).
     */
    Optional<org.bukkit.Material> getBukkitMaterial();

    /**
     * @return The Minecraft item stack of the material (if any).
     */
    Optional<ItemStack> getBukkitItemStack();

    /**
     * @return The verify code of the material if any.
     */
    Optional<String> crc32();

}
