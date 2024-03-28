package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String content = "abc123def456ghi";

        FileWriteStrategy lettersOnlyStrategy = new LettersOnlyStrategy("letters_only.txt");
        lettersOnlyStrategy.printAlgorithmName();
        lettersOnlyStrategy.printAlgorithmDescription();
        long lettersOnlyTime = lettersOnlyStrategy.measureExecutionTime();
        try {
            lettersOnlyStrategy.writeToFile(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Execution time for letters only strategy: " + lettersOnlyTime + " nanoseconds");

        FileWriteStrategy digitsOnlyStrategy = new DigitsOnlyStrategy("digits_only.txt");
        digitsOnlyStrategy.printAlgorithmName();
        digitsOnlyStrategy.printAlgorithmDescription();
        long digitsOnlyTime = digitsOnlyStrategy.measureExecutionTime();
        try {
            digitsOnlyStrategy.writeToFile(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Execution time for digits only strategy: " + digitsOnlyTime + " nanoseconds");

        FileWriteStrategy lettersAndDigitsStrategy = new LettersAndDigitsStrategy("letters_and_digits.txt");
        lettersAndDigitsStrategy.printAlgorithmName();
        lettersAndDigitsStrategy.printAlgorithmDescription();
        long lettersAndDigitsTime = lettersAndDigitsStrategy.measureExecutionTime();
        try {
            lettersAndDigitsStrategy.writeToFile(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Execution time for letters and digits strategy: " + lettersAndDigitsTime + " nanoseconds");
    }
}
