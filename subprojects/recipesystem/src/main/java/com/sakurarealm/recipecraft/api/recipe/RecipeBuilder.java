package com.sakurarealm.recipecraft.api.recipe;

import com.sakurarealm.recipecraft.api.material.RPGMaterial;

public interface RecipeBuilder<T extends Recipe> {

    RecipeBuilder<T> setMaterial(String key, RPGMaterial material);

    T build();
}
