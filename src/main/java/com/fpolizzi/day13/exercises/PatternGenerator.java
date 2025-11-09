package com.fpolizzi.day13.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 09.11.25
 */
public class PatternGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Pattern Generator ===");
        System.out.print("Enter pattern size: ");
        int size = scanner.nextInt();

        System.out.println("\n1. Square Pattern");
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n2. Right Triangle Pattern");
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("\n3. Number Triangle Pattern");
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

        System.out.println("\n4. Character Triangle Pattern");
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print((char)('A' + j - 1) + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
