package com.sakurarealm.recipecraft.api.recipe;

import com.sakurarealm.recipecraft.api.material.RPGMaterial;

import java.util.Optional;

public interface Recipe extends Comparable<Recipe> {

    /**
     * Get the recipe identifier (if any).
     *
     * @return the recipe identifier
     */
    Optional<String> getRecipeId();

    /**
     * Craft the recipe.
     *
     * @return the crafted material
     */
    Optional<RPGMaterial> build();

}