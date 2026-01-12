package be.ucll.crafsmanship.template.dataprocessor;

import java.util.ArrayList;
import java.util.List;

public class CSVProcessor extends DataProcessor {
    private List<String> data;

    public CSVProcessor(String inputFile, String outputFile) {
        super(inputFile, outputFile);
        this.data = new ArrayList<>();
    }

    @Override
    protected void load() {
        System.out.println("Loading CSV from: " + inputFile);
        
        this.data.add("name,age,city");
        this.data.add("john,25,new york");
        this.data.add("jane,30,london");
        this.data.add("bob,35,paris");
        System.out.println("Loaded " + data.size() + " lines from CSV");
    }

    @Override
    protected void transform() {
        System.out.println("Transforming CSV data: Converting to uppercase");
        data.replaceAll(String::toUpperCase);
        System.out.println("Transformation complete");
    }

    @Override
    protected void save() {
        System.out.println("Saving CSV to: " + outputFile);
        
        for (String line : data) {
            System.out.println("  " + line);
        }
        System.out.println("CSV saved successfully");
    }
}
