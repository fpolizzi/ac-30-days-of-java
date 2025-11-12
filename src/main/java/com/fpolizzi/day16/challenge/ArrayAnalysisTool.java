package com.fpolizzi.day16.challenge;

import java.util.*;

/**
 * Created by fpolizzi on 12.11.25
 */
public class ArrayAnalysisTool {
    public static void main(String[] args) {

        // Generate random array
        Random random = new Random();

        System.out.println("=== Array Analysis Tool ===");
        int[] originalArray = new int[10];
        for (int i = 0; i < originalArray.length; i++) originalArray[i] = random.nextInt(100) + 1;
        System.out.print("Generated array: ");
        printArray(originalArray);

        System.out.println("\n");
        System.out.println("=== Sorting Analysis ===");


        int[] bubbleArray = Arrays.copyOf(originalArray, originalArray.length);
        int[] selectionArray = Arrays.copyOf(originalArray, originalArray.length);
        int[] insertionArray = Arrays.copyOf(originalArray, originalArray.length);
        int[] bubbleStats = bubbleSortWithStats(bubbleArray);
        int[] selectionStats = selectionSortWithStats(selectionArray);
        int[] insertionStats = insertionSortWithStats(insertionArray);

        System.out.println("Bubble Sort: " + bubbleStats[0] + " comparisons, " + bubbleStats[1] + " swaps");
        System.out.println("Selection Sort: " + selectionStats[0] + " comparisons, " + selectionStats[1] + " swaps");
        System.out.println("Insertion Sort: " + insertionStats[0] + " comparisons, " + insertionStats[1] + " swaps");
        System.out.println();
        System.out.println("=== Statistics ===");
        double mean = calculateMean(originalArray);
        double median = calculateMedian(originalArray);
        int mode = calculateMode(originalArray);
        int range = calculateRange(originalArray);
        double stdDev = calculateStandardDeviation(originalArray, mean);
        System.out.printf("Mean: %.1f%n", mean);
        System.out.printf("Median: %.1f%n", median);
        System.out.println("Mode: " + mode);
        System.out.println("Range: " + range);
        System.out.printf("Standard Deviation: %.1f%n", stdDev);
        System.out.println();
        System.out.println("=== Search Results ===");
        int searchTarget = originalArray[random.nextInt(originalArray.length)];
        int linearComparisons = linearSearchWithStats(originalArray, searchTarget);

        Arrays.sort(bubbleArray);

        int binaryComparisons = binarySearchWithStats(bubbleArray, searchTarget);
        System.out.println("Linear search for " + searchTarget + ": " + linearComparisons + " comparisons");
        System.out.println("Binary search for " + searchTarget + ": " + binaryComparisons + " comparisons");
        System.out.println();
        System.out.println("=== Array Operations ===");
        int[] uniqueArray = removeDuplicates(originalArray);
        System.out.print("After removing duplicates: ");
        printArray(uniqueArray);
        System.out.println();
        int[] rotatedArray = rotateLeft(originalArray, 3);
        System.out.print("Rotated left by 3: ");
        printArray(rotatedArray);
        System.out.println();
    }

    static void printArray(int[] array) {
        for (int num : array) System.out.print(num + " ");
    }

    // Implement bubble, selection, insertion sorts with stats
    static int[] bubbleSortWithStats(int[] array) {
        int c = 0, s = 0, n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                c++;
                if (array[j] > array[j + 1]) {
                    int t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                    s++;
                }
            }
        }
        return new int[]{c, s};
    }

    static int[] selectionSortWithStats(int[] array) {
        int c = 0, s = 0, n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int m = i;
            for (int j = i + 1; j < n; j++) {
                c++;
                if (array[j] < array[m]) m = j;
            }
            if (m != i) {
                int t = array[m];
                array[m] = array[i];
                array[i] = t;
                s++;
            }
        }
        return new int[]{c, s};
    }

    static int[] insertionSortWithStats(int[] array) {
        int c = 0, s = 0, n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i], j = i - 1;
            while (j >= 0) {
                c++;
                if (array[j] > key) {
                    array[j + 1] = array[j];
                    s++;
                    j--;
                } else break;
            }
            array[j + 1] = key;
        }
        return new int[]{c, s};
    }

    // Compute mean, median, mode, range, std dev
    static double calculateMean(int[] a) {
        int sum = 0;
        for (int v : a) sum += v;
        return (double) sum / a.length;
    }

    static double calculateMedian(int[] a) {
        int[] s = Arrays.copyOf(a, a.length);
        Arrays.sort(s);
        return (s.length % 2 == 0) ? (s[s.length / 2 - 1] + s[s.length / 2]) / 2.0 : s[s.length / 2];
    }

    static int calculateMode(int[] a) {
        Map<Integer, Integer> f = new HashMap<>();
        for (int v : a) f.put(v, f.getOrDefault(v, 0) + 1);
        int m = a[0], mf = 1;
        for (Map.Entry<Integer, Integer> e : f.entrySet()) {
            if (e.getValue() > mf) {
                mf = e.getValue();
                m = e.getKey();
            }
        }
        return m;
    }

    static int calculateRange(int[] a) {
        int min = a[0], max = a[0];
        for (int v : a) {
            if (v < min) min = v;
            if (v > max) max = v;
        }
        return max - min;
    }

    static double calculateStandardDeviation(int[] a, double mean) {
        double s = 0;
        for (int v : a) s += Math.pow(v - mean, 2);
        return Math.sqrt(s / a.length);
    }

    // Compare linear vs binary search comparisons
    static int linearSearchWithStats(int[] a, int t) {
        int c = 0;
        for (int v : a) {
            c++;
            if (v == t) return c;
        }
        return c;
    }

    static int binarySearchWithStats(int[] a, int t) {
        int c = 0, l = 0, r = a.length - 1;
        while (l <= r) {
            c++;
            int m = l + (r - l) / 2;
            if (a[m] == t) return c;
            else if (a[m] < t) l = m + 1;
            else r = m - 1;
        }
        return c;
    }

    // Remove duplicates, rotate array
    static int[] removeDuplicates(int[] a) {
        Set<Integer> s = new LinkedHashSet<>();
        for (int v : a) s.add(v);
        int[] r = new int[s.size()];
        int i = 0;
        for (int v : s) r[i++] = v;
        return r;
    }

    static int[] rotateLeft(int[] a, int k) {
        int n = a.length;
        int[] r = new int[n];
        for (int i = 0; i < n; i++) r[i] = a[(i + k) % n];
        return r;
    }
}

