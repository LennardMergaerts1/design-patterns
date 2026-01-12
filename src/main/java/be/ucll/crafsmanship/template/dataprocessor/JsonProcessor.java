package be.ucll.crafsmanship.template.dataprocessor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JsonProcessor extends DataProcessor {
    private List<String> records;
    private DateTimeFormatter formatter;

    public JsonProcessor(String inputFile, String outputFile) {
        super(inputFile, outputFile);
        this.records = new ArrayList<>();
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    }

    @Override
    protected void load() {
        System.out.println("Loading JSON from: " + inputFile);
        // Simulating JSON data loading
        records.add("{\"id\": 1, \"name\": \"Alice\"}");
        records.add("{\"id\": 2, \"name\": \"Bob\"}");
        records.add("{\"id\": 3, \"name\": \"Charlie\"}");
        System.out.println("Loaded " + records.size() + " JSON records");
    }

    @Override
    protected void transform() {
        System.out.println("Transforming JSON data: Adding timestamp to each record");
        String timestamp = LocalDateTime.now().format(formatter);
        List<String> transformedRecords = new ArrayList<>();
        
        for (String record : records) {
            // Add timestamp field before the closing brace
            String transformedRecord = record.substring(0, record.length() - 1) + 
                                     ", \"timestamp\": \"" + timestamp + "\"}";
            transformedRecords.add(transformedRecord);
        }
        
        records = transformedRecords;
        System.out.println("Transformation complete");
    }

    @Override
    protected void save() {
        System.out.println("Saving JSON to: " + outputFile);
        // Simulating saving to file
        System.out.println("[");
        for (int i = 0; i < records.size(); i++) {
            System.out.print("  " + records.get(i));
            if (i < records.size() - 1) {
                System.out.println(",");
            } else {
                System.out.println();
            }
        }
        System.out.println("]");
        System.out.println("JSON saved successfully");
    }
}
