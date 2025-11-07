package com.fpolizzi.day11.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 07.11.25
 */
public class ATMMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = 1000.0;
        boolean running = true;

        System.out.println("=== ATM Machine ===");

        // DONE: Build a while loop for the menu
        while (running) {
            System.out.printf("Current Balance: $%.2f%n", balance);
            System.out.println();
            System.out.println("\n1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit\n");
            System.out.println();

            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("Your balance is: $%.2f%n", balance);
                    break;
                // DONE: Validate deposit/withdraw amounts and sufficient funds
                case 2:
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();

                    while (depositAmount <= 0) {
                        System.out.println("Invalid amount! Please enter a positive value.");
                        System.out.print("Enter amount to deposit: $");
                        depositAmount = scanner.nextDouble();
                    }

                    balance += depositAmount;
                    System.out.printf("New balance: $%.2f%n", balance);
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();

                    while (withdrawAmount <= 0) {
                        System.out.println("Invalid amount! Please enter a positive value.");
                        System.out.print("Enter amount to withdraw: $");

                        withdrawAmount = scanner.nextDouble();
                    }

                    while (withdrawAmount > balance) {
                        System.out.println("Insufficient funds! Your balance is $" + balance);
                        System.out.print("Enter amount to withdraw: $");

                        withdrawAmount = scanner.nextDouble();
                    }
                    // DONE: Update balance and print results
                    balance -= withdrawAmount;
                    System.out.printf("New balance: $%.2f%n", balance);
                    break;
                case 4:
                    running = false;
                    System.out.println("Thank you for using our ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1-4.");
                    break;
            }
        }

        scanner.close();
    }
}
