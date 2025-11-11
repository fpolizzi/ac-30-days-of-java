package com.fpolizzi.day15.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 11.11.25
 */
public class ShoppingCart {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Shopping Cart ===");
        System.out.print("Enter number of items: ");
        int numItems = scanner.nextInt();

        String[] itemNames = new String[numItems];
        double[] prices = new double[numItems];
        int[] quantities = new int[numItems];

        for (int i = 0; i < numItems; i++) {
            System.out.println("\nItem " + (i + 1) + ":");
            System.out.print("Enter item name: ");
            scanner.nextLine();
            itemNames[i] = scanner.nextLine();
            System.out.print("Enter price: $");
            prices[i] = scanner.nextDouble();
            System.out.print("Enter quantity: ");
            quantities[i] = scanner.nextInt();
        }

        System.out.println("\n=== Shopping Cart ===");
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Item", "Price", "Quantity", "Total");
        System.out.println("------------------------------------------------");

        double totalCost = 0;
        for (int i = 0; i < numItems; i++) {
            double itemTotal = prices[i] * quantities[i];
            totalCost += itemTotal;
            System.out.printf("%-20s $%-9.2f %-10d $%-9.2f%n", itemNames[i], prices[i], quantities[i], itemTotal);
        }

        System.out.println("------------------------------------------------");
        System.out.printf("Total Cost: $%.2f%n", totalCost);

        scanner.close();
    }
}
