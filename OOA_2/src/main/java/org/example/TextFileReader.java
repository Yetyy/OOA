package org.example;
import java.io.*;

// Интерфейс, который определяет единый метод для чтения текста из файла
interface TextFileReader {
    public String readText(String filePath) throws IOException;
}