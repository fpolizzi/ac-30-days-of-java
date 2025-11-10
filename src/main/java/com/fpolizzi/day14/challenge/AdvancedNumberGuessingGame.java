package com.fpolizzi.day14.challenge;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by fpolizzi on 10.11.25
 */
public class AdvancedNumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int totalGames = 0;
        int totalAttempts = 0;
        int bestScore = Integer.MAX_VALUE;
        boolean playing = true;

        System.out.println("=== Advanced Number Guessing Game ===");

        do {
            System.out.println("\n1. Easy (1-50, 10 attempts)");
            System.out.println("2. Medium (1-100, 8 attempts)");
            System.out.println("3. Hard (1-200, 6 attempts)");
            System.out.println("4. Expert (1-500, 5 attempts)");
            System.out.println("5. Statistics");
            System.out.println("6. Exit");
            System.out.print("Choose (1-6): ");
            int choice = scanner.nextInt();

            if (choice == 6) break;
            if (choice == 5) {
                displayStatistics(totalGames, totalAttempts, bestScore);
                continue;
            }
            if (choice < 1 || choice > 6) {
                System.out.println("Invalid choice");
                continue;
            }

            int maxNumber = 0, maxAttempts = 0;
            String name = "";
            switch (choice) {
                case 1:
                    maxNumber = 50;
                    maxAttempts = 10;
                    name = "Easy";
                    break;
                case 2:
                    maxNumber = 100;
                    maxAttempts = 8;
                    name = "Medium";
                    break;
                case 3:
                    maxNumber = 200;
                    maxAttempts = 6;
                    name = "Hard";
                    break;
                case 4:
                    maxNumber = 500;
                    maxAttempts = 5;
                    name = "Expert";
                    break;
            }

            int secret = random.nextInt(maxNumber) + 1;
            int attempts = 0, prev = -1;
            boolean won = false;
            System.out.println("\n=== " + name + " ===");
            System.out.println("Guess 1-" + maxNumber + " in " + maxAttempts + " attempts");

            while (attempts < maxAttempts && !won) {
                System.out.print("Attempt " + (attempts + 1) + ": ");
                if (!scanner.hasNextInt()) {
                    System.out.println("Enter a number");
                    scanner.next();
                    continue;
                }
                int guess = scanner.nextInt();
                if (guess < 1 || guess > maxNumber) {
                    System.out.println("Out of range");
                    continue;
                }
                attempts++;
                if (guess == secret) {
                    won = true;
                    break;
                }
                String fb = getFeedback(guess, secret, attempts, maxAttempts, prev);
                System.out.println(fb);
                prev = guess;
            }

            totalGames++;
            totalAttempts += attempts;
            if (won) {
                int score = calculateScore(attempts, maxAttempts, choice);
                System.out.println("Win! Score: " + score);
                if (score < bestScore) {
                    bestScore = score;
                    System.out.println("New best score!");
                }
            } else {
                System.out.println("Lost. Number was: " + secret);
            }

            System.out.print("Play again? (y/n): ");
            playing = scanner.next().toLowerCase().startsWith("y");
        } while (playing);

        displayStatistics(totalGames, totalAttempts, bestScore);
        scanner.close();
    }

    static void displayStatistics(int games, int attempts, int best) {
        if (games == 0) {
            System.out.println("No games yet");
            return;
        }
        System.out.println("Games: " + games);
        System.out.println("Attempts: " + attempts);
        System.out.printf("Average attempts: %.1f%n", (double) attempts / games);
        System.out.println("Best score: " + (best == Integer.MAX_VALUE ? "N/A" : best));
    }

    static int calculateScore(int attempts, int maxAttempts, int diff) {
        int base = 100 * diff;
        int bonus = (maxAttempts - attempts + 1) * 10;
        int mult = diff * 2;
        return (base + bonus) * mult;
    }

    static String getFeedback(int guess, int secret, int attempts, int maxAttempts, int prev) {
        StringBuilder fb = new StringBuilder();
        fb.append(guess < secret ? "Too low!" : "Too high!");
        int d = Math.abs(guess - secret);
        if (d <= 5) fb.append(" 🔥 Very close!");
        else if (d <= 15) fb.append(" ⚡ Getting warmer!");
        else if (d <= 30) fb.append(" 🌡️ Getting colder!");
        else fb.append(" ❄️ Very cold!");
        if (prev != -1) {
            int pd = Math.abs(prev - secret);
            if (d < pd) fb.append(" 📈 Getting closer!");
            else if (d > pd) fb.append(" 📉 Moving away!");
        }
        if (attempts == maxAttempts - 1) fb.append(" ⚠️ Last attempt!");
        else if (attempts >= maxAttempts / 2) fb.append(" ⏰ Time is running out!");
        return fb.toString();
    }
}
