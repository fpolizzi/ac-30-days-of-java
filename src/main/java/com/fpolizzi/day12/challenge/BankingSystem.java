package com.fpolizzi.day12.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 08.11.25
 */
public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double checking = 1000.0;
        double savings = 2000.0;
        double credit = 500.0;

        System.out.println("=== Banking System ===");

        // DONE: Use a do-while loop to show menu and process actions until Exit
        int choice;
        do {
            System.out.printf("Checking: $%.2f%n", checking);
            System.out.printf("Savings: $%.2f%n", savings);
            System.out.printf("Credit: $%.2f%n", credit);
            System.out.println();

            System.out.println("1. Check Balance");
            System.out.println("2. Transfer");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Exit");
            System.out.println();

            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

        // DONE: Implement Check Balance, Transfer, Deposit, Withdraw
            switch (choice) {
                case 1:
                    System.out.println("=== Account Balances ===");
                    System.out.printf("Checking: $%.2f%n", checking);
                    System.out.printf("Savings: $%.2f%n", savings);
                    System.out.printf("Credit: $%.2f%n", credit);
                    break;
                case 2:
                    System.out.print("From account (1=Checking, 2=Savings, 3=Credit): ");
                    int fromAccount = scanner.nextInt();
                    System.out.print("To account (1=Checking, 2=Savings, 3=Credit): ");
                    int toAccount = scanner.nextInt();
                    if (fromAccount < 1 || fromAccount > 3 || toAccount < 1 || toAccount > 3) {
                        System.out.println("Invalid account selection!");
                        break;
                    }
                    System.out.print("Enter amount: $");
                    double transferAmount = scanner.nextDouble();
                    if (transferAmount <= 0) {
                        System.out.println("Invalid amount!");
                        break;
                    }
                    double sourceBalance = (fromAccount == 1 ? checking : fromAccount == 2 ? savings : credit);
                    if (transferAmount > sourceBalance) {
                        System.out.println("Insufficient funds!");
                        break;
                    }
                    if (fromAccount == 1) checking -= transferAmount; else if (fromAccount == 2) savings -= transferAmount; else credit -= transferAmount;
                    if (toAccount == 1) checking += transferAmount; else if (toAccount == 2) savings += transferAmount; else credit += transferAmount;
                    System.out.println("Transfer successful!");
                    break;
                case 3:
                    System.out.print("Account (1=Checking, 2=Savings, 3=Credit): ");
                    int depositAccount = scanner.nextInt();
                    System.out.print("Enter amount: $");
                    double depositAmount = scanner.nextDouble();
                    if (depositAmount <= 0) {
                        System.out.println("Invalid amount!");
                        break;
                    }
                    if (depositAccount == 1) checking += depositAmount; else if (depositAccount == 2) savings += depositAmount; else if (depositAccount == 3) credit += depositAmount; else System.out.println("Invalid account!");
                    System.out.println("Deposit successful!");
                    break;
                case 4:
                    System.out.print("Account (1=Checking, 2=Savings, 3=Credit): ");
                    int withdrawAccount = scanner.nextInt();
                    System.out.print("Enter amount: $");
                    double withdrawAmount = scanner.nextDouble();
                    if (withdrawAmount <= 0) {
                        System.out.println("Invalid amount!");
                        break;
                    }

        // DONE: Validate positive amounts and sufficient funds
                    double currentBalance = (withdrawAccount == 1 ? checking : withdrawAccount == 2 ? savings : withdrawAccount == 3 ? credit : -1);
                    if (currentBalance < 0) { System.out.println("Invalid account!"); break; }
                    if (withdrawAmount > currentBalance) {
                        System.out.println("Insufficient funds!");
                        break;
                    }
                    if (withdrawAccount == 1) checking -= withdrawAmount; else if (withdrawAccount == 2) savings -= withdrawAmount; else credit -= withdrawAmount;
                    System.out.println("Withdrawal successful!");
                    break;
                case 5:
                    System.out.println("Thank you for using our banking system!");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1-5.");
                    break;
            }
            System.out.println();
        } while (choice != 5);

        scanner.close();
    }
}
