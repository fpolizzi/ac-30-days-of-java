package com.fpolizzi.day20.exercises;

import java.util.*;

/**
 * Created by fpolizzi on 17.11.25
 */
public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Array Manipulator ===");
        System.out.print("Enter array size: ");
        int size = scanner.nextInt();

        int[] array = new int[size];

        // Initialize array
        System.out.println("Enter " + size + " numbers:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Display array");
            System.out.println("2. Sort array");
            System.out.println("3. Reverse array");
            System.out.println("4. Remove duplicates");
            System.out.println("5. Rotate array");
            System.out.println("6. Check if sorted");
            System.out.println("7. Find element");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayArray(array);
                    break;
                case 2:
                    Arrays.sort(array);
                    System.out.println("Array sorted!");
                    break;
                case 3:
                    ArrayUtils.reverse(array);
                    System.out.println("Array reversed!");
                    break;
                case 4:
                    array = ArrayUtils.removeDuplicates(array);
                    System.out.println("Duplicates removed!");
                    break;
                case 5:
                    System.out.print("Enter rotation positions: ");
                    int positions = scanner.nextInt();
                    ArrayUtils.rotate(array, positions);
                    System.out.println("Array rotated!");
                    break;
                case 6:
                    boolean sorted = ArrayUtils.isSorted(array);
                    System.out.println("Array is sorted: " + sorted);
                    break;
                case 7:
                    System.out.print("Enter element to find: ");
                    int target = scanner.nextInt();
                    int index = Arrays.binarySearch(array, target);
                    if (index >= 0) {
                        System.out.println("Found at index: " + index);
                    } else {
                        System.out.println("Element not found");
                    }
                    break;
                case 8:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void displayArray(int[] array) {
        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
