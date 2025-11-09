package com.fpolizzi.day13.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 09.11.25
 */
public class DiamondPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Diamond Pattern Generator ===");
        System.out.print("Enter diamond height (odd number): ");
        int height = scanner.nextInt();

        if (height % 2 == 0) {
            height++; // Make it odd
        }

        int mid = height / 2 + 1;

        // Upper half
        for (int i = 1; i <= mid; i++) {
            for (int j = 1; j <= mid - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half
        for (int i = mid - 1; i >= 1; i--) {
            for (int j = 1; j <= mid - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        scanner.close();
    }
}
