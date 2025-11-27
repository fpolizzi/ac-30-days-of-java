package com.fpolizzi.day27.challenge;

import java.io.*;

/**
 * Created by fpolizzi on 27.11.25
 */
public class ErrorHandlingChallenges {
    public static double divide(double dividend, double divisor) {
        if (Double.isNaN(dividend) || Double.isNaN(divisor)) {
            throw new IllegalArgumentException("Inputs must be valid numbers");
        }
        if (divisor == 0.0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return dividend / divisor;
    }

    public static double sqrt(double value) {
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("Value must be a valid number");
        }
        if (value < 0.0) {
            throw new IllegalArgumentException("Cannot calculate square root of negative number");
        }
        return Math.sqrt(value);
    }

    public static int parsePositiveInt(String input) {
        if (input == null || input.isBlank()) {
            throw new NumberFormatException("Input is null or blank");
        }
        int value = Integer.parseInt(input.trim()); // may throw NumberFormatException
        if (value <= 0) {
            throw new IllegalArgumentException("Value must be a positive integer");
        }
        return value;
    }

    public static String readFile(String path) throws IOException {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("Path cannot be null or blank");
        }
        File file = new File(path);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + path);
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    public static void validatePassword(String password) throws ValidationException {
        if (password == null) {
            throw new ValidationException("Password cannot be null");
        }
        if (password.length() < 8) {
            throw new ValidationException("Password must be at least 8 characters long");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new ValidationException("Password must contain at least one uppercase letter");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new ValidationException("Password must contain at least one lowercase letter");
        }
        if (!password.matches(".*\\d.*")) {
            throw new ValidationException("Password must contain at least one digit");
        }
    }

    public static class ValidationException extends Exception {
        public ValidationException(String message) { super(message); }
    }

    public static void main(String[] args) throws Exception {
        // Sample quick tests
        try { divide(1, 0); } catch (ArithmeticException e) { System.out.println(e.getMessage()); }
        try { sqrt(-4); } catch (IllegalArgumentException e) { System.out.println(e.getMessage()); }
        try { parsePositiveInt("-2"); } catch (Exception e) { System.out.println(e.getMessage()); }
        try { validatePassword("weak"); } catch (ValidationException e) { System.out.println(e.getMessage()); }
    }
}
