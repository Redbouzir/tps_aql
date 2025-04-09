package com.example.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    
    @Test
    void fibonacci_WhenNIs0_ShouldReturn0() {
        assertEquals(0, Fibonacci.fibonacci(0));
    }

    @Test
    void fibonacci_WhenNIs1_ShouldReturn1() {
        assertEquals(1, Fibonacci.fibonacci(1));
    }

    @Test
    void fibonacci_WhenNIs2_ShouldReturn1() {
        assertEquals(1, Fibonacci.fibonacci(2));
    }

    @Test
    void fibonacci_WhenNIs3_ShouldReturn2() {
        assertEquals(2, Fibonacci.fibonacci(3));
    }

    @Test
    void fibonacci_WhenNIs4_ShouldReturn3() {
        assertEquals(3, Fibonacci.fibonacci(4));
    }

    @Test
    void fibonacci_WhenNIsNegative_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Fibonacci.fibonacci(-1));
    }
} 