package com.example.config;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

/**
 * FAULTY "Singleton": public constructor, getInstance() returns a NEW instance each time,
 * not thread-safe, reload allowed anytime, mutable global state, reflection+serialization-friendly.
 */
public class AppSettings implements Serializable {
    private final Properties props = new Properties();

    private AppSettings() {
        if(Holder.Instance!=null) throw new Error("Manjari kehti h galat baat!");
     } // should not be public for true singleton

    public static AppSettings getInstance() {
        return Holder.Instance; 
    }
    private static class Holder{
        static final AppSettings Instance = new AppSettings();
    }

    protected Object readResolve(){
        return getInstance();
    }
    public void loadFromFile(Path file) {
        try (InputStream in = Files.newInputStream(file)) {
            props.load(in);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public String get(String key) {
        return props.getProperty(key);
    }
}
