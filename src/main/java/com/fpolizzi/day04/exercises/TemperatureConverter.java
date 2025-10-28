package com.fpolizzi.day04.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 28.10.25
 */
public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Temperature Converter ===");

        System.out.print("Enter temperature in Celsius: ");
        double celsius = scanner.nextDouble();

        // Convert to Fahrenheit: F = C × 9/5 + 32
        double fahrenheit = celsius * 9.0 / 5.0 + 32;

        // Convert to Kelvin: K = C + 273.15
        double kelvin = celsius + 273.15;

        // Display results
        System.out.println("\n=== Temperature Conversions ===");
        System.out.printf("Celsius: %.2f°C%n", celsius);
        System.out.printf("Fahrenheit: %.2f°F%n", fahrenheit);
        System.out.printf("Kelvin: %.2f K%n", kelvin);

        scanner.close();
    }
}
