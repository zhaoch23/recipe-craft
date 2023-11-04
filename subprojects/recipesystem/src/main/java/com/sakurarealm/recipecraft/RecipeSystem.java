package com.sakurarealm.recipecraft;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;

public class RecipeSystem {

    protected RecipeParser recipeParser;

    protected HashMap<Integer, Recipe> recipes;


    public RecipeSystem(RecipeParser recipeParser) {
        this.recipeParser = recipeParser;
    }

    public void load(YamlConfiguration yamlConfiguration) {
        List<Recipe> recipes = recipeParser.parse(yamlConfiguration);
        for (Recipe recipe : recipes) {
            this.recipes.put(recipeParser.getRecipeId(recipe), recipe);
        }
    }

    public Recipe getRecipe(int recipeId) {
        return recipes.get(recipeId);
    }

    public Recipe getRecipe(List<ItemStack> itemStacks) {
        return recipes.get(recipeParser.getRecipeId(itemStacks));
    }

    public ItemStack build(List<ItemStack> itemStacks) {
        Recipe recipe = recipes.get(recipeParser.getRecipeId(itemStacks));

        if (recipe != null) {
            return recipe.build(itemStacks);
        }
        return null;
    }

    public YamlConfiguration dump() {
        return recipeParser.dump((List<Recipe>) recipes.values());
    }
}
