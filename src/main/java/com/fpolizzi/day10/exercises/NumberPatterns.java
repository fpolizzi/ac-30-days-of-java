package com.fpolizzi.day10.exercises;

/**
 * Created by fpolizzi on 06.11.25
 */
public class NumberPatterns {
    public static void main(String[] args) {
        System.out.println("=== Number Patterns ===");

        // Pattern 1: Counting up
        System.out.println("Pattern 1: Counting up");
        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Pattern 2: Even numbers
        System.out.println("Pattern 2: Even numbers");
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Pattern 3: Powers of 2
        System.out.println("Pattern 3: Powers of 2");
        for (int i = 1; i <= 10; i++) {
            int power = (int) Math.pow(2, i);
            System.out.print(power + " ");
        }
        System.out.println();

        // Pattern 4: Multiplication table
        System.out.println("Pattern 4: 5 times table");
        for (int i = 1; i <= 10; i++) {
            System.out.println("5 × " + i + " = " + (5 * i));
        }
    }
}
