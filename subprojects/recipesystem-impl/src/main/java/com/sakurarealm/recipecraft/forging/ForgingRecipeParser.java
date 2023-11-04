package com.sakurarealm.recipecraft.forging;

import com.sakurarealm.recipecraft.Recipe;
import com.sakurarealm.recipecraft.RecipeParser;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class ForgingRecipeParser implements RecipeParser {


    @Override
    public List<Recipe> parse(YamlConfiguration yamlConfiguration) {
        return null;
    }

    @Override
    public YamlConfiguration dump(List<Recipe> recipes) {
        return null;
    }

    @Override
    public int getRecipeId(Recipe recipe) {
        return 0;
    }

    @Override
    public int getRecipeId(List<ItemStack> itemStacks) {
        return 0;
    }
}
