package com.fpolizzi.day03.examples;

/**
 * Created by fpolizzi on 27.10.25
 */
public class StringAnalyzer {
    public static void main(String[] args) {
        String text = "Java Programming is Fun!";

        System.out.println("=== String Analyzer ===");
        System.out.println("Original text: " + text);
        System.out.println("Length: " + text.length());
        System.out.println("First character: " + text.charAt(0));
        System.out.println("Last character: " + text.charAt(text.length() - 1));
        System.out.println("Uppercase: " + text.toUpperCase());
        System.out.println("Lowercase: " + text.toLowerCase());
        System.out.println("Contains 'Java': " + text.contains("Java"));
        System.out.println("Starts with 'Java': " + text.startsWith("Java"));
        System.out.println("Ends with 'Fun!': " + text.endsWith("Fun!"));
    }
}
