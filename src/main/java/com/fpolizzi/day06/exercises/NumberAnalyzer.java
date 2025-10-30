package com.fpolizzi.day06.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 30.10.25
 */
public class NumberAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Number Analyzer ===");
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();

        System.out.println("\n=== Analysis ===");

        // Check if positive, negative, or zero
        if (number > 0) {
            System.out.println("The number is positive.");
        } else if (number < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }

        // Check if even or odd
        if (number % 2 == 0) {
            System.out.println("The number is even.");
        } else {
            System.out.println("The number is odd.");
        }

        // Check if it's a single digit
        if (number >= -9 && number <= 9) {
            System.out.println("The number is a single digit.");
        } else {
            System.out.println("The number has multiple digits.");
        }

        scanner.close();
    }
}
