package com.fpolizzi.day20.exercises;

import java.util.*;

/**
 * Created by fpolizzi on 17.11.25
 */
class ArrayUtils {
    // Find maximum value
    public static int findMax(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Find minimum value
    public static int findMin(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // Calculate average
    public static double calculateAverage(int[] array) {
        if (array.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }

    // Reverse array
    public static void reverse(int[] array) {
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

    // Remove duplicates
    public static int[] removeDuplicates(int[] array) {
        if (array.length <= 1) {
            return array;
        }

        Arrays.sort(array);
        int uniqueCount = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                uniqueCount++;
            }
        }

        int[] result = new int[uniqueCount];
        result[0] = array[0];
        int index = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] != array[i - 1]) {
                result[index] = array[i];
                index++;
            }
        }

        return result;
    }

    // Rotate array
    public static void rotate(int[] array, int positions) {
        int n = array.length;
        positions = positions % n;

        if (positions < 0) {
            positions += n;
        }

        reverse(array, 0, n - 1);
        reverse(array, 0, positions - 1);
        reverse(array, positions, n - 1);
    }

    private static void reverse(int[] array, int start, int end) {
        while (start < end) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            start++;
            end--;
        }
    }

    // Check if array is sorted
    public static boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    // Find second largest
    public static int findSecondLargest(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("Array must have at least 2 elements");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }

        return secondLargest;
    }
}
