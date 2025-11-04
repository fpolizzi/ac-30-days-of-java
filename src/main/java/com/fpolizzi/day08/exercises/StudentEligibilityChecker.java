package com.fpolizzi.day08.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 04.11.25
 */
public class StudentEligibilityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Eligibility Checker ===");

        System.out.print("Enter student age: ");
        int age = scanner.nextInt();

        System.out.print("Enter GPA (0.0-4.0): ");
        double gpa = scanner.nextDouble();

        System.out.print("Has completed prerequisites? (true/false): ");
        boolean hasPrerequisites = scanner.nextBoolean();

        System.out.print("Is enrolled full-time? (true/false): ");
        boolean isFullTime = scanner.nextBoolean();

        // Check eligibility
        boolean ageEligible = age >= 18;
        boolean gpaEligible = gpa >= 2.0;
        boolean prerequisitesMet = hasPrerequisites;
        boolean enrollmentValid = isFullTime;

        boolean isEligible = ageEligible && gpaEligible && prerequisitesMet && enrollmentValid;

        System.out.println("\n=== Eligibility Results ===");
        System.out.println("Age eligible (18+): " + ageEligible);
        System.out.println("GPA eligible (2.0+): " + gpaEligible);
        System.out.println("Prerequisites met: " + prerequisitesMet);
        System.out.println("Full-time enrollment: " + enrollmentValid);
        System.out.println("Overall eligibility: " + isEligible);

        if (isEligible) {
            System.out.println("✅ Student is eligible for the program!");
        } else {
            System.out.println("❌ Student is not eligible for the program.");
        }

        scanner.close();
    }
}
