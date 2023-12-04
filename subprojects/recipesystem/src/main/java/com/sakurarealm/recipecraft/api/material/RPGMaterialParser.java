package com.sakurarealm.recipecraft.api.material;

import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public interface RPGMaterialParser {

    /**
     * Extract the information of Sakurarealm material from the bukkit item stack.
     *
     * @param itemStack The item stack to parse.
     * @return The Sakurarealm material parsed from the item stack.
     */
    Optional<RPGMaterial> parse(ItemStack itemStack);

    void parse(ItemStack itemStack, RPGMaterial material);

    Optional<RPGMaterial> parse(String string);

    void parse(String string, RPGMaterial material);

    Optional<ItemStack> toItemStack(RPGMaterial material);

    Optional<String> toSerializedString(RPGMaterial material);

}
