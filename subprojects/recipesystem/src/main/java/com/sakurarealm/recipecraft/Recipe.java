package com.sakurarealm.recipecraft;

import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface Recipe {

    String getRecipeName();

    List<ItemStack> getRecipeItems();

    ItemStack build(List<ItemStack> itemStacks);

}
