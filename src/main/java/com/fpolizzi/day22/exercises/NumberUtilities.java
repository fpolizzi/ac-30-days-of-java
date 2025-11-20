package com.fpolizzi.day22.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 20.11.25
 */
public class NumberUtilities {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Number Utilities ===");

        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        // Call various utility methods
        displayNumberInfo(number);

        System.out.print("Enter another number: ");
        int number2 = scanner.nextInt();

        // Compare numbers
        compareNumbers(number, number2);

        // Calculate factorial
        System.out.print("Enter a number for factorial: ");
        int factorialNumber = scanner.nextInt();
        long factorial = calculateFactorial(factorialNumber);
        System.out.println("Factorial of " + factorialNumber + " = " + factorial);

        scanner.close();
    }

    // Display information about a number
    public static void displayNumberInfo(int number) {
        System.out.println("\n=== Number Information ===");
        System.out.println("Number: " + number);
        System.out.println("Absolute value: " + Math.abs(number));
        System.out.println("Square: " + (number * number));
        System.out.println("Square root: " + Math.sqrt(Math.abs(number)));
        System.out.println("Is even: " + isEven(number));
        System.out.println("Is positive: " + isPositive(number));
    }

    // Check if number is even
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    // Check if number is positive
    public static boolean isPositive(int number) {
        return number > 0;
    }

    // Compare two numbers
    public static void compareNumbers(int num1, int num2) {
        System.out.println("\n=== Number Comparison ===");
        System.out.println("Numbers: " + num1 + " and " + num2);

        if (num1 > num2) {
            System.out.println(num1 + " is greater than " + num2);
        } else if (num1 < num2) {
            System.out.println(num1 + " is less than " + num2);
        } else {
            System.out.println(num1 + " is equal to " + num2);
        }

        System.out.println("Maximum: " + Math.max(num1, num2));
        System.out.println("Minimum: " + Math.min(num1, num2));
    }

    // Calculate factorial
    public static long calculateFactorial(int number) {
        if (number < 0) {
            return -1; // Error indicator
        }

        if (number == 0 || number == 1) {
            return 1;
        }

        long factorial = 1;
        for (int i = 2; i <= number; i++) {
            factorial *= i;
        }

        return factorial;
    }
}
