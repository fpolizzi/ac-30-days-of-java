package com.fpolizzi.day02.exercises;

/**
 * Created by fpolizzi on 26.10.25
 */
public class TemperatureConverter {
    public static void main(String[] args) {
        double celsius = 28.4;

        // convert celsius to fahrenheit
        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println("=== Temperature Converter ===");
        System.out.println("Celsius: " + celsius + " Fahrenheit: " + fahrenheit);
    }
}
