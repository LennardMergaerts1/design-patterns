package be.ucll.crafsmanship.template.dataprocessor;

public class Demo {
    public static void main(String[] args) {
        // Hollywood Principle in action:
        // The subclasses don't call process() themselves.
        // The client creates instances and calls process(),
        // which then orchestrates the calls to load, transform, and save.
        
        System.out.println("===== CSV Data Processing =====");
        DataProcessor csvProcessor = new CSVProcessor("input.csv", "output.csv");
        csvProcessor.process(); 

        System.out.println("\n\n===== JSON Data Processing =====");
        DataProcessor jsonProcessor = new JsonProcessor("input.json", "output.json");
        jsonProcessor.process(); 

        System.out.println("\n\n===== XML Data Processing (with Hook) =====");
        DataProcessor xmlProcessor = new XMLProcessor("input.xml", "output.xml");
        xmlProcessor.process(); 
        
        System.out.println("\n\n===== Template Method Pattern Demo Complete =====");
        System.out.println("Note: The base class DataProcessor controlled the workflow.");
        System.out.println("Subclasses only provided implementations for load, transform, and save.");
        System.out.println("XMLProcessor demonstrated the use of hook methods (preProcess).");
    }
}
