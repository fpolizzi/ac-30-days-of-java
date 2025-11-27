package com.fpolizzi.day27.exercises;

import java.io.*;
import java.util.Scanner;

/**
 * Created by fpolizzi on 27.11.25
 */
public class FileOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== File Operations ===");

        while (true) {
            try {
                System.out.println("\n1. Write to file");
                System.out.println("2. Read from file");
                System.out.println("3. Delete file");
                System.out.println("4. Exit");

                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (choice == 4) {
                    System.out.println("Goodbye!");
                    break;
                }

                performFileOperation(scanner, choice);

            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static void performFileOperation(Scanner scanner, int choice) {
        try {
            switch (choice) {
                case 1:
                    writeToFile(scanner);
                    break;
                case 2:
                    readFromFile(scanner);
                    break;
                case 3:
                    deleteFile(scanner);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } catch (IOException e) {
            System.out.println("File I/O error: " + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Security error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        }
    }

    public static void writeToFile(Scanner scanner) throws IOException {
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        System.out.print("Enter content: ");
        String content = scanner.nextLine();

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
            System.out.println("File written successfully!");
        }
    }

    public static void readFromFile(Scanner scanner) throws IOException {
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        File file = new File(filename);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + filename);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            System.out.println("File contents:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void deleteFile(Scanner scanner) {
        System.out.print("Enter filename to delete: ");
        String filename = scanner.nextLine();

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist: " + filename);
            return;
        }

        if (file.delete()) {
            System.out.println("File deleted successfully!");
        } else {
            System.out.println("Failed to delete file: " + filename);
        }
    }
}
