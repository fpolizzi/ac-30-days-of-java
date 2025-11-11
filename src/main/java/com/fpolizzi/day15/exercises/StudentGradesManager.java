package com.fpolizzi.day15.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 11.11.25
 */
public class StudentGradesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grades Manager ===");
        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();

        String[] names = new String[numStudents];
        int[] grades = new int[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            names[i] = scanner.next();
            System.out.print("Enter grade for " + names[i] + ": ");
            grades[i] = scanner.nextInt();
        }

        System.out.println("\n=== Student Grades ===");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(names[i] + ": " + grades[i]);
        }

        int sum = 0;
        int highest = grades[0];
        int lowest = grades[0];
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
            if (grades[i] > highest) highest = grades[i];
            if (grades[i] < lowest) lowest = grades[i];
        }
        double average = (double) sum / grades.length;

        System.out.println("\n=== Statistics ===");
        System.out.println("Average grade: " + average);
        System.out.println("Highest grade: " + highest);
        System.out.println("Lowest grade: " + lowest);

        scanner.close();
    }
}
