package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



abstract class AbstractFileWriteStrategy implements FileWriteStrategy {
    protected File file;

    public AbstractFileWriteStrategy(String filePath) {
        this.file = new File(filePath);
    }

    @Override
    public long measureExecutionTime() {
        long startTime = System.nanoTime();
        try {
            writeToFile(""); // Delegate to concrete strategy
        } catch (IOException e) {
            e.printStackTrace(); // Handle exception appropriately
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    @Override
    public abstract void writeToFile(String content) throws IOException;
}


