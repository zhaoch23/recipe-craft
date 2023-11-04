package com.sakurarealm.recipecraft;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public interface RecipeParser {

    List<Recipe> parse(YamlConfiguration yamlConfiguration);

    YamlConfiguration dump(List<Recipe> recipes);

    int getRecipeId(Recipe recipe);

    int getRecipeId(List<ItemStack> itemStacks);

}
