package com.example.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {
    
    @Test
    void factorial_WhenNIs0_ShouldReturn1() {
        assertEquals(1, Factorial.factorial(0));
    }

    @Test
    void factorial_WhenNIs1_ShouldReturn1() {
        assertEquals(1, Factorial.factorial(1));
    }

    @Test
    void factorial_WhenNIs2_ShouldReturn2() {
        assertEquals(2, Factorial.factorial(2));
    }

    @Test
    void factorial_WhenNIs3_ShouldReturn6() {
        assertEquals(6, Factorial.factorial(3));
    }

    @Test
    void factorial_WhenNIs4_ShouldReturn24() {
        assertEquals(24, Factorial.factorial(4));
    }

    @Test
    void factorial_WhenNIs5_ShouldReturn120() {
        assertEquals(120, Factorial.factorial(5));
    }

    @Test
    void factorial_WhenNIsNegative_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Factorial.factorial(-1));
    }
} 