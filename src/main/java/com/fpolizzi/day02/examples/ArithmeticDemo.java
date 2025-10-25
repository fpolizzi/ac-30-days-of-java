package com.fpolizzi.day02.examples;

/**
 * Created by fpolizzi on 26.10.25
 */

// Example 2: Arithmetic Operations
public class ArithmeticDemo {
    public static void main(String[] args) {
        int a = 13;
        int b = 5;

        // Basic arithmetic operations
        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;
        int remainder = a % b;

        // Display results
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }
}