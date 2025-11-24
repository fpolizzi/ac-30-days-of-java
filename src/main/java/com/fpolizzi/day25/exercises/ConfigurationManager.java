package com.fpolizzi.day25.exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by fpolizzi on 24.11.25
 */
public class ConfigurationManager {

    // Static configuration storage
    private static Map<String, String> config = new HashMap<>();
    private static Map<String, Integer> counters = new HashMap<>();

    // Static constants
    public static final String DEFAULT_CONFIG_FILE = "config.properties";
    public static final int MAX_CONFIG_ITEMS = 100;
    public static final String VERSION = "1.0.0";

    // Static initialization block
    static {
        System.out.println("Initializing Configuration Manager...");
        loadDefaultConfig();
    }

    // Static methods for configuration management
    public static void setConfig(String key, String value) {
        if (config.size() >= MAX_CONFIG_ITEMS) {
            System.out.println("Warning: Maximum config items reached");
            return;
        }

        config.put(key, value);
        incrementCounter("setConfig");
        System.out.println("Config set: " + key + " = " + value);
    }

    public static String getConfig(String key) {
        incrementCounter("getConfig");
        return config.getOrDefault(key, "Not found");
    }

    public static String getConfig(String key, String defaultValue) {
        incrementCounter("getConfig");
        return config.getOrDefault(key, defaultValue);
    }

    public static boolean hasConfig(String key) {
        incrementCounter("hasConfig");
        return config.containsKey(key);
    }

    public static void removeConfig(String key) {
        if (config.remove(key) != null) {
            incrementCounter("removeConfig");
            System.out.println("Config removed: " + key);
        } else {
            System.out.println("Config not found: " + key);
        }
    }

    public static void clearConfig() {
        config.clear();
        incrementCounter("clearConfig");
        System.out.println("All configurations cleared");
    }

    public static void displayAllConfig() {
        System.out.println("\n=== Current Configuration ===");
        if (config.isEmpty()) {
            System.out.println("No configurations set");
        } else {
            for (Map.Entry<String, String> entry : config.entrySet()) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }
        }
    }

    public static void displayStats() {
        System.out.println("\n=== Configuration Manager Stats ===");
        System.out.println("Version: " + VERSION);
        System.out.println("Current config items: " + config.size());
        System.out.println("Max config items: " + MAX_CONFIG_ITEMS);
        System.out.println("Default config file: " + DEFAULT_CONFIG_FILE);

        System.out.println("\nMethod call statistics:");
        for (Map.Entry<String, Integer> entry : counters.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " calls");
        }
    }

    // Private helper methods
    private static void loadDefaultConfig() {
        setConfig("app.name", "MyApplication");
        setConfig("app.version", VERSION);
        setConfig("database.url", "localhost:3306");
        setConfig("database.user", "admin");
        setConfig("log.level", "INFO");
        setConfig("cache.enabled", "true");
    }

    private static void incrementCounter(String methodName) {
        counters.put(methodName, counters.getOrDefault(methodName, 0) + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Configuration Manager ===");

        while (true) {
            System.out.println("\n1. Set configuration");
            System.out.println("2. Get configuration");
            System.out.println("3. Check if configuration exists");
            System.out.println("4. Remove configuration");
            System.out.println("5. Display all configurations");
            System.out.println("6. Clear all configurations");
            System.out.println("7. Display statistics");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            }

            performConfigOperation(scanner, choice);
        }

        scanner.close();
    }

    public static void performConfigOperation(Scanner scanner, int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter key: ");
                String key = scanner.nextLine();
                System.out.print("Enter value: ");
                String value = scanner.nextLine();
                setConfig(key, value);
                break;
            case 2:
                System.out.print("Enter key: ");
                String getKey = scanner.nextLine();
                System.out.print("Enter default value (or press Enter for none): ");
                String defaultValue = scanner.nextLine();

                if (defaultValue.isEmpty()) {
                    System.out.println("Value: " + getConfig(getKey));
                } else {
                    System.out.println("Value: " + getConfig(getKey, defaultValue));
                }
                break;
            case 3:
                System.out.print("Enter key: ");
                String checkKey = scanner.nextLine();
                System.out.println("Exists: " + hasConfig(checkKey));
                break;
            case 4:
                System.out.print("Enter key to remove: ");
                String removeKey = scanner.nextLine();
                removeConfig(removeKey);
                break;
            case 5:
                displayAllConfig();
                break;
            case 6:
                clearConfig();
                break;
            case 7:
                displayStats();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }
}
