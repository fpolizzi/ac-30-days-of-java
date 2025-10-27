package com.fpolizzi.day03.practice;

import java.util.Scanner;

/**
 * Created by fpolizzi on 27.10.25
 */
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Grade Calculator ===");
        System.out.print("Enter the number of grades: ");
        int numberOfGrades = scanner.nextInt();

        double summedGrades = 0.0;

        for (int i = 0; i < numberOfGrades; i++) {
            double grade = scanner.nextDouble();
            summedGrades += grade;
        }

        double averageGrade = summedGrades / numberOfGrades;

        System.out.print("Average grade: ");
        System.out.printf("%.2f", averageGrade);

        scanner.close();
    }
}
