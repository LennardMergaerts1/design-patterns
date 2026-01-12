package be.ucll.crafsmanship.template.dataprocessor;

public abstract class DataProcessor {
    protected String inputFile;
    protected String outputFile;

    public DataProcessor(String inputFile, String outputFile) {
        this.inputFile = inputFile;
        this.outputFile = outputFile;
    }

    // Template Method - defines the algorithm structure
    // Hollywood Principle: "Don't call us, we'll call you"
    public final void process() {
        System.out.println("\n=== Starting Data Processing Pipeline ===");
        preProcess(); // Hook method - can be overridden
        load();
        transform();
        if (shouldValidate()) { // Hook method with conditional logic
            validate();
        }
        save();
        System.out.println("=== Pipeline Complete ===");
    }

    protected abstract void load();
    protected abstract void transform();
    protected abstract void save();

    // Hook methods (optional override)
    protected void preProcess() {
        // Default implementation does nothing
        // Subclasses can override if needed
    }

    protected boolean shouldValidate() {
        // Default: no validation
        return false;
    }

    protected void validate() {
        System.out.println("Running validation...");
    }
}
