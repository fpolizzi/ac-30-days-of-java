package com.fpolizzi.day02.exercises;

/**
 * Created by fpolizzi on 26.10.25
 */
public class GradeCalculator {
    public static void main(String[] args) {

        double gradeMath = 61.3;
        double gradeBiology = 71.9;
        double gradeEnglish = 73.4;
        double gradePhysics = 58.5;
        double gradeGeography = 62.3;
        double gradeChemistry = 55.7;
        double gradeMusic = 77.6;

        double average = (
        gradeMath +
        gradeBiology +
        gradeEnglish +
        gradePhysics +
        gradeGeography +
        gradeChemistry +
        gradeMusic) / 7;

        System.out.println("=== Average Grade Calculator ===");
        System.out.println("Average Grade: " + average);
    }
}
