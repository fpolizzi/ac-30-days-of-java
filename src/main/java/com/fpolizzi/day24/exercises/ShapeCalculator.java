package com.fpolizzi.day24.exercises;

import java.util.Scanner;

/**
 * Created by fpolizzi on 23.11.25
 */
public class ShapeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Shape Calculator ===");

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            calculateShape(scanner, choice);
        }

        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("\n1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.println("4. Square");
        System.out.println("5. Compare shapes");
        System.out.println("0. Exit");
    }

    public static void calculateShape(Scanner scanner, int choice) {
        switch (choice) {
            case 1:
                calculateCircle(scanner);
                break;
            case 2:
                calculateRectangle(scanner);
                break;
            case 3:
                calculateTriangle(scanner);
                break;
            case 4:
                calculateSquare(scanner);
                break;
            case 5:
                compareShapes(scanner);
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    public static void calculateCircle(Scanner scanner) {
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();

        double area = area(radius);
        double perimeter = perimeter(radius);

        System.out.printf("Circle - Radius: %.2f%n", radius);
        System.out.printf("Area: %.2f%n", area);
        System.out.printf("Perimeter: %.2f%n", perimeter);
    }

    public static void calculateRectangle(Scanner scanner) {
        System.out.print("Enter length and width: ");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();

        double area = area(length, width);
        double perimeter = perimeter(length, width);

        System.out.printf("Rectangle - Length: %.2f, Width: %.2f%n", length, width);
        System.out.printf("Area: %.2f%n", area);
        System.out.printf("Perimeter: %.2f%n", perimeter);
    }

    public static void calculateTriangle(Scanner scanner) {
        System.out.print("Enter three sides: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double area = area(a, b, c);
        double perimeter = perimeter(a, b, c);

        System.out.printf("Triangle - Sides: %.2f, %.2f, %.2f%n", a, b, c);
        System.out.printf("Area: %.2f%n", area);
        System.out.printf("Perimeter: %.2f%n", perimeter);
    }

    public static void calculateSquare(Scanner scanner) {
        System.out.print("Enter side length: ");
        double side = scanner.nextDouble();

        double area = area(side);
        double perimeter = perimeter(side);

        System.out.printf("Square - Side: %.2f%n", side);
        System.out.printf("Area: %.2f%n", area);
        System.out.printf("Perimeter: %.2f%n", perimeter);
    }

    public static void compareShapes(Scanner scanner) {
        System.out.println("Enter dimensions for two shapes to compare:");

        System.out.print("Shape 1 - Enter radius (circle) or side (square): ");
        double dim1 = scanner.nextDouble();

        System.out.print("Shape 2 - Enter radius (circle) or side (square): ");
        double dim2 = scanner.nextDouble();

        double area1 = area(dim1); // Circle
        double area2 = area(dim2); // Square

        System.out.printf("Circle area: %.2f%n", area1);
        System.out.printf("Square area: %.2f%n", area2);

        if (area1 > area2) {
            System.out.println("Circle has larger area");
        } else if (area2 > area1) {
            System.out.println("Square has larger area");
        } else {
            System.out.println("Both shapes have equal area");
        }
    }

    // Overloaded area methods
    public static double area(double radius) {
        // Circle area
        return Math.PI * radius * radius;
    }

    public static double area(double length, double width) {
        // Rectangle area
        return length * width;
    }

    public static double area(double a, double b, double c) {
        // Triangle area using Heron's formula
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // Overloaded perimeter methods
    public static double perimeter(double radius) {
        // Circle perimeter
        return 2 * Math.PI * radius;
    }

    public static double perimeter(double length, double width) {
        // Rectangle perimeter
        return 2 * (length + width);
    }

    public static double perimeter(double a, double b, double c) {
        // Triangle perimeter
        return a + b + c;
    }
}
