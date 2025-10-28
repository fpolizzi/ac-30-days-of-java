package com.fpolizzi.day04.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 28.10.25
 */
public class AdvancedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Advanced Calculator ===");

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        // Perform all operations
        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;
        double remainder = num1 % num2;
        double power = Math.pow(num1, num2);
        double sqrt1 = Math.sqrt(num1);
        double sqrt2 = Math.sqrt(num2);

        // Display results
        System.out.println("\n=== Results ===");
        System.out.println(num1 + " + " + num2 + " = " + sum);
        System.out.println(num1 + " - " + num2 + " = " + difference);
        System.out.println(num1 + " × " + num2 + " = " + product);
        System.out.println(num1 + " ÷ " + num2 + " = " + quotient);
        System.out.println(num1 + " % " + num2 + " = " + remainder);
        System.out.println(num1 + " ^ " + num2 + " = " + power);
        System.out.println("√" + num1 + " = " + sqrt1);
        System.out.println("√" + num2 + " = " + sqrt2);

        scanner.close();
    }
}
