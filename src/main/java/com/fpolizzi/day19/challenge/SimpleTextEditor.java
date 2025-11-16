package com.fpolizzi.day19.challenge;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by fpolizzi on 16.11.25
 */
public class SimpleTextEditor {
    private ArrayList<String> lines;

    public SimpleTextEditor() {
        lines = new ArrayList<>();
    }

    public void addLine(String text) {
        lines.add(text);
        System.out.println("Line added!");
    }

    public void deleteLine(int lineNumber) {
        if (lineNumber > 0 && lineNumber <= lines.size()) {
            lines.remove(lineNumber - 1);
            System.out.println("Line deleted!");
        } else {
            System.out.println("Invalid line number!");
        }
    }

    public void editLine(int lineNumber, String newText) {
        if (lineNumber > 0 && lineNumber <= lines.size()) {
            lines.set(lineNumber - 1, newText);
            System.out.println("Line edited!");
        } else {
            System.out.println("Invalid line number!");
        }
    }

    public void searchText(String searchTerm) {
        System.out.println("Search results:");
        boolean found = false;

        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("Line " + (i + 1) + ": " + lines.get(i));
                found = true;
            }
        }

        if (!found) {
            System.out.println("Text not found.");
        }
    }

    public void replaceText(String oldText, String newText) {
        int count = 0;
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).contains(oldText)) {
                lines.set(i, lines.get(i).replace(oldText, newText));
                count++;
            }
        }
        System.out.println("Replaced " + count + " occurrences.");
    }

    public void displayText() {
        if (lines.isEmpty()) {
            System.out.println("No text content.");
            return;
        }

        System.out.println("=== Text Content ===");
        for (int i = 0; i < lines.size(); i++) {
            System.out.println((i + 1) + ": " + lines.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimpleTextEditor editor = new SimpleTextEditor();

        System.out.println("=== Simple Text Editor ===");

        while (true) {
            System.out.println("\n1. Add line");
            System.out.println("2. Delete line");
            System.out.println("3. Edit line");
            System.out.println("4. Search text");
            System.out.println("5. Replace text");
            System.out.println("6. Display text");
            System.out.println("7. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    editor.addLine(scanner.nextLine());
                    break;
                case 2:
                    System.out.print("Enter line number: ");
                    editor.deleteLine(scanner.nextInt());
                    break;
                case 3:
                    System.out.print("Enter line number: ");
                    int lineNum = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new text: ");
                    editor.editLine(lineNum, scanner.nextLine());
                    break;
                case 4:
                    System.out.print("Enter search term: ");
                    editor.searchText(scanner.nextLine());
                    break;
                case 5:
                    System.out.print("Enter text to replace: ");
                    String oldText = scanner.nextLine();
                    System.out.print("Enter new text: ");
                    String newText = scanner.nextLine();
                    editor.replaceText(oldText, newText);
                    break;
                case 6:
                    editor.displayText();
                    break;
                case 7:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
