package com.fpolizzi.day08.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 04.11.25
 */
public class LoanEligibilityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Loan Eligibility Checker ===");

        // Read inputs: age, income, creditScore, isEmployed, loanAmount
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.println(age);

        System.out.print("Enter annual income: $");
        double income = scanner.nextDouble();
        System.out.println(income);

        System.out.print("Enter credit score: ");
        int creditScore = scanner.nextInt();
        System.out.println(creditScore);

        System.out.print("Are you employed? (true/false): ");
        boolean isEmployed = scanner.nextBoolean();
        System.out.println(isEmployed);

        System.out.print("Enter loan amount: $");
        double loanAmount = scanner.nextDouble();
        System.out.println(loanAmount);

        // Compute boolean flags for each requirement
        boolean ageEligible = age >= 18;
        // do the rest of the checks
        boolean incomeEligible = income >= 25000;
        boolean creditEligible = creditScore >= 650;
        boolean employmentEligible = isEmployed;
        boolean loanAmountEligible = loanAmount <= (income * 3);

        // Compute overall eligibility using &&
        boolean isEligible = ageEligible && incomeEligible && creditEligible &&
                employmentEligible && loanAmountEligible;

        // Print per-requirement results and overall decision
        System.out.println("\n=== Eligibility Results ===");
        System.out.println("Age requirement: " + (ageEligible ? "PASSED" : "FAILED"));
        System.out.println("Income requirement: " + (incomeEligible ? "PASSED" : "FAILED"));
        System.out.println("Credit score requirement: " + (creditEligible ? "PASSED" : "FAILED"));
        System.out.println("Employment requirement: " + (employmentEligible ? "PASSED" : "FAILED"));
        System.out.println("Loan amount requirement: " + (loanAmountEligible ? "PASSED" : "FAILED (Loan exceeds 3x income)"));

        System.out.println("\nOverall eligibility: " + (isEligible ? "PASSED ELIGIBLE" : "FAILED NOT ELIGIBLE"));

        // if isEligible is false, print "Some checks failed"
        if (!isEligible) {
            System.out.println("Reason: Some checks failed");
        }

        scanner.close();
    }
}
