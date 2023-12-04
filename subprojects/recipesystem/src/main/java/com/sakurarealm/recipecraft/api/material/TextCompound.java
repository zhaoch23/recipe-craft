package com.sakurarealm.recipecraft.api.material;

import org.bukkit.ChatColor;

public class TextCompound {

    String text;

    ChatColor color;

    boolean bold;

    boolean italic;

    boolean underlined;

    boolean strikethrough;

    boolean newLineChar = false;

    public TextCompound(String text, ChatColor color, boolean bold, boolean italic, boolean underlined, boolean strikethrough) {
        this.text = text;
        this.color = color;
        this.bold = bold;
        this.italic = italic;
        this.underlined = underlined;
        this.strikethrough = strikethrough;
    }

    public TextCompound(String text) {
        this.text = text;
        this.color = ChatColor.WHITE;
        this.bold = false;
        this.italic = false;
        this.underlined = false;
        this.strikethrough = false;
    }

    private TextCompound() {
        this.newLineChar = true;
    }

    public static TextCompound NewLineChar() {
        return new TextCompound();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(ChatColor color) {
        this.color = color;
    }

    public boolean isBold() {
        return bold;
    }

    public void setBold(boolean bold) {
        this.bold = bold;
    }

    public boolean isItalic() {
        return italic;
    }

    public void setItalic(boolean italic) {
        this.italic = italic;
    }

    public boolean isUnderlined() {
        return underlined;
    }

    public void setUnderlined(boolean underlined) {
        this.underlined = underlined;
    }

    public boolean isStrikethrough() {
        return strikethrough;
    }

    public void setStrikethrough(boolean strikethrough) {
        this.strikethrough = strikethrough;
    }

    public boolean isNewLineChar() {
        return this.newLineChar;
    }

    public TextCompound clone() {
        return new TextCompound(
                text,
                color,
                bold,
                italic,
                underlined,
                strikethrough
        );
    }

    public String toString() {
        return color +
                getTextFormatCode() +
                text;
    }

    public int getLength() {
        return text.length();
    }

    public String getTextFormatCode() {
        return "" + color + (bold ? ChatColor.BOLD : "") +
                (italic ? ChatColor.ITALIC : "") +
                (underlined ? ChatColor.UNDERLINE : "") +
                (strikethrough ? ChatColor.STRIKETHROUGH : "");
    }

    public static TextCompound fromLore(String lore) {
        lore = lore.trim();
        if (lore.charAt(0) != ChatColor.COLOR_CHAR) {
            return new TextCompound(lore);
        }
        lore = lore.replace(ChatColor.RESET.toString(), "");
        int textStart;
        for (textStart = lore.length()-1; textStart >= 0; textStart--) {
            if (lore.charAt(textStart) == ChatColor.COLOR_CHAR) {
                break;
            }
        }
        textStart++;

        ChatColor color = ChatColor.getByChar(lore.charAt(1));
        return new TextCompound(
                lore.substring(textStart),
                color,
                lore.contains(ChatColor.BOLD.toString()),
                lore.contains(ChatColor.ITALIC.toString()),
                lore.contains(ChatColor.UNDERLINE.toString()),
                lore.contains(ChatColor.STRIKETHROUGH.toString())
        );
    }

    public static TextCompound concat(TextCompound... textCompounds) {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextCompound textCompound : textCompounds) {
            stringBuilder.append(textCompound.getText());
        }
        return new TextCompound(
                stringBuilder.toString(),
                textCompounds[0].color,
                textCompounds[0].bold,
                textCompounds[0].italic,
                textCompounds[0].underlined,
                textCompounds[0].strikethrough
        );
    }

}
