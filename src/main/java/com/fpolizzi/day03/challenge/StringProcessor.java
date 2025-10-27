package com.fpolizzi.day03.challenge;

/**
 * Created by fpolizzi on 27.10.25
 */
public class StringProcessor {
    public static void main(String[] args) {
        String sentence = "Java Programming is Amazing";

        System.out.println("=== String Processor ===");
        System.out.println("Original sentence: " + sentence);

        // Count words
        String[] words = sentence.split(" ");
        System.out.println("Number of words: " + words.length);

        // Find longest word
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest word: " + longestWord);

        // Reverse sentence
        String[] reversedWords = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversedWords[i] = words[words.length - 1 - i];
        }
        String reversedSentence = String.join(" ", reversedWords);
        System.out.println("Reversed sentence: " + reversedSentence);

        // Count vowels and consonants
        int vowels = 0;
        int consonants = 0;
        String lowerSentence = sentence.toLowerCase();

        for (int i = 0; i < lowerSentence.length(); i++) {
            char c = lowerSentence.charAt(i);
            if (c >= 'a' && c <= 'z') {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }
}
