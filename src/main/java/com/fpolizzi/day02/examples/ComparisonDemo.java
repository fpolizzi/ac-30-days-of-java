package com.fpolizzi.day02.examples;

/**
 * Created by fpolizzi on 26.10.25
 */

// Example 3: Comparison and Logical Operations
public class ComparisonDemo {
    public static void main(String[] args) {
        int age = 20;
        boolean hasLicense = true;
        boolean isStudent = false;

        // Comparison operations
        boolean isAdult = age >= 18;
        boolean canDrive = hasLicense && isAdult;
        boolean isEligible = isStudent || (age >= 18);

        // Display results
        System.out.println("Age: " + age);
        System.out.println("Has License: " + hasLicense);
        System.out.println("Is Student: " + isStudent);
        System.out.println("Is Adult: " + isAdult);
        System.out.println("Can Drive: " + canDrive);
        System.out.println("Is Eligible: " + isEligible);
    }
}
