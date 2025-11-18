package com.fpolizzi.day21.challenge;

import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by fpolizzi on 18.11.25
 */
public class Student {
    private String id;
    private String name;
    private String email;
    private ArrayList<Grade> grades;

    public Student(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.grades = new ArrayList<>();
    }

    // Getters and setters
    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public ArrayList<Grade> getGrades() { return grades; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }

    // Add grade
    public void addGrade(String subject, double score) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        grades.add(new Grade(subject, score, date));
    }

    // Get grade for specific subject
    public double getGradeForSubject(String subject) {
        for (Grade grade : grades) {
            if (grade.getSubject().equals(subject)) {
                return grade.getScore();
            }
        }
        return -1; // Grade not found
    }

    // Calculate average grade
    public double getAverageGrade() {
        if (grades.isEmpty()) return 0.0;

        double sum = 0;
        for (Grade grade : grades) {
            sum += grade.getScore();
        }
        return sum / grades.size();
    }

    // Get letter grade
    public String getLetterGrade() {
        double average = getAverageGrade();
        if (average >= 90) return "A";
        else if (average >= 80) return "B";
        else if (average >= 70) return "C";
        else if (average >= 60) return "D";
        else return "F";
    }

    @Override
    public String toString() {
        return String.format("Student{id='%s', name='%s', email='%s', avg=%.2f}",
                id, name, email, getAverageGrade());
    }
}
