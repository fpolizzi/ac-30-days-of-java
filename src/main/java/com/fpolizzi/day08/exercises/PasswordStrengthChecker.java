package com.fpolizzi.day08.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 04.11.25
 */
public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Strength Checker ===");
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        // Check password criteria
        boolean hasLength = password.length() >= 8;
        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean hasNumbers = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*");

        // Strength logic
        boolean isWeak = hasLength && (hasUppercase || hasLowercase) && !hasNumbers && !hasSpecial;
        boolean isMedium = hasLength && hasUppercase && hasLowercase && hasNumbers && !hasSpecial;
        boolean isStrong = hasLength && hasUppercase && hasLowercase && hasNumbers && hasSpecial;
        boolean isInvalid = !hasLength;

        System.out.println("\n=== Password Analysis ===");
        System.out.println("Length (8+ chars): " + (hasLength ? "✅" : "❌"));
        System.out.println("Uppercase letters: " + (hasUppercase ? "✅" : "❌"));
        System.out.println("Lowercase letters: " + (hasLowercase ? "✅" : "❌"));
        System.out.println("Numbers: " + (hasNumbers ? "✅" : "❌"));
        System.out.println("Special characters: " + (hasSpecial ? "✅" : "❌"));

        System.out.println("\n=== Strength Rating ===");
        if (isInvalid) {
            System.out.println("❌ INVALID: Password too short!");
        } else if (isStrong) {
            System.out.println("🟢 STRONG: Excellent password!");
        } else if (isMedium) {
            System.out.println("🟡 MEDIUM: Good password, but could be stronger!");
        } else if (isWeak) {
            System.out.println("🔴 WEAK: Password needs improvement!");
        } else {
            System.out.println("🔴 VERY WEAK: Password needs significant improvement!");
        }

        scanner.close();
    }
}
