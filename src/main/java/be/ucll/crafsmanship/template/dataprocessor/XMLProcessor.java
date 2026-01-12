package be.ucll.crafsmanship.template.dataprocessor;

import java.util.ArrayList;
import java.util.List;

public class XMLProcessor extends DataProcessor {
    private List<String> xmlElements;

    public XMLProcessor(String inputFile, String outputFile) {
        super(inputFile, outputFile);
        this.xmlElements = new ArrayList<>();
    }

    @Override
    protected void load() {
        System.out.println("Loading XML from: " + inputFile);
        // Simulating XML data loading
        xmlElements.add("<user><id>1</id><name>Alice</name></user>");
        xmlElements.add("<user><id>2</id><name>Bob</name></user>");
        xmlElements.add("<user><id>3</id><name>Charlie</name></user>");
        System.out.println("Loaded " + xmlElements.size() + " XML elements");
    }

    @Override
    protected void transform() {
        System.out.println("Transforming XML data: Adding status attribute");
        List<String> transformedElements = new ArrayList<>();
        
        for (String element : xmlElements) {
            // Add status="active" attribute to each user element
            String transformed = element.replace("<user>", "<user status=\"active\">");
            transformedElements.add(transformed);
        }
        
        xmlElements = transformedElements;
        System.out.println("Transformation complete");
    }

    @Override
    protected void save() {
        System.out.println("Saving XML to: " + outputFile);
        // Simulating saving to file
        System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        System.out.println("<users>");
        for (String element : xmlElements) {
            System.out.println("  " + element);
        }
        System.out.println("</users>");
        System.out.println("XML saved successfully");
    }

    // Override hook method to demonstrate usage
    @Override
    protected void preProcess() {
        System.out.println("XML Processor: Running pre-processing validation...");
    }
}
