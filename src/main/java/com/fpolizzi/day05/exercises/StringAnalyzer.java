package com.fpolizzi.day05.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 29.10.25
 */
public class StringAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== String Analyzer ===");
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // Analyze the string
        int length = sentence.length();
        String upperCase = sentence.toUpperCase();
        String lowerCase = sentence.toLowerCase();
        String trimmed = sentence.trim();

        System.out.println("\n=== Analysis Results ===");
        System.out.println("Original: '" + sentence + "'");
        System.out.println("Length: " + length + " characters");
        System.out.println("Uppercase: " + upperCase);
        System.out.println("Lowercase: " + lowerCase);
        System.out.println("Trimmed: '" + trimmed + "'");

        // Check for specific words
        if (sentence.toLowerCase().contains("java")) {
            System.out.println("Contains 'Java': Yes");
        } else {
            System.out.println("Contains 'Java': No");
        }

        scanner.close();
    }
}
