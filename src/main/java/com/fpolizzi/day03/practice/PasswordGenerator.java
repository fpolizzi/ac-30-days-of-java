package com.fpolizzi.day03.practice;

import java.util.Scanner;

/**
 * Created by fpolizzi on 27.10.25
 */
public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Password Generator ===");

        System.out.println("Length of the password, that should be generated: ");
        int passwordLength = scanner.nextInt();
        String password = "";

        for (int i = 0; i < passwordLength; i++) {
            int randomNumber = (int) (Math.random() * 10);
            password += String.valueOf(randomNumber);
        }

        System.out.println("Generated password: " + password);
    }
}
