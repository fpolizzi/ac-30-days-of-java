package com.fpolizzi.day25.exercises;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by fpolizzi on 24.11.25
 */
public class UtilityClass {

    // Static constants
    public static final String[] COLORS = {"Red", "Green", "Blue", "Yellow", "Purple", "Orange"};
    public static final String[] DAYS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public static final int[] PRIMES = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

    // Static random generator
    private static Random random = new Random();

    // Static counter
    private static int methodCallCount = 0;

    // Static methods for number operations
    public static int getRandomNumber(int min, int max) {
        methodCallCount++;
        return random.nextInt(max - min + 1) + min;
    }

    public static double getRandomDouble(double min, double max) {
        methodCallCount++;
        return min + (max - min) * random.nextDouble();
    }

    public static boolean isEven(int number) {
        methodCallCount++;
        return number % 2 == 0;
    }

    public static boolean isOdd(int number) {
        methodCallCount++;
        return !isEven(number);
    }

    public static int getDigitSum(int number) {
        methodCallCount++;
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // Static methods for string operations
    public static String getRandomColor() {
        methodCallCount++;
        return COLORS[random.nextInt(COLORS.length)];
    }

    public static String getRandomDay() {
        methodCallCount++;
        return DAYS[random.nextInt(DAYS.length)];
    }

    public static String repeatString(String str, int times) {
        methodCallCount++;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < times; i++) {
            result.append(str);
        }
        return result.toString();
    }

    public static String truncateString(String str, int maxLength) {
        methodCallCount++;
        if (str.length() <= maxLength) {
            return str;
        }
        return str.substring(0, maxLength) + "...";
    }

    // Static methods for array operations
    public static int[] generateRandomArray(int size, int min, int max) {
        methodCallCount++;
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = getRandomNumber(min, max);
        }
        return array;
    }

    public static int findMax(int[] array) {
        methodCallCount++;
        if (array.length == 0) return Integer.MIN_VALUE;

        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static int findMin(int[] array) {
        methodCallCount++;
        if (array.length == 0) return Integer.MAX_VALUE;

        int min = array[0];
        for (int num : array) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    public static double calculateAverage(int[] array) {
        methodCallCount++;
        if (array.length == 0) return 0.0;

        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }

    // Static methods for validation
    public static boolean isValidEmail(String email) {
        methodCallCount++;
        if (email == null || email.isEmpty()) return false;
        return email.contains("@") && email.contains(".");
    }

    public static boolean isValidPhone(String phone) {
        methodCallCount++;
        if (phone == null || phone.isEmpty()) return false;

        String digitsOnly = phone.replaceAll("\\D", "");
        return digitsOnly.length() == 10 || digitsOnly.length() == 11;
    }

    public static boolean isPrime(int number) {
        methodCallCount++;
        if (number <= 1) return false;
        if (number <= 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    // Static method to get statistics
    public static void displayStats() {
        System.out.println("=== Utility Class Statistics ===");
        System.out.println("Total method calls: " + methodCallCount);
        System.out.println("Available colors: " + COLORS.length);
        System.out.println("Available days: " + DAYS.length);
        System.out.println("Prime numbers stored: " + PRIMES.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Utility Class Demo ===");

        while (true) {
            System.out.println("\n1. Generate random number");
            System.out.println("2. Get random color");
            System.out.println("3. Generate random array");
            System.out.println("4. Validate data");
            System.out.println("5. String operations");
            System.out.println("6. Display statistics");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            performOperation(scanner, choice);
        }

        scanner.close();
    }

    public static void performOperation(Scanner scanner, int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter min and max: ");
                int min = scanner.nextInt();
                int max = scanner.nextInt();
                System.out.println("Random number: " + getRandomNumber(min, max));
                break;
            case 2:
                System.out.println("Random color: " + getRandomColor());
                break;
            case 3:
                System.out.print("Enter array size: ");
                int size = scanner.nextInt();
                int[] array = generateRandomArray(size, 1, 100);
                System.out.print("Generated array: ");
                for (int num : array) {
                    System.out.print(num + " ");
                }
                System.out.println();
                System.out.println("Max: " + findMax(array));
                System.out.println("Min: " + findMin(array));
                System.out.printf("Average: %.2f%n", calculateAverage(array));
                break;
            case 4:
                System.out.print("Enter email: ");
                String email = scanner.nextLine();
                System.out.println("Valid email: " + isValidEmail(email));

                System.out.print("Enter phone: ");
                String phone = scanner.nextLine();
                System.out.println("Valid phone: " + isValidPhone(phone));

                System.out.print("Enter number to check if prime: ");
                int num = scanner.nextInt();
                System.out.println("Is prime: " + isPrime(num));
                break;
            case 5:
                System.out.print("Enter string to repeat: ");
                String str = scanner.nextLine();
                System.out.print("Enter times to repeat: ");
                int times = scanner.nextInt();
                System.out.println("Result: " + repeatString(str, times));

                scanner.nextLine(); // Consume newline
                System.out.print("Enter string to truncate: ");
                String longStr = scanner.nextLine();
                System.out.print("Enter max length: ");
                int maxLen = scanner.nextInt();
                System.out.println("Truncated: " + truncateString(longStr, maxLen));
                break;
            case 6:
                displayStats();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
