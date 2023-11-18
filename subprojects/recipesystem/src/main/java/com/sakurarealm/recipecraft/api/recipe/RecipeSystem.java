package com.sakurarealm.recipecraft.api.recipe;

import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public interface RecipeSystem<T extends Recipe> {

    void parse(YamlConfiguration yamlConfiguration);

    YamlConfiguration dump(List<T> recipes);

    void addRecipe(Recipe recipe);

    RecipeBuilder<T> newRecipeBuilder();


}
