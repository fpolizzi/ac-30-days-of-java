package com.fpolizzi.day23.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 21.11.25
 */
public class StudentGradeAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Student Grade Analyzer ===");

        System.out.print("Enter number of students: ");
        int numStudents = scanner.nextInt();

        String[] names = new String[numStudents];
        double[] grades = new double[numStudents];

        // Input student data
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter name for student " + (i + 1) + ": ");
            names[i] = scanner.next();

            System.out.print("Enter grade for " + names[i] + ": ");
            grades[i] = scanner.nextDouble();
        }

        // Analyze grades
        displayGradeAnalysis(names, grades);

        scanner.close();
    }

    public static void displayGradeAnalysis(String[] names, double[] grades) {
        System.out.println("\n=== Grade Analysis ===");

        // Display all students
        displayAllStudents(names, grades);

        // Calculate and display statistics
        double average = calculateAverage(grades);
        double highest = findHighest(grades);
        double lowest = findLowest(grades);

        System.out.println("\n=== Statistics ===");
        System.out.printf("Average grade: %.2f%n", average);
        System.out.printf("Highest grade: %.1f%n", highest);
        System.out.printf("Lowest grade: %.1f%n", lowest);

        // Find students with highest and lowest grades
        String[] topStudents = findStudentsWithGrade(names, grades, highest);
        String[] bottomStudents = findStudentsWithGrade(names, grades, lowest);

        System.out.println("\nTop performers:");
        for (String student : topStudents) {
            System.out.println("- " + student);
        }

        System.out.println("\nStudents needing improvement:");
        for (String student : bottomStudents) {
            System.out.println("- " + student);
        }

        // Grade distribution
        displayGradeDistribution(grades);
    }

    public static void displayAllStudents(String[] names, double[] grades) {
        System.out.printf("%-15s %-10s %-10s%n", "Name", "Grade", "Letter");
        System.out.println("----------------------------------------");

        for (int i = 0; i < names.length; i++) {
            String letterGrade = getLetterGrade(grades[i]);
            System.out.printf("%-15s %-10.1f %-10s%n", names[i], grades[i], letterGrade);
        }
    }

    public static double calculateAverage(double[] grades) {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.length;
    }

    public static double findHighest(double[] grades) {
        double highest = grades[0];
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    public static double findLowest(double[] grades) {
        double lowest = grades[0];
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }

    public static String[] findStudentsWithGrade(String[] names, double[] grades, double targetGrade) {
        int count = 0;
        for (double grade : grades) {
            if (grade == targetGrade) {
                count++;
            }
        }

        String[] students = new String[count];
        int index = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] == targetGrade) {
                students[index] = names[i];
                index++;
            }
        }

        return students;
    }

    public static String getLetterGrade(double grade) {
        if (grade >= 90) return "A";
        else if (grade >= 80) return "B";
        else if (grade >= 70) return "C";
        else if (grade >= 60) return "D";
        else return "F";
    }

    public static void displayGradeDistribution(double[] grades) {
        int[] distribution = new int[5]; // A, B, C, D, F

        for (double grade : grades) {
            String letter = getLetterGrade(grade);
            switch (letter) {
                case "A": distribution[0]++; break;
                case "B": distribution[1]++; break;
                case "C": distribution[2]++; break;
                case "D": distribution[3]++; break;
                case "F": distribution[4]++; break;
            }
        }

        System.out.println("\n=== Grade Distribution ===");
        System.out.println("A: " + distribution[0] + " students");
        System.out.println("B: " + distribution[1] + " students");
        System.out.println("C: " + distribution[2] + " students");
        System.out.println("D: " + distribution[3] + " students");
        System.out.println("F: " + distribution[4] + " students");
    }
}
