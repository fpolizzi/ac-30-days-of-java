package com.fpolizzi.day15.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 11.11.25
 */
public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Inventory Management System ===");
        System.out.print("Enter number of products: ");
        int numProducts = scanner.nextInt();

        // DONE: Create arrays for names, prices, quantities
        String[] itemNames = new String[numProducts];
        double[] prices = new double[numProducts];
        int[] quantities = new int[numProducts];

        int mostExpensiveItem = 0;
        int mostCheapestItem = 0;

        // DONE: Input product details using loops
        for (int i = 0; i < numProducts; i++) {
            System.out.println("\nItem " + (i + 1) + ":");
            System.out.print("Enter item name: ");
            scanner.nextLine();
            itemNames[i] = scanner.nextLine();
            System.out.print("Enter price: $");
            prices[i] = scanner.nextDouble();

            if (prices[i] < prices[mostCheapestItem]) {
                mostCheapestItem = i;
            }
            if (prices[i] > prices[mostExpensiveItem]) {
                mostExpensiveItem = i;
            }

            System.out.print("Enter quantity: ");
            quantities[i] = scanner.nextInt();
        }

        // DONE: Display table with totals, compute total inventory value
        System.out.println("\n=== Inventory Report ===");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Item", "Price", "Quantity", "Value");
        System.out.println("------------------------------------------------");

        double totalCost = 0;
        for (int i = 0; i < numProducts; i++) {
            double itemTotal = prices[i] * quantities[i];
            totalCost += itemTotal;
            System.out.printf("%-20s $%-9.2f %-10d $%-9.2f%n", itemNames[i], prices[i], quantities[i], itemTotal);
        }

        System.out.println("------------------------------------------------");
        System.out.printf("Total Inventory Value: $%.2f%n", totalCost);
        System.out.println();

        // Done: Find most expensive and cheapest products
        System.out.printf("Most Expensive: %s ($%.2f)%n", itemNames[mostExpensiveItem], prices[mostExpensiveItem]);
        System.out.printf("Cheapest: %s $(%.2f)%n", itemNames[mostCheapestItem], prices[mostCheapestItem]);

        // DONE: Search product by name (case-insensitive)
        int productNumber = 0;
        System.out.println();
        System.out.print("Search for product: ");
        scanner.nextLine();

        String searchProductName = scanner.nextLine();

        for (int i = 0; i < numProducts; i++) {
            if (itemNames[i].equalsIgnoreCase(searchProductName)) {
                productNumber = i;
            }
        }

        System.out.printf("Found: %s - $%.2f (%d in stock)%n", itemNames[productNumber], prices[productNumber], quantities[productNumber]);

        scanner.close();
    }
}
