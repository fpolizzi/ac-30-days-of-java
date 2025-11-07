package com.fpolizzi.day11.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 07.11.25
 */
public class MenuSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("=== Calculator Menu ===");

        while (running) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");

            System.out.print("Enter your choice (1-5): ");
            int choice = scanner.nextInt();

            if (choice == 5) {
                running = false;
                System.out.println("Goodbye!");
            } else if (choice >= 1 && choice <= 4) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();

                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                double result = 0.0;
                String operation = "";

                switch (choice) {
                    case 1:
                        result = num1 + num2;
                        operation = "+";
                        break;
                    case 2:
                        result = num1 - num2;
                        operation = "-";
                        break;
                    case 3:
                        result = num1 * num2;
                        operation = "*";
                        break;
                    case 4:
                        if (num2 != 0) {
                            result = num1 / num2;
                            operation = "/";
                        } else {
                            System.out.println("Error: Cannot divide by zero!");
                            continue;
                        }
                        break;
                }

                System.out.printf("%.2f %s %.2f = %.2f%n", num1, operation, num2, result);
            } else {
                System.out.println("Invalid choice! Please enter 1-5.");
            }
        }

        scanner.close();
    }
}
