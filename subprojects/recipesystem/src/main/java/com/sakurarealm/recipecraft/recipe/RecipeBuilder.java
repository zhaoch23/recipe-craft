package com.sakurarealm.recipecraft.recipe;

import com.sakurarealm.recipecraft.material.Material;

public interface RecipeBuilder<T extends Recipe> {

    RecipeBuilder<T> setMaterial(String key, Material material);

    T build();
}
