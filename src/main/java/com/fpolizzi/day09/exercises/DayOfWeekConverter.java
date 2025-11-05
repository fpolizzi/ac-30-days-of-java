package com.fpolizzi.day09.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 05.11.25
 */
public class DayOfWeekConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Day of Week Converter ===");
        System.out.print("Enter day number (1-7): ");
        int dayNumber = scanner.nextInt();

        String dayName;
        String dayType;

        // Convert number to day name
        switch (dayNumber) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
                break;
        }

        // Determine the day type
        switch (dayNumber) {
            case 1, 2, 3, 4, 5:
                dayType = "Weekday";
                break;
            case 6, 7:
                dayType = "Weekend";
                break;
            default:
                dayType = "Invalid";
                break;
        }

        System.out.println("Day: " + dayName);
        System.out.println("Type: " + dayType);

        scanner.close();
    }
}
