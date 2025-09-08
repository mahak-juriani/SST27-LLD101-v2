package com.example.video;
import java.nio.file.Path ;
import java.util.Objects;
public class VideoPipelineFacade {
    public Path process(java.nio.file.Path src, java.nio.file.Path out, boolean gray, Double scale, Integer sharpenStrength){
        Objects.requireNonNull(src);
        Objects.requireNonNull(out);

        Decoder decoder = new Decoder();
        Encoder encoder = new Encoder();
        FilterEngine filter = new FilterEngine();
        SharpenAdapter sharpen = new SharpenAdapter(new LegacySharpen());

        Frame[] frames = decoder.decode(src);

        if(gray){
            frames = filter.grayscale(frames);
        }

        if(scale!=null){
            frames = filter.scale(frames, scale);
        }

        if(sharpenStrength!=null){
            frames = sharpen.apply(frames, sharpenStrength);
        }

        return encoder.encode(frames, out);
    }
}
