package com.fpolizzi.day21.challenge;

/**
 * Created by fpolizzi on 18.11.25
 */
public class Grade {
    private String subject;
    private double score;
    private String date;

    public Grade(String subject, double score, String date) {
        this.subject = subject;
        this.score = score;
        this.date = date;
    }

    // Getters
    public String getSubject() { return subject; }
    public double getScore() { return score; }
    public String getDate() { return date; }

    // Setters
    public void setScore(double score) { this.score = score; }
    public void setDate(String date) { this.date = date; }

    @Override
    public String toString() {
        return String.format("Grade{subject='%s', score=%.1f, date='%s'}",
                subject, score, date);
    }
}
