package com.fpolizzi.day07;

import java.util.Scanner;

/**
 * Created by fpolizzi on 01.11.25
 */
public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Simple Calculator ===");
        System.out.println("Basic Operations: +, -, *, /");
        System.out.println("Enter 'q' to exit");
        System.out.println("=========================");

        while (true) {
            try {
                // Input the first number
                System.out.print("Enter the first number: ");
                String input = scanner.nextLine();

                // Check if the user wants to quit
                if (input.toLowerCase().equals("q")) {
                    System.out.println("Bye!");
                    break;
                }

                double numberOne = Double.parseDouble(input);

                // Input the operation
                System.out.print("Enter the operation (+, -, *, /): ");
                String operation = scanner.nextLine();

                // Input the second number
                System.out.print("Enter the second number: ");
                double numberTwo = Double.parseDouble(scanner.nextLine());

                // Do the calculation
                double result = 0.0;
                boolean validOperation = true;

                switch (operation) {
                    case "+":
                        result = numberOne + numberTwo;
                        break;
                    case "-":
                        result = numberOne - numberTwo;
                        break;
                    case "*":
                        result = numberOne * numberTwo;
                        break;
                    case "/":
                        if (numberTwo != 0) {
                            result = numberOne / numberTwo;
                        } else {
                            System.out.println("Error: Cannot divide by zero!");
                            validOperation = false;
                        }
                        break;
                    default:
                        System.out.println("Error: Invalid operation!");
                        validOperation = false;
                }

                // Display the result
                if (validOperation) {
                    System.out.printf("Result: %.2f %s %.2f = %.2f%n",
                            numberOne, operation, numberTwo, result);
                }

                System.out.println("= = = = = = = = = = = = = ");

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers!");
                System.out.println("= = = = = = = = = = = = = ");
            }
        }

        scanner.close();
    }
}
