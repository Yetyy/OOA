package org.example;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class TestUtils {
    static String readFileContent(String filePath) throws IOException {
        File file = new File(filePath);
        byte[] contentBytes = Files.readAllBytes(file.toPath());
        return new String(contentBytes);
    }
}