package com.fpolizzi.day02.exercises;

/**
 * Created by fpolizzi on 26.10.25
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        int a = 23;
        int b = 7;

        int sum = a + b;
        int difference = a - b;
        int product = a * b;
        int quotient = a / b;
        int remainder = a % b;

        System.out.println("=== Simple Calculator ===");
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder: " + remainder);
    }
}
