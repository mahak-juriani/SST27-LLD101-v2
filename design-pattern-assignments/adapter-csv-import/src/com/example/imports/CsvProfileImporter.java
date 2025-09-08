package com.example.imports;
import java.util.List;
import java.util.Objects;
import java.nio.file.Path;

public class CsvProfileImporter implements ProfileImporter{
    private NaiveCsvReader reader;
    private ProfileService service;

    CsvProfileImporter(NaiveCsvReader reader, ProfileService service){
        this.reader = Objects.requireNonNull(reader);
        this.service = Objects.requireNonNull(service);
    }

    @Override
    public int importFrom(Path csvFile){
        List<String[]> rows = reader.read(csvFile);
        if(rows.isEmpty()){
            System.out.println("No data found");
            return 0;
        }
        int count = 0;
        int start = looksLikeHeader(rows.get(0)) ? 1 : 0;       
        for (int i = start; i < rows.size(); i++) {
            String[] row = rows.get(i);
            if (row.length < 2) {
                System.out.println("Skipping row (not enough columns)");
                continue;
            }

            String id = row[0].trim();
            String email = row[1].trim();
            String displayName = row.length > 2 ? row[2].trim() : "";

            if (id.isEmpty()) {
                System.out.println("Skipping row (missing id)");
                continue;
            }
            if (email.isEmpty() || !email.contains("@")) {
                System.out.println("Skipping row (bad email)");
                continue;
            }

            // Delegate to ProfileService
            service.createProfile(id, email, displayName);
            count++;
        }
        return count;
    }

    private boolean looksLikeHeader(String[] row) {
        return row[0].equalsIgnoreCase("id")
            && row[1].equalsIgnoreCase("email");
    }
}
