package com.fpolizzi.day27.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 27.11.25
 */
public class SafeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Safe Calculator ===");

        while (true) {
            try {
                System.out.println("\n1. Addition");
                System.out.println("2. Division");
                System.out.println("3. Square root");
                System.out.println("4. Exit");

                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                if (choice == 4) {
                    System.out.println("Goodbye!");
                    break;
                }

                performCalculation(scanner, choice);

            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
                scanner.nextLine(); // Clear input buffer
            }
        }

        scanner.close();
    }

    public static void performCalculation(Scanner scanner, int choice) {
        try {
            switch (choice) {
                case 1:
                    System.out.print("Enter two numbers: ");
                    double a = scanner.nextDouble();
                    double b = scanner.nextDouble();
                    System.out.println("Result: " + (a + b));
                    break;

                case 2:
                    System.out.print("Enter dividend: ");
                    double dividend = scanner.nextDouble();
                    System.out.print("Enter divisor: ");
                    double divisor = scanner.nextDouble();

                    if (divisor == 0) {
                        throw new ArithmeticException("Cannot divide by zero!");
                    }
                    System.out.println("Result: " + (dividend / divisor));
                    break;

                case 3:
                    System.out.print("Enter number: ");
                    double number = scanner.nextDouble();

                    if (number < 0) {
                        throw new IllegalArgumentException("Cannot calculate square root of negative number!");
                    }
                    System.out.println("Result: " + Math.sqrt(number));
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } catch (ArithmeticException e) {
            System.out.println("Arithmetic error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
