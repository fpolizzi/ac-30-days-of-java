package com.fpolizzi.day19.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by fpolizzi on 16.11.25
 */
public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Text Analyzer ===");
        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        // Word count
        String[] words = text.split("\\s+");
        System.out.println("Word count: " + words.length);

        // Character count
        System.out.println("Character count: " + text.length());

        // Letter frequency
        Map<Character, Integer> letterFreq = new HashMap<>();
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                letterFreq.put(c, letterFreq.getOrDefault(c, 0) + 1);
            }
        }

        System.out.println("Letter frequencies:");
        letterFreq.entrySet().stream()
                .sorted(Map.Entry.<Character, Integer>comparingByValue().reversed())
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        // Most common word
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word.toLowerCase(), wordFreq.getOrDefault(word.toLowerCase(), 0) + 1);
        }

        String mostCommon = wordFreq.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("None");

        System.out.println("Most common word: " + mostCommon);
    }
}
