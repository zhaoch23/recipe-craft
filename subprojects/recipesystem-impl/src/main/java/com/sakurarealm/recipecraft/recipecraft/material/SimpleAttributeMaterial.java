package com.sakurarealm.recipecraft.recipecraft.material;

import com.sakurarealm.recipecraft.material.MaterialTag;
import com.sakurarealm.recipecraft.material.RPGAttributes;
import com.sakurarealm.recipecraft.material.TextCompound;
import com.sakurarealm.recipecraft.material.enums.EnumRarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class SimpleAttributeMaterial extends SimpleMaterial implements RPGAttributes {

    private final Map<String, Double> attributes = new HashMap<>();

    public SimpleAttributeMaterial(String name, TextCompound displayName, EnumRarity rarity, Material bukkitMaterial) {
        super(name, displayName, rarity, bukkitMaterial);
    }

    public void addAttribute(String name, double value) {
        if (attributes.containsKey(name)) {
            attributes.put(name, attributes.get(name) + value);
        } else {
            attributes.put(name, value);
        }
    }

    public void removeAttribute(String name) {
        attributes.remove(name);
    }

    public void clearAttributes() {
        attributes.clear();
    }

    @Override
    public Map<String, Double> getAttributes() {
        return attributes;
    }

    @Override
    public boolean isAttributeActive() {
        return false;
    }

    @Override
    public Optional<ItemStack> dump(com.sakurarealm.recipecraft.material.Material material) {
        if (bukkitMaterial == null || bukkitMaterial == org.bukkit.Material.AIR) {
            return Optional.empty();
        }

        ItemStack itemStack = new ItemStack(bukkitMaterial);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName.toString());
        List<String> lore = new ArrayList<>();

        // Name
        itemMeta.setDisplayName(getDisplayName().toString());

        // Rarity
        lore.add(getRarity().getDisplayName().toString());

        // Tags
        StringBuilder tags = new StringBuilder();
        for (MaterialTag materialTag : getTags()) {
            tags.append(materialTag.getDisplayName().toString()).append(" ");
        }
        lore.add(tags.toString());

        // Attributes
        lore.add("");
        for (Map.Entry<String, Double> entry : attributes.entrySet()) {
            lore.add(getAttributeLore(entry.getKey(), entry.getValue()));
        }

        // Descriptions
        dumpDescriptionsToLore(null, getDescription(), lore);
        dumpDescriptionsToLore("shift", getShiftDescription(), lore);
        dumpDescriptionsToLore("ctrl", getCtrlDescription(), lore);
        dumpDescriptionsToLore("hidden", getHiddenDescription(), lore);

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return Optional.of(itemStack);
    }

    protected String getAttributeLore(String name, double value) {
        return ChatColor.GREEN + name + " " + ChatColor.GRAY + value;
    }


}
