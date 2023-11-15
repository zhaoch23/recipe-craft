package com.sakurarealm.recipecraft.material;

import org.bukkit.inventory.ItemStack;

import java.util.Optional;

public interface MaterialParser {

    Optional<Material> parse(ItemStack itemStack);

}
