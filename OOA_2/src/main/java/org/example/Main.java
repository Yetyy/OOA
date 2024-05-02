package org.example;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String filePath = "src/test/resources/utf16be_test.txt";

        // Создаем экземпляр TextFileEncodingAdapter с использованием LegacyTextFileReader
        TextFileReader textFileReader = new TextFileEncodingAdapter(new LegacyTextFileReader());

        try {
            // Читаем текстовое содержимое и определяем кодировку
            String textContent = textFileReader.readText(filePath);
            String encoding = ((TextFileEncodingAdapter) textFileReader).getDetectedEncoding();

            // Выводим кодировку файла и текстовое содержимое
            System.out.println("Кодировка файла: " + encoding);
            System.out.println("Текстовое содержимое:\n" + textContent);
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }
    }
}
