package com.fpolizzi.day03.examples;

/**
 * Created by fpolizzi on 27.10.25
 */
public class NameFormatter {
    public static void main(String[] args) {
        String firstName = "  john  ";
        String lastName = "  DOE  ";

        // Clean and format the names
        String cleanFirstName = firstName.trim().toLowerCase();
        String cleanLastName = lastName.trim().toLowerCase();

        // Capitalize first letter
        String formattedFirstName = cleanFirstName.substring(0, 1).toUpperCase() +
                cleanFirstName.substring(1);
        String formattedLastName = cleanLastName.substring(0, 1).toUpperCase() +
                cleanLastName.substring(1);

        // Create full name
        String fullName = formattedFirstName + " " + formattedLastName;

        System.out.println("Original: " + firstName + lastName);
        System.out.println("Formatted: " + fullName);
        System.out.println("Email: " + cleanFirstName + "." + cleanLastName + "@email.com");
    }
}
