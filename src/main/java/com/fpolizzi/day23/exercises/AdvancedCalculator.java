package com.fpolizzi.day23.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 21.11.25
 */
public class AdvancedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Advanced Calculator ===");

        while (true) {
            displayMenu();
            int choice = getUserChoice(scanner);

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            double result = performOperation(scanner, choice);
            if (result != Double.NaN) {
                System.out.printf("Result: %.2f%n", result);
            }
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n1. Addition");
        System.out.println("2. Subtraction");
        System.out.println("3. Multiplication");
        System.out.println("4. Division");
        System.out.println("5. Power");
        System.out.println("6. Square Root");
        System.out.println("7. Average of multiple numbers");
        System.out.println("8. Find maximum");
        System.out.println("0. Exit");
    }

    public static int getUserChoice(Scanner scanner) {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }

    public static double performOperation(Scanner scanner, int choice) {
        switch (choice) {
            case 1:
                return add(getTwoNumbers(scanner));
            case 2:
                return subtract(getTwoNumbers(scanner));
            case 3:
                return multiply(getTwoNumbers(scanner));
            case 4:
                return divide(getTwoNumbers(scanner));
            case 5:
                return power(getTwoNumbers(scanner));
            case 6:
                return squareRoot(getOneNumber(scanner));
            case 7:
                return average(getMultipleNumbers(scanner));
            case 8:
                return maximum(getMultipleNumbers(scanner));
            default:
                System.out.println("Invalid choice!");
                return Double.NaN;
        }
    }

    public static double[] getTwoNumbers(Scanner scanner) {
        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();
        return new double[]{num1, num2};
    }

    public static double getOneNumber(Scanner scanner) {
        System.out.print("Enter number: ");
        return scanner.nextDouble();
    }

    public static double[] getMultipleNumbers(Scanner scanner) {
        System.out.print("How many numbers? ");
        int count = scanner.nextInt();
        double[] numbers = new double[count];

        for (int i = 0; i < count; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }

        return numbers;
    }

    // Operation methods
    public static double add(double[] numbers) {
        return numbers[0] + numbers[1];
    }

    public static double subtract(double[] numbers) {
        return numbers[0] - numbers[1];
    }

    public static double multiply(double[] numbers) {
        return numbers[0] * numbers[1];
    }

    public static double divide(double[] numbers) {
        if (numbers[1] == 0) {
            System.out.println("Error: Cannot divide by zero!");
            return Double.NaN;
        }
        return numbers[0] / numbers[1];
    }

    public static double power(double[] numbers) {
        return Math.pow(numbers[0], numbers[1]);
    }

    public static double squareRoot(double number) {
        if (number < 0) {
            System.out.println("Error: Cannot calculate square root of negative number!");
            return Double.NaN;
        }
        return Math.sqrt(number);
    }

    public static double average(double[] numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum / numbers.length;
    }

    public static double maximum(double[] numbers) {
        double max = numbers[0];
        for (double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
}
