package com.fpolizzi.day09.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 05.11.25
 */
public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Vending Machine ===");
        System.out.println("1. Chips ($1.50)");
        System.out.println("2. Soda ($2.00)");
        System.out.println("3. Candy ($0.75)");
        System.out.println("4. Water ($1.00)");
        System.out.println("5. Coffee ($2.50)");
        System.out.println();

        // DONE: Read selection (1-5)
        System.out.print("Select item (1-5): ");
        int selection = scanner.nextInt();

        String itemName = "";
        double itemPrice = 0.0;

        // DONE: Map selection to itemName and itemPrice using switch
        switch (selection) {
            case 1:
                itemName = "Chips";
                itemPrice = 1.50;
                break;
            case 2:
                itemName = "Soda";
                itemPrice = 2.00;
                break;
            case 3:
                itemName = "Candy";
                itemPrice = 0.75;
                break;
            case 4:
                itemName = "Water";
                itemPrice = 1.00;
                break;
            case 5:
                itemName = "Coffee";
                itemPrice = 2.50;
                break;
            default:
                System.out.println("Invalid selection!");
                scanner.close();
                return;
        }

        // DONE: Read payment ($1, $2, $5, $10) and compute change using switch
        System.out.print("Enter payment ($1, $2, $5, $10): ");
        int payment = scanner.nextInt();

        double change = 0.0;
        boolean validPayment = true;

        switch (payment) {
            case 1:
                change = 1.00 - itemPrice;
                break;
            case 2:
                change = 2.00 - itemPrice;
                break;
            case 5:
                change = 5.00 - itemPrice;
                break;
            case 10:
                change = 10.00 - itemPrice;
                break;
            default:
                System.out.println("Invalid payment amount!");
                validPayment = false;
                break;
        }

        // DONE: Validate and print result or errors
        if (validPayment) {
            if (change >= 0) {
                System.out.println("Dispensing: " + itemName);
                if (change > 0) {
                    System.out.printf("Change: $%.2f%n", change);
                }
                System.out.println("Thank you!");
            } else {
                System.out.println("Insufficient payment!");
                System.out.printf("Need $%.2f more%n", Math.abs(change));
            }
        }

        scanner.close();
    }
}
