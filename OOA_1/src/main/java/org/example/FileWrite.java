package org.example;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface FileWriteStrategy extends FileWriteInfoProvider {
    void writeToFile(String content) throws IOException;
    long measureExecutionTime();
}
