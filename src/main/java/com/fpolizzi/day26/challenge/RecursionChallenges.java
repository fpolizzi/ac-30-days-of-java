package com.fpolizzi.day26.challenge;

/**
 * Created by fpolizzi on 25.11.25
 */
public class RecursionChallenges {
    public static long factorial(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        // base case(s) + recursive case
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    public static long fibonacci(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int sumDigits(int n) {
        if (n < 0) throw new IllegalArgumentException("n must be >= 0");
        if (n < 10) return n;
        return (n % 10) + sumDigits(n / 10);
    }

    public static long power(long base, int exp) {
        if (exp < 0) throw new IllegalArgumentException("exp must be >= 0");
        if (exp == 0) return 1;
        return base * power(base, exp - 1);
    }

    public static String reverseString(String s) {
        if (s == null) return null;
        if (s.length() <= 1) return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }

    public static boolean isPalindrome(String s) {
        if (s == null) return false;
        String t = s.toLowerCase();
        return isPalindromeHelper(t, 0, t.length() - 1);
    }

    private static boolean isPalindromeHelper(String s, int left, int right) {
        if (left >= right) return true;
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindromeHelper(s, left + 1, right - 1);
    }

    public static int gcd(int a, int b) {
        a = Math.abs(a); b = Math.abs(b);
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println("factorial(7) = " + factorial(7));
        System.out.println("fibonacci(8) = " + fibonacci(8));
        System.out.println("sumDigits(8192) = " + sumDigits(8192));
        System.out.println("power(3,12) = " + power(3, 12));
        System.out.println("reverseString('Hola Amigos') = " + reverseString("Hola Amigos"));
        System.out.println("isPalindrome('Java') = " + isPalindrome("Java"));
        System.out.println("gcd(36,33) = " + gcd(36, 33));
    }
}
