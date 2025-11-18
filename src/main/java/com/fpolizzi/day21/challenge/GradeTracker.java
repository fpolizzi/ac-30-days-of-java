package com.fpolizzi.day21.challenge;

import java.util.*;
import java.io.*;

/**
 * Created by fpolizzi on 18.11.25
 */
public class GradeTracker {
    private ArrayList<Student> students;
    private String[] subjects;
    private Scanner scanner;

    public GradeTracker() {
        students = new ArrayList<>();
        subjects = new String[]{"Math", "Science", "English", "History", "Computer Science"};
        scanner = new Scanner(System.in);
    }

    // Main menu
    public void run() {
        while (true) {
            displayMainMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    addGrade();
                    break;
                case 4:
                    updateGrade();
                    break;
                case 5:
                    displayStudentGrades();
                    break;
                case 6:
                    displayAllStudents();
                    break;
                case 7:
                    generateReport();
                    break;
                case 8:
                    searchStudents();
                    break;
                case 9:
                    saveToFile();
                    break;
                case 10:
                    loadFromFile();
                    break;
                case 11:
                    displayStatistics();
                    break;
                case 12:
                    System.out.println("Thank you for using Grade Tracker!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    // Display main menu
    private void displayMainMenu() {
        System.out.println("\n=== Student Grade Tracker ===");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Add Grade");
        System.out.println("4. Update Grade");
        System.out.println("5. Display Student Grades");
        System.out.println("6. Display All Students");
        System.out.println("7. Generate Report");
        System.out.println("8. Search Students");
        System.out.println("9. Save to File");
        System.out.println("10. Load from File");
        System.out.println("11. Display Statistics");
        System.out.println("12. Exit");
    }

    // Add new student
    private void addStudent() {
        System.out.println("\n=== Add New Student ===");

        String id = getStringInput("Enter student ID: ");

        // Check if student already exists
        if (findStudentById(id) != null) {
            System.out.println("Student with ID " + id + " already exists!");
            return;
        }

        String name = getStringInput("Enter student name: ");
        String email = getStringInput("Enter student email: ");

        Student student = new Student(id, name, email);
        students.add(student);

        System.out.println("Student added successfully!");
    }

    // Remove student
    private void removeStudent() {
        System.out.println("\n=== Remove Student ===");
        String id = getStringInput("Enter student ID to remove: ");

        Student student = findStudentById(id);
        if (student != null) {
            students.remove(student);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Add grade for student
    private void addGrade() {
        System.out.println("\n=== Add Grade ===");
        String id = getStringInput("Enter student ID: ");

        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Available subjects:");
        for (int i = 0; i < subjects.length; i++) {
            System.out.println((i + 1) + ". " + subjects[i]);
        }

        int subjectChoice = getIntInput("Select subject (1-" + subjects.length + "): ");
        if (subjectChoice < 1 || subjectChoice > subjects.length) {
            System.out.println("Invalid subject choice!");
            return;
        }

        double score = getDoubleInput("Enter grade (0-100): ");
        if (score < 0 || score > 100) {
            System.out.println("Invalid grade! Must be between 0 and 100.");
            return;
        }

        student.addGrade(subjects[subjectChoice - 1], score);
        System.out.println("Grade added successfully!");
    }

    // Update existing grade
    private void updateGrade() {
        System.out.println("\n=== Update Grade ===");
        String id = getStringInput("Enter student ID: ");

        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        if (student.getGrades().isEmpty()) {
            System.out.println("No grades found for this student!");
            return;
        }

        System.out.println("Current grades:");
        for (int i = 0; i < student.getGrades().size(); i++) {
            Grade grade = student.getGrades().get(i);
            System.out.println((i + 1) + ". " + grade.getSubject() + ": " + grade.getScore());
        }

        int gradeChoice = getIntInput("Select grade to update (1-" + student.getGrades().size() + "): ");
        if (gradeChoice < 1 || gradeChoice > student.getGrades().size()) {
            System.out.println("Invalid choice!");
            return;
        }

        double newScore = getDoubleInput("Enter new grade (0-100): ");
        if (newScore < 0 || newScore > 100) {
            System.out.println("Invalid grade! Must be between 0 and 100.");
            return;
        }

        student.getGrades().get(gradeChoice - 1).setScore(newScore);
        System.out.println("Grade updated successfully!");
    }

    // Display grades for specific student
    private void displayStudentGrades() {
        System.out.println("\n=== Student Grades ===");
        String id = getStringInput("Enter student ID: ");

        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("\nStudent: " + student.getName() + " (ID: " + student.getId() + ")");
        System.out.println("Email: " + student.getEmail());
        System.out.println("Average Grade: " + String.format("%.2f", student.getAverageGrade()));
        System.out.println("Letter Grade: " + student.getLetterGrade());

        if (student.getGrades().isEmpty()) {
            System.out.println("No grades recorded yet.");
        } else {
            System.out.println("\nGrades:");
            System.out.printf("%-15s %-10s %-12s%n", "Subject", "Score", "Date");
            System.out.println("----------------------------------------");

            for (Grade grade : student.getGrades()) {
                System.out.printf("%-15s %-10.1f %-12s%n",
                        grade.getSubject(), grade.getScore(), grade.getDate());
            }
        }
    }

    // Display all students
    private void displayAllStudents() {
        System.out.println("\n=== All Students ===");

        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        System.out.printf("%-10s %-20s %-25s %-10s %-10s%n",
                "ID", "Name", "Email", "Average", "Grade");
        System.out.println("--------------------------------------------------------");

        for (Student student : students) {
            System.out.printf("%-10s %-20s %-25s %-10.2f %-10s%n",
                    student.getId(), student.getName(), student.getEmail(),
                    student.getAverageGrade(), student.getLetterGrade());
        }
    }

    // Generate comprehensive report
    private void generateReport() {
        System.out.println("\n=== Grade Report ===");

        if (students.isEmpty()) {
            System.out.println("No students to generate report for.");
            return;
        }

        // Sort students by average grade (descending)
        ArrayList<Student> sortedStudents = new ArrayList<>(students);
        sortedStudents.sort((s1, s2) -> Double.compare(s2.getAverageGrade(), s1.getAverageGrade()));

        System.out.println("Ranked by Average Grade:");
        System.out.printf("%-5s %-10s %-20s %-10s %-10s%n",
                "Rank", "ID", "Name", "Average", "Grade");
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < sortedStudents.size(); i++) {
            Student student = sortedStudents.get(i);
            System.out.printf("%-5d %-10s %-20s %-10.2f %-10s%n",
                    (i + 1), student.getId(), student.getName(),
                    student.getAverageGrade(), student.getLetterGrade());
        }

        // Subject-wise statistics
        System.out.println("\nSubject-wise Statistics:");
        for (String subject : subjects) {
            double subjectAverage = calculateSubjectAverage(subject);
            System.out.printf("%s: %.2f%n", subject, subjectAverage);
        }
    }

    // Search students
    private void searchStudents() {
        System.out.println("\n=== Search Students ===");
        System.out.println("1. Search by name");
        System.out.println("2. Search by grade range");
        System.out.println("3. Search by letter grade");

        int choice = getIntInput("Enter search type: ");

        switch (choice) {
            case 1:
                searchByName();
                break;
            case 2:
                searchByGradeRange();
                break;
            case 3:
                searchByLetterGrade();
                break;
            default:
                System.out.println("Invalid choice!");
        }
    }

    private void searchByName() {
        String searchTerm = getStringInput("Enter name to search: ");
        ArrayList<Student> results = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().toLowerCase().contains(searchTerm.toLowerCase())) {
                results.add(student);
            }
        }

        displaySearchResults(results);
    }

    private void searchByGradeRange() {
        double min = getDoubleInput("Enter minimum average grade: ");
        double max = getDoubleInput("Enter maximum average grade: ");
        ArrayList<Student> results = new ArrayList<>();

        for (Student student : students) {
            double avg = student.getAverageGrade();
            if (avg >= min && avg <= max) {
                results.add(student);
            }
        }

        displaySearchResults(results);
    }

    private void searchByLetterGrade() {
        System.out.print("Enter letter grade (A, B, C, D, F): ");
        String letterGrade = scanner.nextLine().toUpperCase();
        ArrayList<Student> results = new ArrayList<>();

        for (Student student : students) {
            if (student.getLetterGrade().equals(letterGrade)) {
                results.add(student);
            }
        }

        displaySearchResults(results);
    }

    private void displaySearchResults(ArrayList<Student> results) {
        if (results.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nSearch Results:");
        System.out.printf("%-10s %-20s %-10s%n", "ID", "Name", "Average");
        System.out.println("----------------------------------------");

        for (Student student : results) {
            System.out.printf("%-10s %-20s %-10.2f%n",
                    student.getId(), student.getName(), student.getAverageGrade());
        }
    }

    // Save data to file
    private void saveToFile() {
        System.out.println("\n=== Save to File ===");
        String filename = getStringInput("Enter filename: ");

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            // Write subjects
            writer.println(String.join(",", subjects));

            // Write students and grades
            for (Student student : students) {
                writer.println("STUDENT," + student.getId() + "," + student.getName() + "," + student.getEmail());

                for (Grade grade : student.getGrades()) {
                    writer.println("GRADE," + student.getId() + "," + grade.getSubject() + "," +
                            grade.getScore() + "," + grade.getDate());
                }
            }

            System.out.println("Data saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    // Load data from file
    private void loadFromFile() {
        System.out.println("\n=== Load from File ===");
        String filename = getStringInput("Enter filename: ");

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            students.clear();

            // Read subjects
            String subjectLine = reader.readLine();
            if (subjectLine != null) {
                subjects = subjectLine.split(",");
            }

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts[0].equals("STUDENT")) {
                    Student student = new Student(parts[1], parts[2], parts[3]);
                    students.add(student);
                } else if (parts[0].equals("GRADE")) {
                    Student student = findStudentById(parts[1]);
                    if (student != null) {
                        student.addGrade(parts[2], Double.parseDouble(parts[3]));
                    }
                }
            }

            System.out.println("Data loaded successfully from " + filename);
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    // Display statistics
    private void displayStatistics() {
        System.out.println("\n=== Statistics ===");

        if (students.isEmpty()) {
            System.out.println("No students in the system.");
            return;
        }

        // Overall statistics
        double totalAverage = 0;
        int totalStudents = students.size();
        Map<String, Integer> letterGradeCount = new HashMap<>();

        for (Student student : students) {
            totalAverage += student.getAverageGrade();
            String letterGrade = student.getLetterGrade();
            letterGradeCount.put(letterGrade, letterGradeCount.getOrDefault(letterGrade, 0) + 1);
        }

        double overallAverage = totalAverage / totalStudents;

        System.out.println("Total Students: " + totalStudents);
        System.out.printf("Overall Average: %.2f%n", overallAverage);

        System.out.println("\nGrade Distribution:");
        for (String grade : Arrays.asList("A", "B", "C", "D", "F")) {
            int count = letterGradeCount.getOrDefault(grade, 0);
            double percentage = (double) count / totalStudents * 100;
            System.out.printf("%s: %d students (%.1f%%)%n", grade, count, percentage);
        }

        // Subject statistics
        System.out.println("\nSubject Averages:");
        for (String subject : subjects) {
            double subjectAvg = calculateSubjectAverage(subject);
            System.out.printf("%s: %.2f%n", subject, subjectAvg);
        }
    }

    // Helper methods
    private Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    private double calculateSubjectAverage(String subject) {
        double sum = 0;
        int count = 0;

        for (Student student : students) {
            double grade = student.getGradeForSubject(subject);
            if (grade >= 0) {
                sum += grade;
                count++;
            }
        }

        return count > 0 ? sum / count : 0.0;
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
