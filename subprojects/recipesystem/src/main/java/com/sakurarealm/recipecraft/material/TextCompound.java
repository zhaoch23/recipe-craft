package com.sakurarealm.recipecraft.material;

import org.bukkit.Color;

public interface TextCompound {

    String getText();

    void setText(String text);

    Color getColor();

    void setColor(Color color);

    boolean isBold();

    void setBold(boolean bold);

    boolean isItalic();

    void setItalic(boolean italic);

    boolean isUnderlined();

    void setUnderlined(boolean underlined);

    boolean isStrikethrough();

    void setStrikethrough(boolean strikethrough);

    String getPrefix();

    void setPrefix(String prefix);

    String getSuffix();

    void setSuffix(String suffix);

    void set(TextCompound textCompound);

    TextCompound clone();

}
