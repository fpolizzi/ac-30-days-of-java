package com.fpolizzi.day19.exercises;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by fpolizzi on 16.11.25
 */
public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Generator ===");
        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        String password = generatePassword(length);
        System.out.println("Generated password: " + password);

        // Check password strength
        checkPasswordStrength(password);
    }

    public static String generatePassword(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            password.append(chars.charAt(random.nextInt(chars.length())));
        }

        return password.toString();
    }

    public static void checkPasswordStrength(String password) {
        int score = 0;

        if (password.length() >= 8) score++;
        if (password.matches(".*[A-Z].*")) score++;
        if (password.matches(".*[a-z].*")) score++;
        if (password.matches(".*\\d.*")) score++;
        if (password.matches(".*[!@#$%^&*].*")) score++;

        System.out.println("Password strength: " + score + "/5");

        if (score >= 4) {
            System.out.println("Strong password!");
        } else if (score >= 3) {
            System.out.println("Medium strength password.");
        } else {
            System.out.println("Weak password. Consider making it stronger.");
        }
    }
}
