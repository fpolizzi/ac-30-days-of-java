package com.fpolizzi.day18.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        System.out.println("=== Library Management System ===");

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. Search books");
            System.out.println("4. Check out book");
            System.out.println("5. Return book");
            System.out.println("6. Display all books");
            System.out.println("7. Display available books");
            System.out.println("8. Sort books");
            System.out.println("9. Statistics");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook(library, scanner);
                    break;
                case 2:
                    removeBook(library, scanner);
                    break;
                case 3:
                    searchBooks(library, scanner);
                    break;
                case 4:
                    checkOutBook(library, scanner);
                    break;
                case 5:
                    returnBook(library, scanner);
                    break;
                case 6:
                    library.displayAllBooks();
                    break;
                case 7:
                    library.displayAvailableBooks();
                    break;
                case 8:
                    sortBooks(library, scanner);
                    break;
                case 9:
                    library.displayStatistics();
                    break;
                case 10:
                    System.out.println("Thank you for using the library system!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    public static void addBook(Library library, Scanner scanner) {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();

        if (library.addBook(title, author, isbn)) {
            System.out.println("Book added successfully!");
        } else {
            System.out.println("Book with this ISBN already exists!");
        }
    }

    public static void removeBook(Library library, Scanner scanner) {
        System.out.print("Enter ISBN to remove: ");
        String isbn = scanner.nextLine();

        if (library.removeBook(isbn)) {
            System.out.println("Book removed successfully!");
        } else {
            System.out.println("Book not found!");
        }
    }

    public static void searchBooks(Library library, Scanner scanner) {
        System.out.println("Search by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. ISBN");

        System.out.print("Enter choice: ");
        int searchChoice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter search term: ");
        String searchTerm = scanner.nextLine();

        ArrayList<Book> results = library.searchBooks(searchChoice, searchTerm);

        if (results.isEmpty()) {
            System.out.println("No books found.");
        } else {
            System.out.println("\n=== Search Results ===");
            displayBooks(results);
        }
    }

    public static void checkOutBook(Library library, Scanner scanner) {
        System.out.print("Enter ISBN to check out: ");
        String isbn = scanner.nextLine();

        if (library.checkOutBook(isbn)) {
            System.out.println("Book checked out successfully!");
        } else {
            System.out.println("Book not available or not found!");
        }
    }

    public static void returnBook(Library library, Scanner scanner) {
        System.out.print("Enter ISBN to return: ");
        String isbn = scanner.nextLine();

        if (library.returnBook(isbn)) {
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book not found or already returned!");
        }
    }

    public static void sortBooks(Library library, Scanner scanner) {
        System.out.println("Sort by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. ISBN");

        System.out.print("Enter choice: ");
        int sortChoice = scanner.nextInt();

        library.sortBooks(sortChoice);
        System.out.println("Books sorted successfully!");
    }

    public static void displayBooks(ArrayList<Book> books) {
        System.out.printf("%-20s %-15s %-15s %-10s%n", "Title", "Author", "ISBN", "Status");
        System.out.println("------------------------------------------------");

        for (Book book : books) {
            System.out.printf("%-20s %-15s %-15s %-10s%n",
                    book.getTitle(), book.getAuthor(),
                    book.getIsbn(), book.getStatus());
        }
    }
}

class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean available;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.available = true;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return available; }
    public String getStatus() { return available ? "Available" : "Checked Out"; }

    public void setAvailable(boolean available) { this.available = available; }
}

class Library {
    private ArrayList<Book> books;

    public Library() {
        books = new ArrayList<>();
    }

    public boolean addBook(String title, String author, String isbn) {
        // Check for duplicate ISBN
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return false;
            }
        }

        books.add(new Book(title, author, isbn));
        return true;
    }

    public boolean removeBook(String isbn) {
        return books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    public ArrayList<Book> searchBooks(int choice, String searchTerm) {
        ArrayList<Book> results = new ArrayList<>();

        for (Book book : books) {
            boolean match = false;
            switch (choice) {
                case 1: // Title
                    match = book.getTitle().toLowerCase().contains(searchTerm.toLowerCase());
                    break;
                case 2: // Author
                    match = book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase());
                    break;
                case 3: // ISBN
                    match = book.getIsbn().equals(searchTerm);
                    break;
            }

            if (match) {
                results.add(book);
            }
        }

        return results;
    }

    public boolean checkOutBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                book.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isAvailable()) {
                book.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }

        System.out.println("\n=== All Books ===");
        displayBooks(books);
    }

    public void displayAvailableBooks() {
        ArrayList<Book> available = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                available.add(book);
            }
        }

        if (available.isEmpty()) {
            System.out.println("No available books.");
            return;
        }

        System.out.println("\n=== Available Books ===");
        displayBooks(available);
    }

    public void sortBooks(int choice) {
        switch (choice) {
            case 1: // Title
                Collections.sort(books, (b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
                break;
            case 2: // Author
                Collections.sort(books, (b1, b2) -> b1.getAuthor().compareTo(b2.getAuthor()));
                break;
            case 3: // ISBN
                Collections.sort(books, (b1, b2) -> b1.getIsbn().compareTo(b2.getIsbn()));
                break;
        }
    }

    public void displayStatistics() {
        int totalBooks = books.size();
        int availableBooks = 0;
        int checkedOutBooks = 0;

        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks++;
            } else {
                checkedOutBooks++;
            }
        }

        System.out.println("\n=== Library Statistics ===");
        System.out.println("Total books: " + totalBooks);
        System.out.println("Available books: " + availableBooks);
        System.out.println("Checked out books: " + checkedOutBooks);

        if (totalBooks > 0) {
            double availabilityRate = (double) availableBooks / totalBooks * 100;
            System.out.printf("Availability rate: %.1f%%%n", availabilityRate);
        }
    }

    private void displayBooks(ArrayList<Book> bookList) {
        System.out.printf("%-20s %-15s %-15s %-10s%n", "Title", "Author", "ISBN", "Status");
        System.out.println("------------------------------------------------");

        for (Book book : bookList) {
            System.out.printf("%-20s %-15s %-15s %-10s%n",
                    book.getTitle(), book.getAuthor(),
                    book.getIsbn(), book.getStatus());
        }
    }
}