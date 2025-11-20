package com.fpolizzi.day22.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 20.11.25
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Calculator ===");

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            if (choice == 5) {
                System.out.println("Thank you for using the calculator!");
                break;
            }

            if (choice >= 1 && choice <= 4) {
                performCalculation(scanner, choice);
            } else {
                System.out.println("Invalid choice! Please try again.");
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Exit");
    }

    public static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public static double[] getNumbers(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        return new double[]{num1, num2};
    }

    public static void performCalculation(Scanner scanner, int choice) {
        double[] numbers = getNumbers(scanner);
        double num1 = numbers[0];
        double num2 = numbers[1];

        double result = 0;
        String operation = "";
        boolean validOperation = true;

        switch (choice) {
            case 1:
                result = add(num1, num2);
                operation = "+";
                break;
            case 2:
                result = subtract(num1, num2);
                operation = "-";
                break;
            case 3:
                result = multiply(num1, num2);
                operation = "*";
                break;
            case 4:
                if (num2 == 0) {
                    System.out.println("Error: Cannot divide by zero!");
                    validOperation = false;
                } else {
                    result = divide(num1, num2);
                    operation = "/";
                }
                break;
        }

        if (validOperation) {
            System.out.printf("Result: %.1f %s %.1f = %.2f%n", num1, operation, num2, result);
        }
    }

    public static double add(double a, double b) { return a + b; }
    public static double subtract(double a, double b) { return a - b; }
    public static double multiply(double a, double b) { return a * b; }
    public static double divide(double a, double b) { return a / b; }
}
