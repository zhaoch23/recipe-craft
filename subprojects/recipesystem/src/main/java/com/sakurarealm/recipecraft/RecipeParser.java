package com.sakurarealm.recipecraft;

import com.sakurarealm.recipecraft.material.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public interface RecipeParser {

    List<Recipe> parse(YamlConfiguration yamlConfiguration);

    YamlConfiguration dump(List<Recipe> recipes);

    int getRecipeId(Recipe recipe);

    int getRecipeId(List<Material> materials);

}
