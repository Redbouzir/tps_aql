package com.example.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PrimeTest {
    
    @Test
    void isPrime_WhenNIsLessThan2_ShouldReturnFalse() {
        assertFalse(Prime.isPrime(1));
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(-1));
    }

    @Test
    void isPrime_WhenNIs2_ShouldReturnTrue() {
        assertTrue(Prime.isPrime(2));
    }

    @Test
    void isPrime_WhenNIs3_ShouldReturnTrue() {
        assertTrue(Prime.isPrime(3));
    }

    @Test
    void isPrime_WhenNIs4_ShouldReturnFalse() {
        assertFalse(Prime.isPrime(4));
    }

    @Test
    void isPrime_WhenNIs5_ShouldReturnTrue() {
        assertTrue(Prime.isPrime(5));
    }

    @Test
    void isPrime_WhenNIs6_ShouldReturnFalse() {
        assertFalse(Prime.isPrime(6));
    }

    @Test
    void isPrime_WhenNIs7_ShouldReturnTrue() {
        assertTrue(Prime.isPrime(7));
    }

    @Test
    void isPrime_WhenNIs8_ShouldReturnFalse() {
        assertFalse(Prime.isPrime(8));
    }

    @Test
    void isPrime_WhenNIs9_ShouldReturnFalse() {
        assertFalse(Prime.isPrime(9));
    }

    @Test
    void isPrime_WhenNIs10_ShouldReturnFalse() {
        assertFalse(Prime.isPrime(10));
    }
} 