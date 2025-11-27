package com.fpolizzi.day27.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 27.11.25
 */
public class DataValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Data Validator ===");

        while (true) {
            try {
                System.out.println("\n1. Validate age");
                System.out.println("2. Validate email");
                System.out.println("3. Validate phone number");
                System.out.println("4. Validate password");
                System.out.println("5. Exit");

                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 5) {
                    System.out.println("Goodbye!");
                    break;
                }

                performValidation(scanner, choice);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static void performValidation(Scanner scanner, int choice) {
        try {
            switch (choice) {
                case 1:
                    validateAge(scanner);
                    break;
                case 2:
                    validateEmail(scanner);
                    break;
                case 3:
                    validatePhone(scanner);
                    break;
                case 4:
                    validatePassword(scanner);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (ValidationException e) {
            System.out.println("Validation error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public static void validateAge(Scanner scanner) throws ValidationException {
        System.out.print("Enter age: ");
        String input = scanner.nextLine();

        try {
            int age = Integer.parseInt(input);

            if (age < 0) {
                throw new ValidationException("Age cannot be negative");
            }
            if (age > 150) {
                throw new ValidationException("Age seems unrealistic");
            }

            System.out.println("Valid age: " + age);

        } catch (NumberFormatException e) {
            throw new ValidationException("Age must be a number");
        }
    }

    public static void validateEmail(Scanner scanner) throws ValidationException {
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (email == null || email.isEmpty()) {
            throw new ValidationException("Email cannot be empty");
        }

        if (!email.contains("@")) {
            throw new ValidationException("Email must contain @ symbol");
        }

        if (!email.contains(".")) {
            throw new ValidationException("Email must contain domain");
        }

        System.out.println("Valid email: " + email);
    }

    public static void validatePhone(Scanner scanner) throws ValidationException {
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        if (phone == null || phone.isEmpty()) {
            throw new ValidationException("Phone number cannot be empty");
        }

        // Remove all non-digit characters
        String digitsOnly = phone.replaceAll("\\D", "");

        if (digitsOnly.length() != 10 && digitsOnly.length() != 11) {
            throw new ValidationException("Phone number must be 10 or 11 digits");
        }

        System.out.println("Valid phone number: " + phone);
    }

    public static void validatePassword(Scanner scanner) throws ValidationException {
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (password == null || password.length() < 8) {
            throw new ValidationException("Password must be at least 8 characters");
        }

        if (!password.matches(".*[A-Z].*")) {
            throw new ValidationException("Password must contain uppercase letter");
        }

        if (!password.matches(".*[a-z].*")) {
            throw new ValidationException("Password must contain lowercase letter");
        }

        if (!password.matches(".*\\d.*")) {
            throw new ValidationException("Password must contain digit");
        }

        System.out.println("Valid password!");
    }
}

class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }
}
