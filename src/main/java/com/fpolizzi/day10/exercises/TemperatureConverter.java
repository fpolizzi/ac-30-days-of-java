package com.fpolizzi.day10.exercises;

/**
 * Created by fpolizzi on 06.11.25
 */
public class TemperatureConverter {
    public static void main(String[] args) {
        System.out.println("=== Temperature Conversion Table ===");
        System.out.println("Celsius | Fahrenheit");
        System.out.println("--------|-----------");

        // Convert Celsius to Fahrenheit from 0 to 100
        for (int celsius = 0; celsius <= 100; celsius += 10) {
            double fahrenheit = (celsius * 9.0 / 5.0) + 32;
            System.out.printf("%7d | %10.1f%n", celsius, fahrenheit);
        }

        System.out.println();
        System.out.println("=== Fahrenheit to Celsius ===");
        System.out.println("Fahrenheit | Celsius");
        System.out.println("-----------|--------");

        // Convert Fahrenheit to Celsius from 32 to 212
        for (int fahrenheit = 32; fahrenheit <= 212; fahrenheit += 20) {
            double celsius = (fahrenheit - 32) * 5.0 / 9.0;
            System.out.printf("%10d | %7.1f%n", fahrenheit, celsius);
        }
    }
}
