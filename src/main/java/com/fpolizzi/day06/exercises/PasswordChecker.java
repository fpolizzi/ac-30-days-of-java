package com.fpolizzi.day06.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 30.10.25
 */
public class PasswordChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Checker ===");
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.println("\n=== Password Analysis ===");

        // Check length
        if (password.length() < 8) {
            System.out.println("❌ Password is too short (minimum 8 characters)");
        } else {
            System.out.println("✅ Password length is good");
        }

        // Check if contains uppercase
        if (password.equals(password.toLowerCase())) {
            System.out.println("❌ Password should contain uppercase letters");
        } else {
            System.out.println("✅ Password contains uppercase letters");
        }

        // Check if contains lowercase
        if (password.equals(password.toUpperCase())) {
            System.out.println("❌ Password should contain lowercase letters");
        } else {
            System.out.println("✅ Password contains lowercase letters");
        }

        // Check if contains numbers
        if (password.matches(".*\\d.*")) {
            System.out.println("✅ Password contains numbers");
        } else {
            System.out.println("❌ Password should contain numbers");
        }

        scanner.close();
    }
}
