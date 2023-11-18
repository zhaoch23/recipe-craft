package com.sakurarealm.recipecraft.recipecraft.material;

import com.sakurarealm.recipecraft.material.Material;
import com.sakurarealm.recipecraft.material.MaterialParser;
import com.sakurarealm.recipecraft.material.MaterialTag;
import com.sakurarealm.recipecraft.material.TextCompound;
import com.sakurarealm.recipecraft.material.enums.EnumRarity;
import com.sakurarealm.recipecraft.utils.LoreBuilder;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class SimpleMaterial implements Material, MaterialParser {

    String name;

    TextCompound displayName;

    EnumRarity rarity;

    List<MaterialTag> tags = new ArrayList<>();

    List<TextCompound> description = new ArrayList<>();

    List<TextCompound> shiftDescription = new ArrayList<>();

    List<TextCompound> ctrlDescription = new ArrayList<>();

    List<TextCompound> hiddenDescription = new ArrayList<>();

    org.bukkit.Material bukkitMaterial;

    public SimpleMaterial(String name, TextCompound displayName, EnumRarity rarity, org.bukkit.Material bukkitMaterial) {
        this.name = name;
        this.displayName = displayName;
        this.rarity = rarity;
        this.bukkitMaterial = bukkitMaterial;
    }

    private SimpleMaterial() {
    }

    void addTags(MaterialTag... tags) {
        this.tags.addAll(Arrays.asList(tags));
    }

    void clearTags() {
        this.tags.clear();
    }

    void addDescription(TextCompound... description) {
        this.description.addAll(Arrays.asList(description));
    }

    void clearDescription() {
        this.description.clear();
    }

    void addShiftDescription(TextCompound... shiftDescription) {
        this.shiftDescription.addAll(Arrays.asList(shiftDescription));
    }

    void clearShiftDescription() {
        this.shiftDescription.clear();
    }

    void addCtrlDescription(TextCompound... ctrlDescription) {
        this.ctrlDescription.addAll(Arrays.asList(ctrlDescription));
    }

    void clearCtrlDescription() {
        this.ctrlDescription.clear();
    }

    void addHiddenDescription(TextCompound... hiddenDescription) {
        this.hiddenDescription.addAll(Arrays.asList(hiddenDescription));
    }

    void clearHiddenDescription() {
        this.hiddenDescription.clear();
    }

    void setBukkitMaterial(org.bukkit.Material bukkitMaterial) {
        this.bukkitMaterial = bukkitMaterial;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public TextCompound getDisplayName() {
        return displayName;
    }

    void setDisplayName(TextCompound displayName) {
        this.displayName = displayName.clone();
    }

    @Override
    public EnumRarity getRarity() {
        return null;
    }

    void setRarity(EnumRarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public MaterialTag[] getTags() {
        return tags.toArray(new MaterialTag[0]);
    }

    @Override
    public Optional<TextCompound[]> getDescription() {
        if (description.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(description.toArray(new TextCompound[0]));
    }

    @Override
    public Optional<TextCompound[]> getShiftDescription() {
        if (shiftDescription.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(shiftDescription.toArray(new TextCompound[0]));
    }

    @Override
    public Optional<TextCompound[]> getCtrlDescription() {
       if (ctrlDescription.isEmpty()) {
           return Optional.empty();
       }
       return Optional.of(ctrlDescription.toArray(new TextCompound[0]));
    }

    @Override
    public Optional<TextCompound[]> getHiddenDescription() {
        if (hiddenDescription.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(hiddenDescription.toArray(new TextCompound[0]));
    }

    @Override
    public Optional<org.bukkit.Material> getBukkitMaterial() {
        if (bukkitMaterial == null || bukkitMaterial == org.bukkit.Material.AIR) {
            return Optional.empty();
        }
        return Optional.of(bukkitMaterial);
    }

    @Override
    public Optional<ItemStack> getBukkitItemStack() {
        return dump(this);
    }

    @Override
    public Optional<String> crc32() {
        return Optional.empty();
    }

    protected void dumpDescriptionsToLore(String flag, Optional<TextCompound[]> descriptions, List<String> lore) {
        if (descriptions.isPresent()) {
            lore.add("");
            if (flag != null)
                lore.add(flag);

            LoreBuilder loreBuilder = new LoreBuilder(30);
            for (TextCompound textCompound : descriptions.get()) {
                loreBuilder.appendText(textCompound);
            }
            lore.addAll(loreBuilder.toLore());
        }
    }

    @Override
    public Optional<Material> parse(ItemStack itemStack) {
        return Optional.empty();
    }

    @Override
    public Optional<ItemStack> dump(Material material) {
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

        // Descriptions
        dumpDescriptionsToLore(null, getDescription(), lore);
        dumpDescriptionsToLore("shift", getShiftDescription(), lore);
        dumpDescriptionsToLore("ctrl", getCtrlDescription(), lore);
        dumpDescriptionsToLore("hidden", getHiddenDescription(), lore);

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return Optional.of(itemStack);
    }

    public static Optional<Material> of(ItemStack itemStack) {
        return new SimpleMaterial().parse(itemStack);
    }

    public static MaterialParser SimpleMaterialParser() {
        return new SimpleMaterial();
    }

    public static Material TestMaterial() {
        SimpleMaterial material = new SimpleMaterial(
                "test",
                new TextCompound(
                        "test description",
                        ChatColor.WHITE,
                        true, false, false, false,
                        "", ""
                ),
                EnumRarity.One,
                org.bukkit.Material.STONE
        );
        material.addTags(MaterialTag.ANY);
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
        return material;
    }

}
