package com.example.report;
import java.io.*; import java.nio.file.*; import java.util.Map;

public class JsonWriter {
    public Path write(Map<String, Object> data, Path outDir, String baseName) {
        try {
            Files.createDirectories(outDir);
            Path json = outDir.resolve(baseName + ".json");
            String name = String.valueOf(data.get("name"));
            try (BufferedWriter w = Files.newBufferedWriter(json)) {
                w.write("{\"ok\":true,\"name\":\"" + escape(name) + "\"}");
            }
            return json;
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static String escape(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
