package com.fpolizzi.day08.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 04.11.25
 */
public class WeatherAdvisorySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Weather Advisory System ===");

        System.out.print("Enter temperature (°C): ");
        int temperature = scanner.nextInt();

        System.out.print("Enter wind speed (km/h): ");
        int windSpeed = scanner.nextInt();

        System.out.print("Is it raining? (true/false): ");
        boolean isRaining = scanner.nextBoolean();

        System.out.print("Is it snowing? (true/false): ");
        boolean isSnowing = scanner.nextBoolean();

        // Weather conditions
        boolean isHot = temperature > 30;
        boolean isCold = temperature < 0;
        boolean isWindy = windSpeed > 50;
        boolean isPrecipitating = isRaining || isSnowing;

        // Advisory logic
        boolean heatWarning = isHot && !isPrecipitating;
        boolean coldWarning = isCold && isWindy;
        boolean stormWarning = isWindy && isPrecipitating;
        boolean normalConditions = !isHot && !isCold && !isWindy && !isPrecipitating;

        System.out.println("\n=== Weather Analysis ===");
        System.out.println("Temperature: " + temperature + "°C");
        System.out.println("Wind Speed: " + windSpeed + " km/h");
        System.out.println("Precipitation: " + (isPrecipitating ? "Yes" : "No"));

        System.out.println("\n=== Advisories ===");
        if (heatWarning) {
            System.out.println("🌡️ HEAT WARNING: Stay hydrated and avoid outdoor activities!");
        }
        if (coldWarning) {
            System.out.println("❄️ COLD WARNING: Bundle up and limit outdoor exposure!");
        }
        if (stormWarning) {
            System.out.println("⛈️ STORM WARNING: Seek shelter and avoid travel!");
        }
        if (normalConditions) {
            System.out.println("☀️ Normal weather conditions. Enjoy your day!");
        }

        scanner.close();
    }
}
