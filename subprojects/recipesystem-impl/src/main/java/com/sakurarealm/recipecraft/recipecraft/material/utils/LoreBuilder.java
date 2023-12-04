package com.sakurarealm.recipecraft.recipecraft.material.utils;

import java.util.ArrayList;
import java.util.List;

public class LoreBuilder {
    private List<LoreField> loreFields = new ArrayList<>();

    public LoreBuilder() {
    }

    public void append(LoreField loreField) {
        loreFields.add(loreField);
    }

    public List<LoreField> getLoreFields() {
        return loreFields;
    }

    public void insertAfter(String name, LoreField loreField) {
        for (int i = 0; i < loreFields.size(); i++) {
            if (loreFields.get(i).getName().equals(name)) {
                loreFields.add(i + 1, loreField);
                return;
            }
        }
    }

    public void insertBefore(String name, LoreField loreField) {
        for (int i = 0; i < loreFields.size(); i++) {
            if (loreFields.get(i).getName().equals(name)) {
                loreFields.add(i, loreField);
                return;
            }
        }
    }

    public void remove(String name) {
        for (int i = 0; i < loreFields.size(); i++) {
            if (loreFields.get(i).getName().equals(name)) {
                loreFields.remove(i);
                return;
            }
        }
    }

    List<String> toLore() {
        List<String> lore = new ArrayList<>();
        List<String> hiddenLore = new ArrayList<>();
        for (LoreField loreField : loreFields) {
            if (loreField.isHidden()) {
                hiddenLore.addAll(loreField.getLore());
                hiddenLore.add("");
            } else {
                lore.addAll(loreField.getLore());
                lore.add("");
            }
        }
        lore.add("§rhidden");
        lore.addAll(hiddenLore);
        // Add field names
        StringBuilder stringBuilder = new StringBuilder();
        for (LoreField loreField : loreFields) {
            stringBuilder.append(loreField.getName()).append(";");
        }
        lore.add(stringBuilder.toString());
        return lore;
    }

}
