package com.fpolizzi.day20.exercises;

import java.util.*;

/**
 * Created by fpolizzi on 17.11.25
 */
public class ArrayStatisticsCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Array Statistics Calculator ===");
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Calculate statistics
        System.out.println("\n=== Statistics ===");
        System.out.println("Maximum: " + ArrayUtils.findMax(numbers));
        System.out.println("Minimum: " + ArrayUtils.findMin(numbers));
        System.out.printf("Average: %.2f%n", ArrayUtils.calculateAverage(numbers));
        System.out.println("Second Largest: " + ArrayUtils.findSecondLargest(numbers));

        // Mode calculation
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : numbers) {
            frequency.put(num, frequency.getOrDefault(num, 0) + 1);
        }

        int mode = frequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(0);

        System.out.println("Mode: " + mode);

        // Median calculation
        Arrays.sort(numbers);
        double median;
        if (n % 2 == 0) {
            median = (numbers[n/2 - 1] + numbers[n/2]) / 2.0;
        } else {
            median = numbers[n/2];
        }
        System.out.println("Median: " + median);

        scanner.close();
    }
}
