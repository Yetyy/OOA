package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class TextFileEncodingAdapterTest {

    private static final String TEST_DIR = "src/test/resources/";
    private static final String NON_EXISTENT_FILE_PATH = "path/to/nonexistent/file.txt";

    @Test
    void testReadText_ValidUtf8File() throws IOException {
        String filePath = TEST_DIR + "utf8_test.txt";
        LegacyTextFileReader legacyTextFileReader = new LegacyTextFileReader();
        TextFileReader textFileReader = new TextFileEncodingAdapter(legacyTextFileReader);

        String textContent = textFileReader.readText(filePath);
        String encoding = ((TextFileEncodingAdapter) textFileReader).getDetectedEncoding();

        assertEquals("UTF-8", encoding);
    }

    @Test
    void testReadText_ValidUtf16LEFile() throws IOException {
        String filePath = TEST_DIR + "utf16le_test.txt";
        LegacyTextFileReader legacyTextFileReader = new LegacyTextFileReader();
        TextFileReader textFileReader = new TextFileEncodingAdapter(legacyTextFileReader);

        String textContent = textFileReader.readText(filePath);
        String encoding = ((TextFileEncodingAdapter) textFileReader).getDetectedEncoding();

        assertEquals("UTF-16LE", encoding);
    }

    @Test
    void testReadText_ValidUtf16BEFile() throws IOException {
        String filePath = TEST_DIR + "utf16be_test.txt";
        LegacyTextFileReader legacyTextFileReader = new LegacyTextFileReader();
        TextFileReader textFileReader = new TextFileEncodingAdapter(legacyTextFileReader);

        String textContent = textFileReader.readText(filePath);
        String encoding = ((TextFileEncodingAdapter) textFileReader).getDetectedEncoding();

        assertEquals("UTF-16BE", encoding);
    }

    @Test
    void testReadText_ValidWindows1251File() throws IOException {
        String filePath = TEST_DIR + "windows1251_test.txt";
        LegacyTextFileReader legacyTextFileReader = new LegacyTextFileReader();
        TextFileReader textFileReader = new TextFileEncodingAdapter(legacyTextFileReader);

        String textContent = textFileReader.readText(filePath);
        String encoding = ((TextFileEncodingAdapter) textFileReader).getDetectedEncoding();

        assertEquals("Windows-1251", encoding);
    }

    @Test
    void testReadText_NonExistentFile() {
        LegacyTextFileReader legacyTextFileReader = new LegacyTextFileReader();
        TextFileReader textFileReader = new TextFileEncodingAdapter(legacyTextFileReader);

        assertThrows(IOException.class, () -> textFileReader.readText(NON_EXISTENT_FILE_PATH));
    }
}
