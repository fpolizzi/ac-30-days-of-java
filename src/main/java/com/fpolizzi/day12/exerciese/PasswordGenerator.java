package com.fpolizzi.day12.exerciese;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by fpolizzi on 08.11.25
 */
public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== Password Generator ===");

        do {
            System.out.print("Enter password length (8-20): ");
            int length = scanner.nextInt();

            if (length < 8 || length > 20) {
                System.out.println("Invalid length! Please enter 8-20.");
                continue;
            }

            System.out.print("Include uppercase letters? (y/n): ");
            boolean includeUpper = scanner.next().toLowerCase().startsWith("y");

            System.out.print("Include numbers? (y/n): ");
            boolean includeNumbers = scanner.next().toLowerCase().startsWith("y");

            System.out.print("Include special characters? (y/n): ");
            boolean includeSpecial = scanner.next().toLowerCase().startsWith("y");

            String password = generatePassword(length, includeUpper, includeNumbers, includeSpecial);
            System.out.println("Generated password: " + password);

            System.out.print("Generate another password? (y/n): ");
            String again = scanner.next();
            if (!again.toLowerCase().startsWith("y")) {
                break;
            }
        } while (true);

        System.out.println("Thank you for using Password Generator!");
        scanner.close();
    }

    public static String generatePassword(int length, boolean upper, boolean numbers, boolean special) {
        String chars = "abcdefghijklmnopqrstuvwxyz";
        if (upper) chars += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (numbers) chars += "0123456789";
        if (special) chars += "!@#$%^&*()_+-=[]{}|;:,.<>?";

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            password.append(chars.charAt(index));
        }

        return password.toString();
    }
}
