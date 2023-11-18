package com.sakurarealm.recipecraft.utils;

import com.sakurarealm.recipecraft.material.TextCompound;
import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class LoreBuilder {

    private final List<String> lore = new ArrayList<>();
    private final int lineSize;
    private final Alignment alignment;
    private StringBuilder currentLine;

    public LoreBuilder(int lineSize, Alignment alignment) {
        this.lineSize = lineSize;
        this.currentLine = new StringBuilder();
        this.alignment = alignment;
    }

    public LoreBuilder(int lineSize) {
        this(lineSize, Alignment.LEFT);
    }

    public LoreBuilder appendText(TextCompound textCompound) {
        if (textCompound.isNewLineChar()) {
            return newLine();
        }
        appendText("", textCompound.getPrefix());
        appendText(textCompound.getTextFormatCode(), textCompound.getText());
        appendText("", textCompound.getSuffix());
        return this;
    }

    public LoreBuilder newLine() {
        addLine();
        return this;
    }

    public LoreBuilder emptyLines(int lines) {
        for (int i = 0; i < lines + 1; i++) {
            newLine();
        }
        return this;
    }

    private void appendText(String formatCode, String text) {
        if (lineSize <= 0) { // No line size limit
            currentLine.append(formatCode).append(text);
            return;
        }

        currentLine.append(formatCode);
        for (char ch : text.toCharArray()) {
            if (currentLine.length() == lineSize) {
                addLine();
                currentLine.append(formatCode);
            }
            currentLine.append(ch);
        }
        currentLine.append(ChatColor.RESET);
    }

    private void addLine() {
        String line = currentLine.toString();
        switch (alignment) {
            case CENTER:
                int padding = (lineSize - line.length()) / 2;
                line = String.format("%" + (line.length() + padding) + "s", line);
                break;
            case RIGHT:
                line = String.format("%" + lineSize + "s", line);
                break;
            case LEFT:
            default:
                break;
        }
        lore.add(line);
        currentLine = new StringBuilder();
    }

    public List<String> toLore() {
        if (currentLine.length() > 0) {
            addLine();
        }
        List<String> copy = new ArrayList<>(lore);
        lore.remove(lore.size() - 1);
        return copy;
    }

    public enum Alignment {
        LEFT, CENTER, RIGHT
    }

}
