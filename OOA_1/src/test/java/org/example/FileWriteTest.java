package org.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;


class FileWriteTest {

    @Test
    void testLettersOnlyStrategy() {
        String content = "abc123def456ghi";
        FileWriteStrategy strategy = new LettersOnlyStrategy("test_letters_only.txt");
        try {
            strategy.writeToFile(content);
            String fileContent = TestUtils.readFileContent("test_letters_only.txt");
            assertEquals("abcdefghi", fileContent);
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testDigitsOnlyStrategy() {
        String content = "abc123def456ghi";
        FileWriteStrategy strategy = new DigitsOnlyStrategy("test_digits_only.txt");
        try {
            strategy.writeToFile(content);
            String fileContent = TestUtils.readFileContent("test_digits_only.txt");
            assertEquals("123456", fileContent);
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testLettersAndDigitsStrategy() {
        String content = "abc123def456ghi";
        FileWriteStrategy strategy = new LettersAndDigitsStrategy("test_letters_and_digits.txt");
        try {
            strategy.writeToFile(content);
            String fileContent = TestUtils.readFileContent("test_letters_and_digits.txt");
            assertEquals("abc123def456ghi", fileContent);
        } catch (IOException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }
}

