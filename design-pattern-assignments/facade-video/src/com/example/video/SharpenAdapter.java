package com.example.video;
import java.util.Objects;

public class SharpenAdapter {
    private final LegacySharpen legacy;

    public SharpenAdapter(LegacySharpen legacy){
        this.legacy = Objects.requireNonNull(legacy);
    }

    public Frame[] apply(Frame[] frames, int strength) {
        Objects.requireNonNull(frames, "frames");

        String handle = toHandle(frames);
        String outHandle = legacy.applySharpen(handle, strength);

        return fromHandle(outHandle, frames);
    }

    private String toHandle(Frame[] frames) {
        return "HANDLE:frames=" + frames.length;
    }

    private Frame[] fromHandle(String handle, Frame[] original) {
        return original;
    }
}
