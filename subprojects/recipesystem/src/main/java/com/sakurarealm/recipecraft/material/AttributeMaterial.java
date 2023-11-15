package com.sakurarealm.recipecraft.material;

import java.util.Map;

public interface AttributeMaterial extends Material {

    Map<String, Double> getAttributes();

    boolean isAttributeActive();

}
