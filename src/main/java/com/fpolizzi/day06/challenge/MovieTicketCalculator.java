package com.fpolizzi.day06.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 30.10.25
 */
public class MovieTicketCalculator {
    public static void main(String[] args) {

        // Create Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Movie Ticket Calculator ===");

        // Prompt and read age (int)
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        // Prompt and read time (morning/afternoon/evening)
        System.out.print("Enter movie time (morning/afternoon/evening): ");
        String time = scanner.next();
        scanner.nextLine();

        // Compute base price by age
        double basePrice = 0;

        if (age < 12) {
            basePrice = 5.00;
        } else if (age >= 12 && age <= 64) {
            basePrice = 10.00;
        } else if (age >= 65) {
            basePrice = 7.00;
        }

        // Apply 20% discount for morning or 10% surcharge for evening
        double discount = 0;
        String discountType = "";

        if (time.equals("morning")) {
            discountType = "Morning discount:";
            discount = basePrice * 0.2;

        } else if (time.equals("evening")) {
            discountType = "Evening surcharge:";
            discount = basePrice * -0.1;
        }

        // Print base price, any discount/surcharge, and final price (2 decimals)
        System.out.printf("Base price: $%.2f%n", basePrice);
        System.out.printf("%s $%.2f%n", discountType, Math.abs(discount));
        System.out.printf("Final price: $%.2f%n", (basePrice - discount));
    }
}
