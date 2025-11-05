package com.fpolizzi.day09.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 05.11.25
 */
public class SwitchCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Switch Calculator ===");

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter operation (+, -, *, /, %): ");
        String operation = scanner.next();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result = 0.0;
        boolean validOperation = true;

        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Cannot divide by zero!");
                    validOperation = false;
                }
                break;
            case "%":
                result = num1 % num2;
                break;
            default:
                System.out.println("Error: Invalid operation!");
                validOperation = false;
                break;
        }

        if (validOperation) {
            System.out.printf("%.2f %s %.2f = %.2f%n", num1, operation, num2, result);
        }

        scanner.close();
    }
}
