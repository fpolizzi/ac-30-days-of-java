package com.fpolizzi.day05.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 29.10.25
 */
public class NameFormatter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Name Formatter ===");

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        // Format the name in different ways
        String fullName = firstName + " " + lastName;
        String formalName = lastName + ", " + firstName;
        String initials = firstName.charAt(0) + "." + lastName.charAt(0) + ".";
        String upperFullName = fullName.toUpperCase();

        System.out.println("\n=== Formatted Names ===");
        System.out.println("Full Name: " + fullName);
        System.out.println("Formal Name: " + formalName);
        System.out.println("Initials: " + initials);
        System.out.println("Uppercase: " + upperFullName);

        scanner.close();
    }
}
