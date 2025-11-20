package com.fpolizzi.day22.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 20.11.25
 */
public class StringUtilities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== String Utilities ===");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Call various string utility methods
        displayStringInfo(input);

        System.out.print("Enter another string: ");
        String input2 = scanner.nextLine();

        // Compare strings
        compareStrings(input, input2);

        // Check palindrome
        System.out.print("Enter a string to check if palindrome: ");
        String palindromeCheck = scanner.nextLine();
        boolean isPalindrome = checkPalindrome(palindromeCheck);
        System.out.println("Is palindrome: " + isPalindrome);

        scanner.close();
    }

    // Display information about a string
    public static void displayStringInfo(String str) {
        System.out.println("\n=== String Information ===");
        System.out.println("Original string: " + str);
        System.out.println("Length: " + str.length());
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.println("First character: " + str.charAt(0));
        System.out.println("Last character: " + str.charAt(str.length() - 1));
        System.out.println("Contains 'a': " + str.toLowerCase().contains("a"));
        System.out.println("Starts with 'A': " + str.startsWith("A"));
        System.out.println("Ends with 'e': " + str.endsWith("e"));
    }

    // Compare two strings
    public static void compareStrings(String str1, String str2) {
        System.out.println("\n=== String Comparison ===");
        System.out.println("String 1: " + str1);
        System.out.println("String 2: " + str2);
        System.out.println("Are equal: " + str1.equals(str2));
        System.out.println("Are equal (ignore case): " + str1.equalsIgnoreCase(str2));
        System.out.println("String 1 length: " + str1.length());
        System.out.println("String 2 length: " + str2.length());

        if (str1.length() > str2.length()) {
            System.out.println("String 1 is longer");
        } else if (str1.length() < str2.length()) {
            System.out.println("String 2 is longer");
        } else {
            System.out.println("Both strings have the same length");
        }
    }

    // Check if string is palindrome
    public static boolean checkPalindrome(String str) {
        // Remove spaces and convert to lowercase
        String clean = str.replaceAll("\\s+", "").toLowerCase();

        int left = 0;
        int right = clean.length() - 1;

        while (left < right) {
            if (clean.charAt(left) != clean.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    // Count vowels in string
    public static int countVowels(String str) {
        int count = 0;
        String vowels = "aeiouAEIOU";

        for (char c : str.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }

        return count;
    }

    // Reverse a string
    public static String reverseString(String str) {
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }

        return reversed.toString();
    }
}
