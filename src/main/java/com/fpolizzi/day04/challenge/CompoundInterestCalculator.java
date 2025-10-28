package com.fpolizzi.day04.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 28.10.25
 */
public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Compound Interest Calculator ===");

        System.out.print("Enter principal amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual interest rate (as decimal): ");
        double rate = scanner.nextDouble();

        System.out.print("Enter time period (years): ");
        double time = scanner.nextDouble();

        // Calculate compound interest (compounded annually, so n = 1)
        double finalAmount = principal * Math.pow(1 + rate, time);
        double interestEarned = finalAmount - principal;

        // Display results
        System.out.printf("Final Amount: $%.2f%n", finalAmount);
        System.out.printf("Interest Earned: $%.2f%n", interestEarned);

        scanner.close();
    }
}

