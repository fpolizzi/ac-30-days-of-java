package com.fpolizzi.day19.exercises;

/**
 * Created by fpolizzi on 16.11.25
 */
public class CSVParser {
    public static void main(String[] args) {
        String csvData = "Name,Age,City\nJohn,25,New York\nJane,30,Los Angeles\nBob,35,Chicago";

        String[][] parsedData = parseCSV(csvData);

        System.out.println("=== Parsed CSV Data ===");
        for (String[] row : parsedData) {
            for (String cell : row) {
                System.out.print(cell + "\t");
            }
            System.out.println();
        }

        // Find average age
        double avgAge = calculateAverageAge(parsedData);
        System.out.println("Average age: " + avgAge);
    }

    public static String[][] parseCSV(String csvData) {
        String[] lines = csvData.split("\n");
        String[][] data = new String[lines.length][];

        for (int i = 0; i < lines.length; i++) {
            data[i] = lines[i].split(",");
        }

        return data;
    }

    public static double calculateAverageAge(String[][] data) {
        int sum = 0;
        int count = 0;

        for (int i = 1; i < data.length; i++) { // Skip header
            try {
                sum += Integer.parseInt(data[i][1]);
                count++;
            } catch (NumberFormatException e) {
                // Skip invalid age
            }
        }

        return count > 0 ? (double) sum / count : 0;
    }
}
