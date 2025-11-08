package com.fpolizzi.day12.exerciese;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by fpolizzi on 08.11.25
 */
public class NumberGuessingWithHints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("=== Number Guessing Game with Hints ===");

        do {
            int secretNumber = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessed = false;

            System.out.println("\nI'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts.");

            do {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess == secretNumber) {
                    guessed = true;
                    System.out.println("Congratulations! You guessed it in " + attempts + " attempts!");
                } else {
                    int remaining = maxAttempts - attempts;
                    System.out.println("Attempts remaining: " + remaining);

                    if (guess < secretNumber) {
                        System.out.println("Too low!");
                        if (secretNumber - guess <= 10) {
                            System.out.println("Hint: You're getting warmer!");
                        }
                    } else {
                        System.out.println("Too high!");
                        if (guess - secretNumber <= 10) {
                            System.out.println("Hint: You're getting warmer!");
                        }
                    }

                    if (remaining == 0) {
                        System.out.println("Game over! The number was " + secretNumber);
                    }
                }

            } while (!guessed && attempts < maxAttempts);

            System.out.print("Play again? (y/n): ");
            String playAgain = scanner.next();
            if (!playAgain.toLowerCase().startsWith("y")) {
                break;
            }
        } while (true);

        System.out.println("Thanks for playing!");
        scanner.close();
    }
}
