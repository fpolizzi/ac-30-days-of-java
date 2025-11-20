package com.fpolizzi.day22.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 20.11.25
 */
public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Temperature Converter ===");

        while (true) {
            System.out.println("\n1. Celsius to Fahrenheit");
            System.out.println("2. Fahrenheit to Celsius");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 3) {
                System.out.println("Goodbye!");
                break;
            }

            System.out.print("Enter temperature: ");
            double temperature = scanner.nextDouble();

            switch (choice) {
                case 1:
                    double fahrenheit = celsiusToFahrenheit(temperature);
                    System.out.printf("%.1f°C = %.1f°F%n", temperature, fahrenheit);
                    break;
                case 2:
                    double celsius = fahrenheitToCelsius(temperature);
                    System.out.printf("%.1f°F = %.1f°C%n", temperature, celsius);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        scanner.close();
    }

    // Convert Celsius to Fahrenheit
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = (celsius * 9/5) + 32;
        return fahrenheit;
    }

    // Convert Fahrenheit to Celsius
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = (fahrenheit - 32) * 5/9;
        return celsius;
    }
}
