package com.fpolizzi.day09.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 05.11.25
 */
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Grade Calculator ===");
        System.out.print("Enter score (0-100): ");
        int score = scanner.nextInt();

        String grade;
        String message;

        // Calculate grade using switch
        switch (score / 10) {
            case 10:
            case 9:
                grade = "A";
                message = "Excellent!";
                break;
            case 8:
                grade = "B";
                message = "Good job!";
                break;
            case 7:
                grade = "C";
                message = "Satisfactory";
                break;
            case 6:
                grade = "D";
                message = "Needs improvement";
                break;
            case 5:
            case 4:
            case 3:
            case 2:
            case 1:
            case 0:
                grade = "F";
                message = "Failed";
                break;
            default:
                grade = "Invalid";
                message = "Score out of range";
                break;
        }

        System.out.println("Score: " + score);
        System.out.println("Grade: " + grade);
        System.out.println("Message: " + message);

        scanner.close();
    }
}
