package com.example.config;

import java.lang.reflect.Constructor;
import java.nio.file.Path;

public class App {
    public static void main(String[] args) throws Exception {
        // String path = args.length > 0 ? args[0] : "app.properties";
        // AppSettings.getInstance().loadFromFile(Path.of(path)); // not thread-safe, re-loadable
        // System.out.println("app.name=" + AppSettings.getInstance().get("app.name"));
        // System.out.println("instance=" + System.identityHashCode(AppSettings.getInstance()));
        
        Class<?> clazz = Class.forName("com.example.config.AppSettings");
        Constructor<?> cons = clazz.getDeclaredConstructor();
        cons.setAccessible(true);
        Object obj = cons.newInstance();
        AppSettings instatnce2 = (AppSettings) obj ;
        System.out.println("i1="+AppSettings.getInstance());
        System.out.println("i2="+ instatnce2);
    }
}
