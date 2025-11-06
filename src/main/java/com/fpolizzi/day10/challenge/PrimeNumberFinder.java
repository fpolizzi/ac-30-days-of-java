package com.fpolizzi.day10.challenge;

import java.util.Scanner;

/**
 * Created by fpolizzi on 06.11.25
 */
public class PrimeNumberFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Prime Number Finder ===");
        System.out.print("Enter start number: ");
        int start = scanner.nextInt();
        System.out.print("Enter end number: ");
        int end = scanner.nextInt();

        scanner.close();

        int totalCountOfPrimes = 0;
        StringBuilder primes = new StringBuilder();

        // DONE: Iterate from start to end, check primes with a for-loop up to sqrt(n)
        for (int number = start; number <= end; number++) {
            if (isPrime(number)) {

                primes.append(number).append(", ");
                totalCountOfPrimes++;
            }
        }

        // DONE: Print primes separated by comma, and total count at the end
        System.out.println("\nPrime numbers between " + start + " and " + end + ":");
        primes.deleteCharAt(primes.length() - 2);
        System.out.println(primes);
        System.out.println("\nTotal prime numbers found: " + totalCountOfPrimes);

    }

    // Function to check if a number is prime using square root optimization
    public static boolean isPrime ( int n){
        // Handle edge cases
        if (n <= 1) return false; // 0, 1, and negative numbers are not prime
        if (n == 2) return true;  // 2 is the only even prime number
        if (n % 2 == 0) return false; // No other even number is prime

        // Only check divisibility from 3 to sqrt(n) and skip even numbers
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false; // If divisible by any number, it's not prime
            }
        }

        return true; // If no divisors are found, it's prime
    }
}