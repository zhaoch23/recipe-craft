package com.sakurarealm.recipecraft.recipecraft.material;

import com.sakurarealm.recipecraft.api.material.*;
import com.sakurarealm.recipecraft.api.material.enums.EnumRarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.*;

public class SimpleAttributeMaterial extends SimpleMaterial implements RPGAttributeMaterial {

    protected final Map<String, Double> attributes = new HashMap<>();

    protected final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public SimpleAttributeMaterial(String name, TextCompound displayName, EnumRarity rarity, Material bukkitMaterial) {
        super(name, displayName, rarity, bukkitMaterial);
    }

    private SimpleAttributeMaterial() {
        super("", null, null, Material.AIR);
    }

    public static RPGMaterialParser SimpleAttributeMaterialParser() {
        return new SimpleAttributeMaterial();
    }

    public static SimpleAttributeMaterial TestAttributeMaterial() {
        SimpleAttributeMaterial material = new SimpleAttributeMaterial(
                "test",
                new TextCompound(
                        "test description",
                        ChatColor.WHITE,
                        true, false, false, false,
                        "", ""
                ),
                EnumRarity.One,
                org.bukkit.Material.COAL
        );
        material.addTags(RPGMaterialTag.ANY);
        material.addDescription(
                new TextCompound(
                        "test description",
                        ChatColor.WHITE,
                        true, false, false, false,
                        "", ""
                )
        );
        material.addShiftDescription(
                new TextCompound(
                        "shift description",
                        ChatColor.WHITE,
                        false, false, false, false,
                        "", ""
                )
        );
        material.addCtrlDescription(
                new TextCompound(
                        "ctrl description",
                        ChatColor.WHITE,
                        false, false, true, false,
                        "", ""
                )
        );
        material.addHiddenDescription(
                new TextCompound(
                        "hidden description",
                        ChatColor.WHITE,
                        false, false, false, false,
                        "", ""
                )
        );

        material.addAttribute("TestAttributeOne", 1.0);
        material.addAttribute("TestAttributeTwo", 2.0);

        return material;
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
    public Optional<ItemStack> toItemStack(RPGMaterial material) {
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
        for (RPGMaterialTag materialTag : getTags()) {
            tags.append(materialTag.getDisplayName().toString()).append(" ");
        }
        lore.add(tags.toString());

        // Attributes
        lore.add("");
        for (Map.Entry<String, Double> entry : attributes.entrySet()) {
            lore.add(getAttributeLore(entry.getKey(), entry.getValue()));
        }

        // Descriptions
        descriptionsToLore(null, getDescription(), lore);
        descriptionsToLore("shift", getShiftDescription(), lore);
        descriptionsToLore("ctrl", getCtrlDescription(), lore);
        descriptionsToLore("hidden", getHiddenDescription(), lore);

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return Optional.of(itemStack);
    }

    protected String getAttributeLore(String name, double value) {
        return ChatColor.GREEN + name + " " + ChatColor.GRAY + decimalFormat.format(value);
    }

}
