package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class GenerateFilesForTests {
    public static void main(String[] args) {
        String testDir = "src/test/resources/";

        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(testDir + "utf8_test.txt"), StandardCharsets.UTF_8)) {
            writer.write("This is a UTF-8 test file.\n");
        } catch (IOException e) {
            System.err.println("Error creating UTF-8 test file: " + e.getMessage());
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(testDir + "utf16le_test.txt"), StandardCharsets.UTF_16LE)) {
            writer.write("This is a UTF-16LE test file.\n");
        } catch (IOException e) {
            System.err.println("Error creating UTF-16LE test file: " + e.getMessage());
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(testDir + "utf16be_test.txt"), StandardCharsets.UTF_16BE)) {
            writer.write("This is a UTF-16BE test file.\n");
        } catch (IOException e) {
            System.err.println("Error creating UTF-16BE test file: " + e.getMessage());
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(testDir + "windows1251_test.txt"), "Windows-1251")) {
            writer.write("Это тестовый файл в кодировке Windows-1251.\n");
        } catch (IOException e) {
            System.err.println("Error creating Windows-1251 test file: " + e.getMessage());
        }

        try (OutputStreamWriter writer = new OutputStreamWriter(
                new FileOutputStream(testDir + "iso88591_test.txt"), StandardCharsets.ISO_8859_1)) {
            writer.write("This is an ISO-8859-1 test file with a Euro symbol: €\n");
        } catch (IOException e) {
            System.err.println("Error creating ISO-8859-1 test file: " + e.getMessage());
        }
    }
}
