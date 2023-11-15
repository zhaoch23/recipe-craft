package com.sakurarealm.recipecraft;

import com.sakurarealm.recipecraft.material.Material;
import com.sakurarealm.recipecraft.material.MaterialParser;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class RecipeSystem {

    protected RecipeParser recipeParser;

    protected MaterialParser materialParser;

    protected HashMap<Integer, Recipe> recipes;


    public RecipeSystem(RecipeParser recipeParser, MaterialParser materialParser) {
        this.recipeParser = recipeParser;
        this.materialParser = materialParser;

        this.recipes = new HashMap<>();
    }

    public void load(YamlConfiguration yamlConfiguration) {
        List<Recipe> recipes = recipeParser.parse(yamlConfiguration);
        for (Recipe recipe : recipes) {
            this.recipes.put(recipeParser.getRecipeId(recipe), recipe);
        }
    }

    public YamlConfiguration dump() {
        return recipeParser.dump((List<Recipe>) recipes.values());
    }

    public Recipe getRecipe(int recipeId) {
        return recipes.get(recipeId);
    }

    Optional<Material> getCraftingResult(List<Material> materials) {
        int recipeId = recipeParser.getRecipeId(materials);
        Recipe recipe = recipes.get(recipeId);
        if (recipe == null) {
            return Optional.empty();
        }
        return recipe.build(materials);
    }

    Optional<ItemStack> getCraftingResultFromItemStacks(List<ItemStack> itemStacks) {
        List<Material> materials = new ArrayList<>();
        itemStacks.forEach(itemStack -> {
            Optional<Material> material = materialParser.parse(itemStack);
            material.ifPresent(materials::add);
        });

        Optional<Material> material = getCraftingResult(materials);
        if (material.isPresent()) {
            return material.get().getBukkitItemStack();
        }
        return Optional.empty();
    }

    boolean isCraftingRecipe(List<Material> materials) {
        int recipeId = recipeParser.getRecipeId(materials);
        return recipes.containsKey(recipeId);
    }

    boolean isCraftingRecipeFromItemStacks(List<ItemStack> itemStacks) {
        List<Material> materials = new ArrayList<>();
        itemStacks.forEach(itemStack -> {
            Optional<Material> material = materialParser.parse(itemStack);
            material.ifPresent(materials::add);
        });
        return isCraftingRecipe(materials);
    }

}
