package com.fpolizzi.day12.exerciese;

import java.util.Scanner;

/**
 * Created by fpolizzi on 08.11.25
 */
public class MenuCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0.0;
        boolean firstCalculation = true;

        System.out.println("=== Menu-Driven Calculator ===");

        do {
            System.out.println("\nCurrent result: " + result);
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Clear");
            System.out.println("6. Exit");

            System.out.print("Enter your choice (1-6): ");
            int choice = scanner.nextInt();

            if (choice == 6) {
                System.out.println("Final result: " + result);
                System.out.println("Goodbye!");
                break;
            } else if (choice == 5) {
                result = 0.0;
                firstCalculation = true;
                System.out.println("Result cleared!");
                continue;
            } else if (choice < 1 || choice > 6) {
                System.out.println("Invalid choice! Please enter 1-6.");
                continue;
            }

            double number;
            if (firstCalculation) {
                System.out.print("Enter first number: ");
                number = scanner.nextDouble();
                result = number;
                firstCalculation = false;
            } else {
                System.out.print("Enter number: ");
                number = scanner.nextDouble();
            }

            switch (choice) {
                case 1:
                    result += number;
                    break;
                case 2:
                    result -= number;
                    break;
                case 3:
                    result *= number;
                    break;
                case 4:
                    if (number != 0) {
                        result /= number;
                    } else {
                        System.out.println("Error: Cannot divide by zero!");
                    }
                    break;
            }

        } while (true);

        scanner.close();
    }
}
