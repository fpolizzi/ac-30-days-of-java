package com.fpolizzi.day13.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 09.11.25
 */
public class CalendarGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Calendar Generator ===");
        System.out.print("Enter month (1-12): ");
        int month = scanner.nextInt();

        System.out.print("Enter year: ");
        int year = scanner.nextInt();

        // DONE: Validate month, compute daysInMonth, firstDay
        if (month < 1 || month > 12) {
            System.out.println("Invalid month!");
            scanner.close();
            return;
        }

        String[] monthNames = {"", "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

        int daysInMonth = getDaysInMonth(month, year);
        int firstDay = getFirstDayOfMonth(month, year);

        System.out.println();
        System.out.println("      " + monthNames[month] + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // DONE: Use nested loops to print the calendar grid
        int day = 1;
        for (int week = 0; week < 6; week++) {
            for (int weekday = 0; weekday < 7; weekday++) {
                if (week == 0 && weekday < firstDay) {
                    System.out.print("    ");
                } else if (day > daysInMonth) {
                    break;
                } else {
                    System.out.printf("%3d ", day);
                    day++;
                }
            }
            System.out.println();
            if (day > daysInMonth) break;
        }

        scanner.close();
    }

    public static int getDaysInMonth(int month, int year) {
        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (month == 2 && isLeapYear(year)) return 29;
        return daysInMonth[month];
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getFirstDayOfMonth(int month, int year) {
        if (month < 3) { month += 12; year--; }
        int k = year % 100;
        int j = year / 100;
        int h = (1 + (13 * (month + 1)) / 5 + k + k / 4 + j / 4 - 2 * j) % 7;
        return (h + 5) % 7; // 0=Sun
    }
}
