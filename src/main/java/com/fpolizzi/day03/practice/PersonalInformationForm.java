package com.fpolizzi.day03.practice;

import java.util.Scanner;

/**
 * Created by fpolizzi on 27.10.25
 */
public class PersonalInformationForm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Personal Information Form ===");

        System.out.print("Enter your first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter your last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter your age: ");
        int age = scanner.nextInt();

        System.out.print("Enter your email address: ");
        scanner.nextLine(); // Consume the leftover newline
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phoneNumber = scanner.nextLine();

        // Display collected information
        System.out.println("\n=== Your Information ===");
        System.out.println("Full Name: " + firstName + " " + lastName);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("Phone number: " + phoneNumber);

        scanner.close();
    }
}
