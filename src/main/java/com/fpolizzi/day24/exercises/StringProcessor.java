package com.fpolizzi.day24.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 23.11.25
 */
public class StringProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== String Processor ===");

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            processString(scanner, choice);
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n1. Process single string");
        System.out.println("2. Process two strings");
        System.out.println("3. Process string with character");
        System.out.println("4. Process string with number");
        System.out.println("5. Compare strings");
        System.out.println("0. Exit");
    }

    public static void processString(Scanner scanner, int choice) {
        switch (choice) {
            case 1:
                processSingleString(scanner);
                break;
            case 2:
                processTwoStrings(scanner);
                break;
            case 3:
                processStringWithChar(scanner);
                break;
            case 4:
                processStringWithNumber(scanner);
                break;
            case 5:
                compareStrings(scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void processSingleString(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        System.out.println("Original: " + input);
        System.out.println("Uppercase: " + process(input));
        System.out.println("Lowercase: " + process(input, "lower"));
        System.out.println("Reversed: " + process(input, "reverse"));
        System.out.println("Length: " + process(input, "length"));
    }

    public static void processTwoStrings(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        System.out.println("Combined: " + process(str1, str2));
        System.out.println("Common prefix: " + process(str1, str2, "prefix"));
        System.out.println("Longer string: " + process(str1, str2, "longer"));
    }

    public static void processStringWithChar(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter a character: ");
        char ch = scanner.nextLine().charAt(0);

        System.out.println("Count of '" + ch + "': " + process(input, ch));
        System.out.println("Remove '" + ch + "': " + process(input, ch, "remove"));
        System.out.println("Replace '" + ch + "' with '*': " + process(input, ch, '*'));
    }

    public static void processStringWithNumber(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        System.out.println("Repeat " + num + " times: " + process(input, num));
        System.out.println("First " + num + " characters: " + process(input, num, "first"));
        System.out.println("Last " + num + " characters: " + process(input, num, "last"));
    }

    public static void compareStrings(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        System.out.println("Are equal: " + compare(str1, str2));
        System.out.println("Are equal (ignore case): " + compare(str1, str2, true));
        System.out.println("Which is longer: " + compare(str1, str2, "length"));
    }

    // Overloaded process methods
    public static String process(String str) {
        return str.toUpperCase();
    }

    public static String process(String str, String operation) {
        switch (operation.toLowerCase()) {
            case "lower":
                return str.toLowerCase();
            case "reverse":
                return new StringBuilder(str).reverse().toString();
            case "length":
                return String.valueOf(str.length());
            default:
                return str;
        }
    }

    public static String process(String str1, String str2, String operation) {
        switch (operation.toLowerCase()) {
            case "prefix":
                int minLength = Math.min(str1.length(), str2.length());
                int prefixLength = 0;
                for (int i = 0; i < minLength; i++) {
                    if (str1.charAt(i) == str2.charAt(i)) {
                        prefixLength++;
                    } else {
                        break;
                    }
                }
                return str1.substring(0, prefixLength);
            case "longer":
                return str1.length() > str2.length() ? str1 : str2;
            default:
                return str1 + " " + str2;
        }
    }

    public static int process(String str, char ch) {
        int count = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            }
        }
        return count;
    }

    public static String process(String str, char ch, String operation) {
        if (operation.equals("remove")) {
            return str.replace(String.valueOf(ch), "");
        }
        return str;
    }

    public static String process(String str, char oldChar, char newChar) {
        return str.replace(oldChar, newChar);
    }

    public static String process(String str, int num) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < num; i++) {
            result.append(str);
        }
        return result.toString();
    }

    public static String process(String str, int num, String operation) {
        if (num > str.length()) {
            num = str.length();
        }

        switch (operation.toLowerCase()) {
            case "first":
                return str.substring(0, num);
            case "last":
                return str.substring(str.length() - num);
            default:
                return str;
        }
    }

    // Overloaded compare methods
    public static boolean compare(String str1, String str2) {
        return str1.equals(str2);
    }

    public static boolean compare(String str1, String str2, boolean ignoreCase) {
        return ignoreCase ? str1.equalsIgnoreCase(str2) : str1.equals(str2);
    }

    public static String compare(String str1, String str2, String type) {
        if (type.equals("length")) {
            if (str1.length() > str2.length()) {
                return "First string is longer";
            } else if (str2.length() > str1.length()) {
                return "Second string is longer";
            } else {
                return "Both strings have equal length";
            }
        }
        return "Invalid comparison type";
    }
}