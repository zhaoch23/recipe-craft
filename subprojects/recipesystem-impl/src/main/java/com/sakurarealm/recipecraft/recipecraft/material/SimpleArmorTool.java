package com.sakurarealm.recipecraft.recipecraft.material;

import com.sakurarealm.recipecraft.api.material.*;
import com.sakurarealm.recipecraft.api.material.enums.EnumRarity;
import com.sakurarealm.recipecraft.api.material.enums.EnumSlot;
import com.sakurarealm.recipecraft.utils.LoreBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class SimpleArmorTool extends SimpleAttributeMaterial implements RPGArmorTool {

    protected EnumSlot[] slots;

    protected int durability, repairDurability;

    protected RPGMaterial[] materials;

    public SimpleArmorTool(String name,
                           TextCompound displayName,
                           EnumRarity rarity,
                           Material bukkitMaterial,
                           EnumSlot[] slots,
                           int durability,
                           int repairDurability) {
        super(name, displayName, rarity, bukkitMaterial);
        this.slots = slots;
        this.durability = durability;
        this.repairDurability = repairDurability;
    }

    public static SimpleArmorTool TestSimpleArmorTool() {
        SimpleArmorTool simpleArmorTool = new SimpleArmorTool(
                "simple_armor_tool",
                new TextCompound("Test"),
                EnumRarity.One,
                Material.DIAMOND_HELMET,
                new EnumSlot[]{EnumSlot.HEAD},
                100,
                100);

        simpleArmorTool.addTags(RPGMaterialTag.ANY);
        simpleArmorTool.addTags(RPGMaterialTag.ANY);

        simpleArmorTool.addAttribute("TestAttributeOne", 1.0);
        simpleArmorTool.addAttribute("TestAttributeTwe", 2.0);
        simpleArmorTool.addDescription(new TextCompound("This is a very very very very very very very very very very very long description."));
        simpleArmorTool.addHiddenDescription(new TextCompound("This is a hidden description."));

        simpleArmorTool.setMaterials(new RPGAttributeMaterial[]{
                SimpleAttributeMaterial.TestAttributeMaterial(),
                SimpleAttributeMaterial.TestAttributeMaterial()});

        return simpleArmorTool;
    }

    @Override
    public boolean isAttributeActive() {
        return true;
    }

    @Override
    public EnumSlot[] getSlots() {
        return slots;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public int repairDurability() {
        return repairDurability;
    }

    @Override
    public Optional<RPGAttributeMaterial[]> getMaterials() {
        return Optional.of((RPGAttributeMaterial[]) materials);
    }

    public void setMaterials(RPGAttributeMaterial[] materials) {
        this.materials = materials;
    }

    @Override
    public Optional<RPGAttributeMaterial[]> getRepairMaterials() {
        return Optional.empty();
    }

    @Override
    public Optional<RPGAttributeMaterial[]> getDecompositionMaterials() {
        return Optional.empty();
    }

    @Override
    public Optional<RPGAttributeMaterial[]> getBrokenMaterials() {
        return Optional.empty();
    }

    @Override
    public Optional<ItemStack> toItemStack(RPGMaterial material) { // FIXME: Maybe I should make a new helper class for this?
        if (bukkitMaterial == null || bukkitMaterial == org.bukkit.Material.AIR) {
            return Optional.empty();
        }

        ItemStack itemStack = new ItemStack(bukkitMaterial);

        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(displayName.toString());

        // Name
        itemMeta.setDisplayName(getDisplayName().toString());

        // Rarity
        LoreBuilder loreBuilder = new LoreBuilder(30, LoreBuilder.Alignment.CENTER);
        loreBuilder.appendText(getRarity().getDisplayName())
                .newLine();
        for (EnumSlot slot : getSlots()) {
            loreBuilder.appendText(slot.getDisplayName());

        }
        List<String> lore = new ArrayList<>(loreBuilder.toLore());

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

        // Materials
        lore.add("");

        Optional<RPGAttributeMaterial[]> materials = getMaterials();
        if (materials.isPresent()) {
            StringBuilder serializedString = new StringBuilder();
            for (RPGMaterial material1 : materials.get()) {
                Optional<String> ss = toSerializedString(material1);
                ss.ifPresent(serializedString::append);
                serializedString.append(":");
            }
            lore.add(serializedString.toString());
        }

        itemMeta.setLore(lore);
        itemStack.setItemMeta(itemMeta);

        return Optional.of(itemStack);
    }

    @Override
    public Optional<String> toSerializedString(RPGMaterial material) {
        return Optional.of(material.getName());
    }
}
