package com.sakurarealm.recipecraft.recipecraft.material;

import com.sakurarealm.recipecraft.api.material.RPGMaterial;
import com.sakurarealm.recipecraft.api.material.RPGMaterialParser;
import com.sakurarealm.recipecraft.api.material.RPGMaterialTag;
import com.sakurarealm.recipecraft.api.material.TextCompound;
import com.sakurarealm.recipecraft.api.material.enums.EnumRarity;
import com.sakurarealm.recipecraft.api.material.lore.LoreStringBuilder;
import com.sakurarealm.recipecraft.recipecraft.material.utils.LoreBuilder;
import com.sakurarealm.recipecraft.recipecraft.material.utils.LoreField;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class SimpleMaterial implements RPGMaterial, RPGMaterialParser {

    String name;

    TextCompound displayName;

    EnumRarity rarity;

    List<RPGMaterialTag> tags = new ArrayList<>();

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

    public SimpleMaterial(String name, EnumRarity rarity, org.bukkit.Material bukkitMaterial, String... descriptions) {
        this.name = name;
        this.displayName = new TextCompound(name, ChatColor.GREEN, false, false, false, false);
        this.rarity = rarity;
        this.bukkitMaterial = bukkitMaterial;
        if (descriptions.length > 0) {
            addDescription(new TextCompound(descriptions[0], ChatColor.GRAY, false, false, false, false));
        }
        if (descriptions.length > 1) {
            addShiftDescription(new TextCompound(descriptions[1], ChatColor.GRAY, false, false, false, false));
        }
        if (descriptions.length > 2) {
            addCtrlDescription(new TextCompound(descriptions[2], ChatColor.GRAY, false, false, false, false));
        }
        if (descriptions.length > 3) {
            addHiddenDescription(new TextCompound(descriptions[3], ChatColor.GRAY, false, false, false, false));
        }
    }

    private SimpleMaterial() {
    }

    public static Optional<RPGMaterial> of(ItemStack itemStack) {
        return new SimpleMaterial().parse(itemStack);
    }

    public static RPGMaterialParser SimpleMaterialParser() {
        return new SimpleMaterial();
    }

    public static RPGMaterial TestMaterial() {
        SimpleMaterial material = new SimpleMaterial(
                "test",
                new TextCompound(
                        "test description",
                        ChatColor.WHITE,
                        true, false, false, false
                ),
                EnumRarity.One,
                org.bukkit.Material.COAL
        );
        material.addTags(RPGMaterialTag.ANY);
        material.addDescription(
                new TextCompound(
                        "test description",
                        ChatColor.WHITE,
                        true, false, false, false
                )
        );
        material.addShiftDescription(
                new TextCompound(
                        "shift description",
                        ChatColor.WHITE,
                        false, false, false, false
                )
        );
        material.addCtrlDescription(
                new TextCompound(
                        "ctrl description",
                        ChatColor.WHITE,
                        false, false, true, false
                )
        );
        material.addHiddenDescription(
                new TextCompound(
                        "hidden description",
                        ChatColor.WHITE,
                        false, false, false, false
                )
        );
        return material;
    }

    void addTags(RPGMaterialTag... tags) {
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
        return rarity;
    }

    void setRarity(EnumRarity rarity) {
        this.rarity = rarity;
    }

    @Override
    public RPGMaterialTag[] getTags() {
        return tags.toArray(new RPGMaterialTag[0]);
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

    void setBukkitMaterial(org.bukkit.Material bukkitMaterial) {
        this.bukkitMaterial = bukkitMaterial;
    }

    @Override
    public Optional<ItemStack> getBukkitItemStack() {
        return toItemStack(this);
    }

    @Override
    public Optional<String> crc32() {
        return Optional.empty();
    }

    @Override
    public Optional<RPGMaterial> parse(ItemStack itemStack) {
        return Optional.empty();
    }

    @Override
    public Optional<RPGMaterial> parse(String string) {
        return Optional.empty();
    }

    @Override
    public Optional<String> toSerializedString(RPGMaterial material) {
        return Optional.empty();
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

        // Descriptions
        descriptionsToLore(null, getDescription(), lore);
        descriptionsToLore("shift", getShiftDescription(), lore);
        descriptionsToLore("ctrl", getCtrlDescription(), lore);
        descriptionsToLore("hidden", getHiddenDescription(), lore);

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return Optional.of(itemStack);
    }

    protected LoreBuilder getLore() {
        LoreBuilder loreBuilder = new LoreBuilder();
        StringBuilder tags = new StringBuilder();
        for (RPGMaterialTag materialTag : getTags()) {
            tags.append(materialTag.getDisplayName().toString()).append(" ");
        }
        loreBuilder.append(new LoreField("Tags", Collections.singletonList(tags.toString())));

        if (description != null) {
            loreBuilder.append(descriptionsToLore(null, getDescription().get()));
        }
        if (shiftDescription != null) {
            loreBuilder.append(descriptionsToLore("shift", getShiftDescription().get()));
        }
        if (ctrlDescription != null) {
            loreBuilder.append(descriptionsToLore("ctrl", getCtrlDescription().get()));
        }
        if (hiddenDescription != null) {
            loreBuilder.append(descriptionsToLore("hidden", getHiddenDescription().get()));
        }
        
        return loreBuilder;
    }

    protected String getTitle() {
        return getRarity().getDisplayName() + "◇" + getDisplayName().toString();
    }

    protected LoreField descriptionsToLore(String flag, TextCompound[] descriptions) {
        List<String> lore = new ArrayList<>();
        if (flag != null) {
            LoreStringBuilder loreStringBuilder = new LoreStringBuilder(30, LoreStringBuilder.Alignment.CENTER);
            loreStringBuilder.appendText(new TextCompound(
                    flag,
                    ChatColor.DARK_AQUA,
                    true, false, false, false
            ));
            lore.addAll(loreStringBuilder.toLore());
        }

        LoreStringBuilder loreStringBuilder = new LoreStringBuilder(30);
        for (TextCompound textCompound : descriptions) {
            loreStringBuilder.appendText(textCompound);
        }
        lore.addAll(loreStringBuilder.toLore());
        return new LoreField(flag, lore);
    }

}
