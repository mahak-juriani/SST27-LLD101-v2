package com.example.report;
import java.nio.file.Path;
import java.util.Objects;

public class ReportBundleFacade {
    public Path export(java.util.Map<String,Object> data, java.nio.file.Path outDir, String baseName){
        Objects.requireNonNull(data);
        Objects.requireNonNull(outDir);
        Objects.requireNonNull(baseName);

        Path json = new JsonWriter().write(data, outDir, baseName);
        Path zip = outDir.resolve(baseName + ".zip");

        new Zipper().zip(json, zip);

        new AuditLog().log("exported " + zip);

        return zip;
    }
}
