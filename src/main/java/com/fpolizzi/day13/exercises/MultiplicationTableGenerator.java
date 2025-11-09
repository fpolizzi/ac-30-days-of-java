package com.fpolizzi.day13.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 09.11.25
 */
public class MultiplicationTableGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Multiplication Table Generator ===");
        System.out.print("Enter table size: ");
        int size = scanner.nextInt();

        // Print header
        System.out.print("   ");
        for (int i = 1; i <= size; i++) {
            System.out.printf("%4d", i);
        }
        System.out.println();

        // Print separator line
        System.out.print("   ");
        for (int i = 1; i <= size; i++) {
            System.out.print("----");
        }
        System.out.println();

        // Print multiplication table
        for (int i = 1; i <= size; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= size; j++) {
                System.out.printf("%4d", i * j);
            }
            System.out.println();
        }

        scanner.close();
    }
}
