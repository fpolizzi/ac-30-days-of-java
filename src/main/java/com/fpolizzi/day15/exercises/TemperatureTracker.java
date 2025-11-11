package com.fpolizzi.day15.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 11.11.25
 */
public class TemperatureTracker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Weekly Temperature Tracker ===");
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        double[] temperatures = new double[7];

        for (int i = 0; i < days.length; i++) {
            System.out.print("Enter temperature for " + days[i] + ": ");
            temperatures[i] = scanner.nextDouble();
        }

        System.out.println("\n=== Weekly Temperature Summary ===");
        for (int i = 0; i < days.length; i++) {
            System.out.printf("%s: %.1f°C%n", days[i], temperatures[i]);
        }

        int hottestDay = 0;
        int coldestDay = 0;
        for (int i = 1; i < temperatures.length; i++) {
            if (temperatures[i] > temperatures[hottestDay]) hottestDay = i;
            if (temperatures[i] < temperatures[coldestDay]) coldestDay = i;
        }

        System.out.println("\n=== Analysis ===");
        System.out.println("Hottest day: " + days[hottestDay] + " (" + temperatures[hottestDay] + "°C)");
        System.out.println("Coldest day: " + days[coldestDay] + " (" + temperatures[coldestDay] + "°C)");

        double sum = 0;
        for (double temp : temperatures) sum += temp;
        double average = sum / temperatures.length;
        System.out.printf("Average temperature: %.1f°C%n", average);

        scanner.close();
    }
}
