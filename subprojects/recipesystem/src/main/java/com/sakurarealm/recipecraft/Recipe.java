package com.sakurarealm.recipecraft;

import com.sakurarealm.recipecraft.material.Material;

import java.util.List;
import java.util.Optional;

public interface Recipe {

    String getRecipeName();

    List<Material> getRecipeMaterials();

    Optional<Material> build(List<Material> Materials);

}
