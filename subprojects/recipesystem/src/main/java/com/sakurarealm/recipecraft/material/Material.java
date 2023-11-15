package com.sakurarealm.recipecraft.material;

import com.sakurarealm.recipecraft.material.enums.EnumRarity;
import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public interface Material {

    String getName();

    TextCompound getDisplayName();

    EnumRarity getRarity();

    MaterialTags[] getTags();

    Optional<TextCompound[]> getDescription();

    Optional<TextCompound[]> getShiftDescription();

    Optional<TextCompound[]> getCtrlDescription();

    Optional<TextCompound[]> getHiddenDescription();

    Optional<org.bukkit.Material> getBukkitMaterial();

    Optional<ItemStack> getBukkitItemStack();

    Optional<String> crc32();


}
