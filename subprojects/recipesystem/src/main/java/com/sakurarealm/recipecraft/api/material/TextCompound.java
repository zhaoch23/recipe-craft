package com.sakurarealm.recipecraft.api.material;

import org.bukkit.ChatColor;

public class TextCompound {

    String text;

    ChatColor color;

    boolean bold;

    boolean italic;

    boolean underlined;

    boolean strikethrough;

    String prefix;

    String suffix;

    boolean newLineChar = false;

    public TextCompound(String text, ChatColor color, boolean bold, boolean italic, boolean underlined, boolean strikethrough, String prefix, String suffix) {
        this.text = text;
        this.color = color;
        this.bold = bold;
        this.italic = italic;
        this.underlined = underlined;
        this.strikethrough = strikethrough;
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public TextCompound(String text) {
        this.text = text;
        this.color = ChatColor.WHITE;
        this.bold = false;
        this.italic = false;
        this.underlined = false;
        this.strikethrough = false;
        this.prefix = "";
        this.suffix = "";
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
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
                strikethrough,
                prefix,
                suffix
        );
    }

    public String toString() {
        return prefix +
                color +
                getTextFormatCode() +
                text +
                ChatColor.RESET +
                suffix;
    }

    public int getLength() {
        return text.length() + prefix.length() + suffix.length();
    }

    public String getTextFormatCode() {
        return "" + (bold ? ChatColor.BOLD : "") +
                (italic ? ChatColor.ITALIC : "") +
                (underlined ? ChatColor.UNDERLINE : "") +
                (strikethrough ? ChatColor.STRIKETHROUGH : "");
    }


}
