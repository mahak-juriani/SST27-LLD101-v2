package com.example.render;

import java.util.Objects;

public final class TextStyle {
    private final String font;
    private final int size;
    private final boolean bold;

    TextStyle(String font, int size, boolean bold) {
        this.font = Objects.requireNonNull(font, "font");
        this.size = size;
        this.bold = bold;
    }

    public String getFont() { return font; }
    public int getSize() { return size; }
    public boolean isBold() { return bold; }

    static String keyOf(String font, int size, boolean bold) {
        return font + "|" + size + "|" + (bold ? "B" : "N");
    }
}
