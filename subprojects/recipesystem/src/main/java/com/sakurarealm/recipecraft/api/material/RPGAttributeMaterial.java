package com.sakurarealm.recipecraft.api.material;

import java.util.Map;

public interface RPGAttributeMaterial extends RPGMaterial {

    Map<String, Double> getAttributes();

    boolean isAttributeActive();

}
