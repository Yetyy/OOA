package org.example;
import java.io.*;
import java.nio.charset.*;
import java.nio.ByteBuffer;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

class TextFileEncodingAdapter extends LegacyTextFileReader implements TextFileReader {

    private String detectedEncoding; // сохраненная кодировка

    public TextFileEncodingAdapter(LegacyTextFileReader legacyTextFileReader) {
        super();
    }

    @Override
    public String readText(String filePath) throws IOException {
        String textContent = super.readText(filePath);  // Вызов метода суперкласса для получения текстового содержимого
        this.detectedEncoding = detectEncoding(filePath);  // Определение кодировки на основе содержимого файла
        if (detectedEncoding == null) {
            detectedEncoding = probeFileEncoding(filePath);
        }
        return textContent;  // Возвращаем текстовое содержимое
    }

    public String getDetectedEncoding() {
        return detectedEncoding; // Метод получения сохраненной кодировки
    }

    private String detectEncoding(String filePath) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath))) {
            byte[] buf = new byte[3];
            if (bis.markSupported()) {
                bis.mark(3);
                bis.read(buf, 0, 3);
                bis.reset();
            }

            // Определение кодировки на основе байтовой последовательности в начале файла
            if (buf[0] == (byte) 0xFF && buf[1] == (byte) 0xFE) {
                return "UTF-16LE";
            } else if (buf[0] == (byte) 0xFE && buf[1] == (byte) 0xFF) {
                return "UTF-16BE";
            } else if (buf[0] == (byte) 0xEF && buf[1] == (byte) 0xBB && buf[2] == (byte) 0xBF) {//buf[0] == (byte) 0xEF
                return "UTF-8";
            } else {
                return null;
            }
        }
    }
    private String probeFileEncoding(String filePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            CharsetDecoder decoder = StandardCharsets.ISO_8859_1.newDecoder();
            decoder.onMalformedInput(CodingErrorAction.REPORT);
            decoder.onUnmappableCharacter(CodingErrorAction.REPORT);
                decoder.decode(ByteBuffer.wrap(bytes));
                for (byte b : bytes) {
                    if (b < 0 && b >= -128 && b != -64 && b != -63 && b != -32 && b != -31 && b != -16 && b != -15) {
                        return "Windows-1251";
                    }
                }
                return "ISO-8859-1";
        }
    }

}