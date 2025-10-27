package com.fpolizzi.day03.practice;

import java.util.Scanner;

/**
 * Created by fpolizzi on 27.10.25
 */
public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Temperature Converter ===");

        System.out.println("Enter a temperature: ");
        double temperature = scanner.nextDouble();

        System.out.println("Enter a temperature unit (C or F)");
        String unit = scanner.next();
        if (unit.equals("C")) {
            System.out.print("The temperature in Fahrenheit is: ");
            double result = temperature * 9.0 / 5.0 + 32;
            System.out.printf ("%.2f", result);
        } else if (unit.equals("F")) {
            double result = (temperature - 32) * 5.0 / 9.0;
            System.out.print("The temperature in Celsius is: ");
            System.out.printf ("%.2f", result);
        }

        scanner.close();
    }
}
