package com.fpolizzi.day26.exercises;

import java.util.Arrays;

/**
 * Created by fpolizzi on 25.11.25
 */
public class ArrayRecursion {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("=== Array Operations with Recursion ===");
        System.out.println("Array: " + Arrays.toString(array));

        // Sum of array
        System.out.println("Sum: " + sumArray(array, 0));

        // Maximum element
        System.out.println("Maximum: " + findMax(array, 0));

        // Search for element
        int searchValue = 7;
        int index = searchElement(array, searchValue, 0);
        System.out.println("Index of " + searchValue + ": " + index);

        // Reverse array
        reverseArray(array, 0, array.length - 1);
        System.out.println("Reversed: " + Arrays.toString(array));

        // Check if array is sorted
        int[] sortedArray = {1, 2, 3, 4, 5};
        System.out.println("Is sorted: " + isSorted(sortedArray, 0));
    }

    // Recursive sum of array
    public static int sumArray(int[] array, int index) {
        // Base case
        if (index >= array.length) {
            return 0;
        }

        // Recursive case
        return array[index] + sumArray(array, index + 1);
    }

    // Recursive find maximum
    public static int findMax(int[] array, int index) {
        // Base case
        if (index >= array.length) {
            return Integer.MIN_VALUE;
        }

        // Recursive case
        int currentMax = findMax(array, index + 1);
        return Math.max(array[index], currentMax);
    }

    // Recursive search
    public static int searchElement(int[] array, int target, int index) {
        // Base case - not found
        if (index >= array.length) {
            return -1;
        }

        // Base case - found
        if (array[index] == target) {
            return index;
        }

        // Recursive case
        return searchElement(array, target, index + 1);
    }

    // Recursive reverse array
    public static void reverseArray(int[] array, int start, int end) {
        // Base case
        if (start >= end) {
            return;
        }

        // Swap elements
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;

        // Recursive case
        reverseArray(array, start + 1, end - 1);
    }

    // Recursive check if sorted
    public static boolean isSorted(int[] array, int index) {
        // Base case - reached end
        if (index >= array.length - 1) {
            return true;
        }

        // Check current pair
        if (array[index] > array[index + 1]) {
            return false;
        }

        // Recursive case
        return isSorted(array, index + 1);
    }
}
