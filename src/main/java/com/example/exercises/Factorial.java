package com.example.exercises;

public class Factorial {
    public static int factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be positive");
        }
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
} 