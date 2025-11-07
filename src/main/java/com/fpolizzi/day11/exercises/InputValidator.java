package com.fpolizzi.day11.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 07.11.25
 */
public class InputValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Input Validator ===");

        int age = 0;
        boolean validAge = false;

        // Keep asking until valid age is entered
        while (!validAge) {
            System.out.print("Enter your age (1-120): ");

            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                if (age >= 1 && age <= 120) {
                    validAge = true;
                } else {
                    System.out.println("Age must be between 1 and 120!");
                }
            } else {
                System.out.println("Please enter a valid number!");
                scanner.next(); // Clear invalid input
            }
        }

        System.out.println("Valid age entered: " + age);

        // Validate password
        String password = "";
        boolean validPassword = false;

        while (!validPassword) {
            System.out.print("Enter password (at least 8 characters): ");
            password = scanner.next();

            if (password.length() >= 8) {
                validPassword = true;
            } else {
                System.out.println("Password must be at least 8 characters long!");
            }
        }

        System.out.println("Valid password entered!");

        scanner.close();
    }
}
