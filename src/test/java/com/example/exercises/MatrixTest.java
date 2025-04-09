package com.example.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {
    private Matrix matrix;
    private Matrix otherMatrix;

    @BeforeEach
    void setUp() {
        matrix = new Matrix(2);
        otherMatrix = new Matrix(2);
        
        // Initialize matrix with values:
        // [1 2]
        // [3 4]
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(1, 0, 3);
        matrix.set(1, 1, 4);
        
        // Initialize otherMatrix with values:
        // [5 6]
        // [7 8]
        otherMatrix.set(0, 0, 5);
        otherMatrix.set(0, 1, 6);
        otherMatrix.set(1, 0, 7);
        otherMatrix.set(1, 1, 8);
    }

    @Test
    void get_ShouldReturnCorrectValue() {
        assertEquals(1, matrix.get(0, 0));
        assertEquals(2, matrix.get(0, 1));
        assertEquals(3, matrix.get(1, 0));
        assertEquals(4, matrix.get(1, 1));
    }

    @Test
    void set_ShouldSetCorrectValue() {
        matrix.set(0, 0, 10);
        assertEquals(10, matrix.get(0, 0));
    }

    @Test
    void add_WithValidMatrix_ShouldAddMatrices() {
        matrix.add(otherMatrix);
        assertEquals(6, matrix.get(0, 0)); // 1 + 5
        assertEquals(8, matrix.get(0, 1)); // 2 + 6
        assertEquals(10, matrix.get(1, 0)); // 3 + 7
        assertEquals(12, matrix.get(1, 1)); // 4 + 8
    }

    @Test
    void add_WithNullMatrix_ShouldThrowException() {
        assertThrows(NullPointerException.class, () -> matrix.add(null));
    }

    @Test
    void add_WithDifferentSizeMatrix_ShouldThrowException() {
        Matrix differentSizeMatrix = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> matrix.add(differentSizeMatrix));
    }

    @Test
    void multiply_WithValidMatrix_ShouldMultiplyMatrices() {
        matrix.multiply(otherMatrix);
        assertEquals(19, matrix.get(0, 0)); // 1*5 + 2*7
        assertEquals(22, matrix.get(0, 1)); // 1*6 + 2*8
        assertEquals(43, matrix.get(1, 0)); // 3*5 + 4*7
        assertEquals(50, matrix.get(1, 1)); // 3*6 + 4*8
    }

    @Test
    void multiply_WithNullMatrix_ShouldThrowException() {
        assertThrows(NullPointerException.class, () -> matrix.multiply(null));
    }

    @Test
    void multiply_WithDifferentSizeMatrix_ShouldThrowException() {
        Matrix differentSizeMatrix = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> matrix.multiply(differentSizeMatrix));
    }

    @Test
    void transpose_ShouldTransposeMatrix() {
        matrix.transpose();
        assertEquals(1, matrix.get(0, 0));
        assertEquals(3, matrix.get(0, 1));
        assertEquals(2, matrix.get(1, 0));
        assertEquals(4, matrix.get(1, 1));
    }

    @Test
    void toString_ShouldReturnCorrectStringRepresentation() {
        String expected = "[1, 2]\n[3, 4]\n";
        assertEquals(expected, matrix.toString());
    }
} 