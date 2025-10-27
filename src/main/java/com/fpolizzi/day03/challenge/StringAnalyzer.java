package com.fpolizzi.day03.challenge;

/**
 * Created by fpolizzi on 27.10.25
 */
public class StringAnalyzer {
    public static void main(String[] args) {
        String text = "Hello Java World";

        System.out.println("=== String Analyzer ===");

        // Display the original text
        System.out.println("Original text: " + text);

        // Get the length of the string
        int length = text.length();

        // Get the first and last characters
        char firstCharacter = text.charAt(0);
        char lastCharacter = text.charAt(length - 1);

        // Convert to uppercase and lowercase
        String upperCase = text.toUpperCase();
        String lowerCase = text.toLowerCase();

        // Check if it contains "Java"
        boolean containsJava = text.contains("Java");

        // Check if it starts with "Hello"
        boolean startsWithHello = text.startsWith("Hello");

        // Check if it ends with "World"
        boolean endsWithWorld = text.endsWith("World");

        // Display all results
        System.out.println("Length: " + length);
        System.out.println("First character: " + firstCharacter);
        System.out.println("Last character: " + lastCharacter);
        System.out.println("Uppercase: " + upperCase);
        System.out.println("Lowercase: " + lowerCase);
        System.out.println("Contains 'Java': " + containsJava);
        System.out.println("Starts with 'Hello': " + startsWithHello);
        System.out.println("Ends with 'World': " + endsWithWorld);
    }
}