package com.fpolizzi.day05.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 29.10.25
 */
public class PhoneNumberValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Phone Number Formatter ===");
        System.out.print("Enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println(phoneNumber);

        // Remove all non-digit characters
        String digitsOnly = phoneNumber.replaceAll("[^0-9]", "");

        // Check if it's a valid 10-digit number
        if (digitsOnly.length() == 10) {
            // Format as (XXX) XXX-XXXX
            String formatted = "(" + digitsOnly.substring(0, 3) + ") " +
                    digitsOnly.substring(3, 6) + "-" +
                    digitsOnly.substring(6);
            System.out.println("Formatted: " + formatted);
        } else {
            System.out.println("Error: Invalid phone number. Must be 10 digits.");
        }
        
        scanner.close();
    }
}
