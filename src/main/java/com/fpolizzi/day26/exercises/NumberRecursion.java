package com.fpolizzi.day26.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 25.11.25
 */
public class NumberRecursion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Number Operations with Recursion ===");

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Count digits
        System.out.println("Number of digits: " + countDigits(number));

        // Sum of digits
        System.out.println("Sum of digits: " + sumDigits(number));

        // Reverse number
        System.out.println("Reversed number: " + reverseNumber(number));

        // Check if palindrome
        System.out.println("Is palindrome: " + isNumberPalindrome(number));

        // Convert to binary
        System.out.println("Binary: " + decimalToBinary(number));

        // Calculate digital root
        System.out.println("Digital root: " + digitalRoot(number));

        scanner.close();
    }

    // Recursive count digits
    public static int countDigits(int number) {
        // Base case
        if (number < 10) {
            return 1;
        }

        // Recursive case
        return 1 + countDigits(number / 10);
    }

    // Recursive sum of digits
    public static int sumDigits(int number) {
        // Base case
        if (number < 10) {
            return number;
        }

        // Recursive case
        return (number % 10) + sumDigits(number / 10);
    }

    // Recursive reverse number
    public static int reverseNumber(int number) {
        return reverseNumberHelper(number, 0);
    }

    private static int reverseNumberHelper(int number, int reversed) {
        // Base case
        if (number == 0) {
            return reversed;
        }

        // Recursive case
        return reverseNumberHelper(number / 10, reversed * 10 + number % 10);
    }

    // Recursive check if number is palindrome
    public static boolean isNumberPalindrome(int number) {
        return number == reverseNumber(number);
    }

    // Recursive decimal to binary
    public static String decimalToBinary(int number) {
        // Base case
        if (number == 0) {
            return "0";
        }

        if (number == 1) {
            return "1";
        }

        // Recursive case
        return decimalToBinary(number / 2) + (number % 2);
    }

    // Recursive digital root
    public static int digitalRoot(int number) {
        // Base case
        if (number < 10) {
            return number;
        }

        // Recursive case
        return digitalRoot(sumDigits(number));
    }

    // Recursive greatest common divisor
    public static int gcd(int a, int b) {
        // Base case
        if (b == 0) {
            return a;
        }

        // Recursive case
        return gcd(b, a % b);
    }

    // Recursive least common multiple
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
