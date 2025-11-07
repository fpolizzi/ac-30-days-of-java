package com.fpolizzi.day11.exercises;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by fpolizzi on 07.11.25
 */
public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int secretNumber = random.nextInt(100) + 1; // 1 to 100
        int attempts = 0;
        boolean guessed = false;

        System.out.println("=== Number Guessing Game ===");
        System.out.println("I'm thinking of a number between 1 and 100.");

        while (!guessed) {
            System.out.print("Enter your guess: ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess == secretNumber) {
                guessed = true;
                System.out.println("Congratulations! You guessed it in " + attempts + " attempts!");
            } else if (guess < secretNumber) {
                System.out.println("Too low! Try again.");
            } else {
                System.out.println("Too high! Try again.");
            }
        }

        scanner.close();
    }
}
