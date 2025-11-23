package com.fpolizzi.day24.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 23.11.25
 */
public class AdvancedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Advanced Calculator ===");

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            performCalculation(scanner, choice);
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n1. Add numbers");
        System.out.println("2. Multiply numbers");
        System.out.println("3. Calculate power");
        System.out.println("4. Calculate average");
        System.out.println("5. Find maximum");
        System.out.println("0. Exit");
    }

    public static void performCalculation(Scanner scanner, int choice) {
        switch (choice) {
            case 1:
                performAddition(scanner);
                break;
            case 2:
                performMultiplication(scanner);
                break;
            case 3:
                performPower(scanner);
                break;
            case 4:
                performAverage(scanner);
                break;
            case 5:
                performMaximum(scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void performAddition(Scanner scanner) {
        System.out.println("How many numbers to add? (2-4): ");
        int count = scanner.nextInt();

        switch (count) {
            case 2:
                System.out.print("Enter two numbers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println("Sum: " + add(a, b));
                break;
            case 3:
                System.out.print("Enter three numbers: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                System.out.println("Sum: " + add(x, y, z));
                break;
            case 4:
                System.out.print("Enter four numbers: ");
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                int r = scanner.nextInt();
                int s = scanner.nextInt();
                System.out.println("Sum: " + add(p, q, r, s));
                break;
            default:
                System.out.println("Invalid count!");
        }
    }

    public static void performMultiplication(Scanner scanner) {
        System.out.println("How many numbers to multiply? (2-3): ");
        int count = scanner.nextInt();

        switch (count) {
            case 2:
                System.out.print("Enter two numbers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println("Product: " + multiply(a, b));
                break;
            case 3:
                System.out.print("Enter three numbers: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                System.out.println("Product: " + multiply(x, y, z));
                break;
            default:
                System.out.println("Invalid count!");
        }
    }

    public static void performPower(Scanner scanner) {
        System.out.print("Enter base and exponent: ");
        double base = scanner.nextDouble();
        double exponent = scanner.nextDouble();
        System.out.println("Result: " + power(base, exponent));
    }

    public static void performAverage(Scanner scanner) {
        System.out.println("How many numbers? (2-4): ");
        int count = scanner.nextInt();

        switch (count) {
            case 2:
                System.out.print("Enter two numbers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println("Average: " + average(a, b));
                break;
            case 3:
                System.out.print("Enter three numbers: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                System.out.println("Average: " + average(x, y, z));
                break;
            case 4:
                System.out.print("Enter four numbers: ");
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                int r = scanner.nextInt();
                int s = scanner.nextInt();
                System.out.println("Average: " + average(p, q, r, s));
                break;
            default:
                System.out.println("Invalid count!");
        }
    }

    public static void performMaximum(Scanner scanner) {
        System.out.println("How many numbers? (2-4): ");
        int count = scanner.nextInt();

        switch (count) {
            case 2:
                System.out.print("Enter two numbers: ");
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                System.out.println("Maximum: " + max(a, b));
                break;
            case 3:
                System.out.print("Enter three numbers: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                System.out.println("Maximum: " + max(x, y, z));
                break;
            case 4:
                System.out.print("Enter four numbers: ");
                int p = scanner.nextInt();
                int q = scanner.nextInt();
                int r = scanner.nextInt();
                int s = scanner.nextInt();
                System.out.println("Maximum: " + max(p, q, r, s));
                break;
            default:
                System.out.println("Invalid count!");
        }
    }

    // Overloaded add methods
    public static int add(int a, int b) {
        return a + b;
    }

    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static int add(int a, int b, int c, int d) {
        return a + b + c + d;
    }

    // Overloaded multiply methods
    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int multiply(int a, int b, int c) {
        return a * b * c;
    }

    // Power method
    public static double power(double base, double exponent) {
        return Math.pow(base, exponent);
    }

    // Overloaded average methods
    public static double average(int a, int b) {
        return (a + b) / 2.0;
    }

    public static double average(int a, int b, int c) {
        return (a + b + c) / 3.0;
    }

    public static double average(int a, int b, int c, int d) {
        return (a + b + c + d) / 4.0;
    }

    // Overloaded max methods
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }

    public static int max(int a, int b, int c, int d) {
        return Math.max(Math.max(a, b), Math.max(c, d));
    }
}
