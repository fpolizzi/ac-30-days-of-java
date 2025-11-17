package com.fpolizzi.day20.exercises;

import java.util.*;

/**
 * Created by fpolizzi on 17.11.25
 */
public class AdvancedArrayUtils {
    // Merge two sorted arrays
    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < arr1.length) {
            result[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    // Find missing number in a sequence
    public static int findMissingNumber(int[] array) {
        int n = array.length + 1;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : array) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    // Find a duplicate number
    public static int findDuplicate(int[] array) {
        Set<Integer> seen = new HashSet<>();

        for (int num : array) {
            if (seen.contains(num)) {
                return num;
            }
            seen.add(num);
        }

        return -1; // No duplicate found
    }

    // Move zeros to end
    public static void moveZerosToEnd(int[] array) {
        int nonZeroIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                array[nonZeroIndex++] = array[i];
            }
        }

        while (nonZeroIndex < array.length) {
            array[nonZeroIndex++] = 0;
        }
    }

    // Find peak element
    public static int findPeakElement(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                return i;
            }
        }

        // Check boundaries
        if (array.length > 1) {
            if (array[0] > array[1]) return 0;
            if (array[array.length - 1] > array[array.length - 2]) {
                return array.length - 1;
            }
        }

        return 0; // Single element or no peak
    }
}
