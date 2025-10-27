package com.fpolizzi.day03.practice;

import java.util.Scanner;

/**
 * Created by fpolizzi on 27.10.25
 */
public class SimpleMenuSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Menu System ===");

        System.out.println("1. Option 1");
        System.out.println("2. Option 2");
        System.out.println("3. Option 3");
        System.out.println("4. Option 4");
        System.out.println("5. Option 5");
        System.out.println("Choose an option: ");
        int choice = scanner.nextInt();

        System.out.println("You chose option: " + choice);

        scanner.close();
    }
}
