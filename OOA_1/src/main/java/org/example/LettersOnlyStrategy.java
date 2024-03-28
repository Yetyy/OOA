package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LettersOnlyStrategy extends AbstractFileWriteStrategy {

    public LettersOnlyStrategy(String filePath) {

        super(filePath);
    }

    @Override
    public void printAlgorithmName() {
        System.out.println("Letters Only Strategy");
    }

    @Override
    public void printAlgorithmDescription() {
        System.out.println("This strategy writes only letters to the file.");
    }

    @Override
    public long measureExecutionTime() {
        long startTime = System.nanoTime();
        try {

            writeToFile("");
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        return endTime - startTime;
    }

    @Override
    public void writeToFile(String content) throws IOException {
        Pattern pattern = Pattern.compile("[a-zA-Z]+");
        Matcher matcher = pattern.matcher(content);
        StringBuilder sb = new StringBuilder();
        while (matcher.find()) {
            sb.append(matcher.group());
        }

        FileWriter writer = new FileWriter(file);
        writer.write(sb.toString());
        writer.close();
    }
}
