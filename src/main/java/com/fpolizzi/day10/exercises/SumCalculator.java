package com.fpolizzi.day10.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 06.11.25
 */
public class SumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sum Calculator ===");
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        int sum = 0;

        // Calculate sum from 1 to n
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        System.out.println("Sum of numbers from 1 to " + n + " is: " + sum);

        // Calculate factorial
        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("Factorial of " + n + " is: " + factorial);

        scanner.close();
    }
}
