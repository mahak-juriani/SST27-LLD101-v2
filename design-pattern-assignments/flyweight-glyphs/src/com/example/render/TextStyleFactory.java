package com.example.render;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class TextStyleFactory {
    private static final Map<String, TextStyle> CACHE = new HashMap<>();

    private TextStyleFactory() {}

    public static TextStyle get(String font, int size, boolean bold) {
        Objects.requireNonNull(font, "font");
        final String key = TextStyle.keyOf(font, size, bold);
        return CACHE.computeIfAbsent(key, k -> new TextStyle(font, size, bold));
    }

    public static int cacheSize() { return CACHE.size(); }
}
