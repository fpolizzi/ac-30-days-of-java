package com.fpolizzi.day23.exercises;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by fpolizzi on 21.11.25
 */
public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Array Manipulator ===");

        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            performArrayOperation(array, choice);
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n1. Display array");
        System.out.println("2. Find maximum and minimum");
        System.out.println("3. Calculate sum and average");
        System.out.println("4. Reverse array");
        System.out.println("5. Sort array");
        System.out.println("6. Find element");
        System.out.println("7. Count occurrences");
        System.out.println("8. Remove duplicates");
        System.out.println("0. Exit");
    }

    public static void performArrayOperation(int[] array, int choice) {
        switch (choice) {
            case 1:
                displayArray(array);
                break;
            case 2:
                findMinMax(array);
                break;
            case 3:
                calculateSumAverage(array);
                break;
            case 4:
                reverseArray(array);
                System.out.println("Array reversed!");
                break;
            case 5:
                Arrays.sort(array);
                System.out.println("Array sorted!");
                break;
            case 6:
                findElement(array);
                break;
            case 7:
                countOccurrences(array);
                break;
            case 8:
                removeDuplicates(array);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void displayArray(int[] array) {
        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void findMinMax(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int num : array) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
    }

    public static void calculateSumAverage(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }

        double average = (double) sum / array.length;

        System.out.println("Sum: " + sum);
        System.out.printf("Average: %.2f%n", average);
    }

    public static void reverseArray(int[] array) {
        int start = 0;
        int end = array.length - 1;

        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    public static void findElement(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter element to find: ");
        int target = scanner.nextInt();

        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }

    public static void countOccurrences(int[] array) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter element to count: ");
        int target = scanner.nextInt();

        int count = 0;
        for (int num : array) {
            if (num == target) {
                count++;
            }
        }

        System.out.println("Occurrences of " + target + ": " + count);
    }

    public static void removeDuplicates(int[] array) {
        // This is a simplified version - in practice, you'd need a different approach
        System.out.println("Note: Removing duplicates would require creating a new array");
        System.out.println("Current array length: " + array.length);
    }
}
