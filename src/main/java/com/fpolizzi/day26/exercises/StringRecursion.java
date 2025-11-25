package com.fpolizzi.day26.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 25.11.25
 */
public class StringRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== String Operations with Recursion ===");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // String length
        System.out.println("Length: " + stringLength(input));

        // Reverse string
        System.out.println("Reversed: " + reverseString(input));

        // Count vowels
        System.out.println("Vowels: " + countVowels(input, 0));

        // Check palindrome
        System.out.println("Is palindrome: " + isPalindrome(input, 0, input.length() - 1));

        // Remove vowels
        System.out.println("Without vowels: " + removeVowels(input));

        scanner.close();
    }

    // Recursive string length
    public static int stringLength(String str) {
        // Base case
        if (str == null || str.isEmpty()) {
            return 0;
        }

        // Recursive case
        return 1 + stringLength(str.substring(1));
    }

    // Recursive string reverse
    public static String reverseString(String str) {
        // Base case
        if (str == null || str.length() <= 1) {
            return str;
        }

        // Recursive case
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
    }

    // Recursive vowel count
    public static int countVowels(String str, int index) {
        // Base case
        if (index >= str.length()) {
            return 0;
        }

        // Check current character
        char current = Character.toLowerCase(str.charAt(index));
        int count = 0;
        if (current == 'a' || current == 'e' || current == 'i' ||
                current == 'o' || current == 'u') {
            count = 1;
        }

        // Recursive case
        return count + countVowels(str, index + 1);
    }

    // Recursive palindrome check
    public static boolean isPalindrome(String str, int start, int end) {
        // Base case
        if (start >= end) {
            return true;
        }

        // Check characters at start and end
        if (Character.toLowerCase(str.charAt(start)) !=
                Character.toLowerCase(str.charAt(end))) {
            return false;
        }

        // Recursive case
        return isPalindrome(str, start + 1, end - 1);
    }

    // Recursive remove vowels
    public static String removeVowels(String str) {
        // Base case
        if (str == null || str.isEmpty()) {
            return str;
        }

        char first = str.charAt(0);
        String rest = removeVowels(str.substring(1));

        // Check if first character is vowel
        if (Character.toLowerCase(first) == 'a' ||
                Character.toLowerCase(first) == 'e' ||
                Character.toLowerCase(first) == 'i' ||
                Character.toLowerCase(first) == 'o' ||
                Character.toLowerCase(first) == 'u') {
            return rest;
        } else {
            return first + rest;
        }
    }
}
