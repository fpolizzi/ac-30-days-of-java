package com.fpolizzi.day20.challenge;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class ArrayToolkit {
    private int[] array;

    public ArrayToolkit(int[] array) {
        this.array = array.clone();
    }

    public void sort() {
        Arrays.sort(array);
    }

    public void reverse() {
        ArrayUtils.reverse(array);
    }

    public int search(int target) {
        return Arrays.binarySearch(array, target);
    }

    public int[] removeDuplicates() {
        return ArrayUtils.removeDuplicates(array);
    }

    public double mean() {
        return ArrayUtils.calculateAverage(array);
    }

    public double median() {
        int[] s = array.clone();
        Arrays.sort(s);
        return s.length % 2 == 0 ? (s[s.length / 2 - 1] + s[s.length / 2]) / 2.0 : s[s.length / 2];
    }

    public int mode() {
        Map<Integer, Integer> f = new HashMap<>();
        for (int v : array) f.put(v, f.getOrDefault(v, 0) + 1);
        return f.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(0);
    }

    public double variance() {
        double m = mean(), sum = 0;
        for (int v : array) sum += Math.pow(v - m, 2);
        return sum / array.length;
    }

    public double stddev() {
        return Math.sqrt(variance());
    }

    public void shuffle() {
        Random r = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            int t = array[i];
            array[i] = array[j];
            array[j] = t;
        }
    }

    public void rotate(int k) {
        ArrayUtils.rotate(array, k);
    }

    public int findPeak() {
        return AdvancedArrayUtils.findPeakElement(array);
    }

    public long measure(Runnable op) {
        Instant a = Instant.now();
        op.run();
        return Duration.between(a, Instant.now()).toNanos();
    }

    public void display() {
        System.out.println("Array: " + Arrays.toString(array));
    }
}

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

class AdvancedArrayUtils {
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

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        ArrayToolkit tk = new ArrayToolkit(arr);
        while (true) {
            System.out.println("\n1.Display 2.Sort 3.Reverse 4.Search 5.Remove dups 6.Shuffle 7.Rotate 8.Find peak 9.Stats 10.Timings 11.Exit");
            int c = sc.nextInt();
            if (c == 11) break;
            switch (c) {
                case 1 -> tk.display();
                case 2 -> System.out.println("Sort ns: " + tk.measure(tk::sort));
                case 3 -> {
                    tk.reverse();
                    System.out.println("Reversed");
                }
                case 4 -> {
                    System.out.print("Target: ");
                    int t = sc.nextInt();
                    int i = tk.search(t);
                    System.out.println(i >= 0 ? "Index: " + i : "Not found");
                }
                case 5 -> {
                    arr = tk.removeDuplicates();
                    System.out.println("Removed duplicates");
                }
                case 6 -> {
                    tk.shuffle();
                    System.out.println("Shuffled");
                }
                case 7 -> {
                    System.out.print("Positions: ");
                    int k = sc.nextInt();
                    tk.rotate(k);
                    System.out.println("Rotated");
                }
                case 8 -> System.out.println("Peak index: " + tk.findPeak());
                case 9 -> {
                    System.out.printf("Mean: %.2f, Median: %.2f, Mode: %d, Var: %.2f, Std: %.2f%n", tk.mean(), tk.median(), tk.mode(), tk.variance(), tk.stddev());
                }
                case 10 -> {
                    System.out.println("Sort ns: " + tk.measure(tk::sort));
                    System.out.println("Reverse ns: " + tk.measure(tk::reverse));
                    System.out.println("Shuffle ns: " + tk.measure(tk::shuffle));
                }
                default -> System.out.println("Invalid");
            }
        }
    }
}