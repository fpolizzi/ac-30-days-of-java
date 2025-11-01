package com.fpolizzi.day07;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * Created by fpolizzi on 01.11.25
 */
public class EnhancedCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double memory = 0.0;
        boolean hasMemory = false;
        ArrayList<String> history = new ArrayList<>();

        System.out.println("=== Enhanced Calculator ===");
        System.out.println("Operations: +, -, *, /, sqrt, pow");
        System.out.println("Memory: M+ (add), MR (recall), MC (clear)");
        System.out.println("History: H (show history), C (clear history)");
        System.out.println("Enter 'quit' to exit");
        System.out.println("================================");

        while (true) {
            try {
                System.out.print("Enter first number (or command): ");
                String input = scanner.nextLine();

                if (input.toLowerCase().equals("quit")) {
                    System.out.println("Thank you for using the calculator!");
                    break;
                } else if (input.toUpperCase().equals("MR")) {
                    if (hasMemory) {
                        System.out.println("Memory: " + memory);
                    } else {
                        System.out.println("Memory is empty!");
                    }
                    continue;
                } else if (input.toUpperCase().equals("MC")) {
                    memory = 0.0;
                    hasMemory = false;
                    System.out.println("Memory cleared!");
                    continue;
                } else if (input.toUpperCase().equals("H")) {
                    System.out.println("=== Calculation History ===");
                    if (history.isEmpty()) {
                        System.out.println("No calculations yet.");
                    } else {
                        for (int i = Math.max(0, history.size() - 5); i < history.size(); i++) {
                            System.out.println(history.get(i));
                        }
                    }
                    System.out.println("==========================");
                    continue;
                }

                double num1 = Double.parseDouble(input);

                System.out.print("Enter operation: ");
                String operation = scanner.nextLine();

                double num2 = 0.0;
                if (!operation.equals("sqrt")) {
                    System.out.print("Enter second number: ");
                    num2 = Double.parseDouble(scanner.nextLine());
                }

                double result = 0.0;
                boolean validOperation = true;
                String calculation = "";

                switch (operation) {
                    case "+":
                        result = num1 + num2;
                        calculation = String.format("%.2f + %.2f = %.2f", num1, num2, result);
                        break;
                    case "-":
                        result = num1 - num2;
                        calculation = String.format("%.2f - %.2f = %.2f", num1, num2, result);
                        break;
                    case "*":
                        result = num1 * num2;
                        calculation = String.format("%.2f * %.2f = %.2f", num1, num2, result);
                        break;
                    case "/":
                        if (num2 != 0) {
                            result = num1 / num2;
                            calculation = String.format("%.2f / %.2f = %.2f", num1, num2, result);
                        } else {
                            System.out.println("Error: Cannot divide by zero!");
                            validOperation = false;
                        }
                        break;
                    case "sqrt":
                        if (num1 >= 0) {
                            result = Math.sqrt(num1);
                            calculation = String.format("√%.2f = %.2f", num1, result);
                        } else {
                            System.out.println("Error: Cannot calculate square root of negative number!");
                            validOperation = false;
                        }
                        break;
                    case "pow":
                        result = Math.pow(num1, num2);
                        calculation = String.format("%.2f ^ %.2f = %.2f", num1, num2, result);
                        break;
                    default:
                        System.out.println("Error: Invalid operation!");
                        validOperation = false;
                }

                if (validOperation) {
                    System.out.println("Result: " + calculation);
                    history.add(calculation);

                    // Memory functions
                    System.out.print("Add to memory? (M+ or Enter to skip): ");
                    String memoryInput = scanner.nextLine();
                    if (memoryInput.toUpperCase().equals("M+")) {
                        memory += result;
                        hasMemory = true;
                        System.out.println("Added to memory. Current memory: " + memory);
                    }
                }

                System.out.println("-------------------------");

            } catch (NumberFormatException e) {
                System.out.println("Error: Please enter valid numbers!");
                System.out.println("-------------------------");
            }
        }

        scanner.close();
    }
}
