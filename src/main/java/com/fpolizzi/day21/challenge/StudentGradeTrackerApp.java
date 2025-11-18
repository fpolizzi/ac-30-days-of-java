package com.fpolizzi.day21.challenge;

/**
 * Created by fpolizzi on 18.11.25
 */
public class StudentGradeTrackerApp {
    public static void main(String[] args) {
        System.out.println("Welcome to Student Grade Tracker!");
        System.out.println("A comprehensive grade management system.");

        GradeTracker tracker = new GradeTracker();
        tracker.run();
    }
}