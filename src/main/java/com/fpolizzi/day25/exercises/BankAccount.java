package com.fpolizzi.day25.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 24.11.25
 */
public class BankAccount {

    // Static variables
    private static int totalAccounts = 0;
    private static double totalBalance = 0.0;
    private static final double INTEREST_RATE = 0.05; // 5%

    // Instance variables
    private int accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountHolder, double initialBalance) {
        this.accountNumber = ++totalAccounts;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        totalBalance += initialBalance;

        System.out.println("Account created for " + accountHolder +
                " with number " + accountNumber);
    }

    // Instance methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            totalBalance += amount;
            System.out.println("Deposited $" + amount + " to account " + accountNumber);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            totalBalance -= amount;
            System.out.println("Withdrew $" + amount + " from account " + accountNumber);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds");
        }
    }

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.printf("Balance: $%.2f%n", balance);
    }

    // Static methods
    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static double getTotalBalance() {
        return totalBalance;
    }

    public static double calculateInterest(double amount) {
        return amount * INTEREST_RATE;
    }

    public static void displayBankStats() {
        System.out.println("\n=== Bank Statistics ===");
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.printf("Total Balance: $%.2f%n", totalBalance);
        System.out.printf("Interest Rate: %.1f%%%n", INTEREST_RATE * 100);

        if (totalAccounts > 0) {
            double averageBalance = totalBalance / totalAccounts;
            System.out.printf("Average Balance: $%.2f%n", averageBalance);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Bank Account System ===");

        // Create accounts
        BankAccount account1 = new BankAccount("Alice", 1000.0);
        BankAccount account2 = new BankAccount("Bob", 500.0);
        BankAccount account3 = new BankAccount("Charlie", 750.0);

        // Perform transactions
        account1.deposit(200.0);
        account2.withdraw(100.0);
        account3.deposit(300.0);

        // Display account information
        System.out.println("\n=== Account Information ===");
        account1.displayInfo();
        System.out.println();
        account2.displayInfo();
        System.out.println();
        account3.displayInfo();

        // Display bank statistics
        displayBankStats();

        // Calculate interest for each account
        System.out.println("\n=== Interest Calculation ===");
        System.out.printf("Interest for Alice: $%.2f%n",
                calculateInterest(account1.balance));
        System.out.printf("Interest for Bob: $%.2f%n",
                calculateInterest(account2.balance));
        System.out.printf("Interest for Charlie: $%.2f%n",
                calculateInterest(account3.balance));

        scanner.close();
    }
}
