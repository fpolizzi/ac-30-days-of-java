package com.fpolizzi.day06.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 30.10.25
 */
public class AgeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Age Checker ===");
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        if (age < 0) {
            System.out.println("Invalid age! Age cannot be negative.");
        } else if (age < 13) {
            System.out.println("You are a child.");
        } else if (age < 20) {
            System.out.println("You are a teenager.");
        } else if (age < 65) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are a senior citizen.");
        }

        scanner.close();
    }
}
