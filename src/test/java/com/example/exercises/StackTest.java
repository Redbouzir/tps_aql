package com.example.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    private Stack stack;

    @BeforeEach
    void setUp() {
        stack = new Stack();
    }

    @Test
    void newStack_ShouldBeEmpty() {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

    @Test
    void push_ShouldAddElement() {
        // Act
        stack.push(1);
        
        // Assert
        assertFalse(stack.isEmpty());
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    @Test
    void pop_ShouldRemoveAndReturnTopElement() {
        // Arrange
        stack.push(1);
        stack.push(2);
        
        // Act
        int result = stack.pop();
        
        // Assert
        assertEquals(2, result);
        assertEquals(1, stack.size());
        assertEquals(1, stack.peek());
    }

    @Test
    void pop_WhenEmpty_ShouldThrowException() {
        assertThrows(IllegalStateException.class, () -> stack.pop());
    }

    @Test
    void peek_ShouldReturnTopElementWithoutRemoving() {
        // Arrange
        stack.push(1);
        
        // Act
        int result = stack.peek();
        
        // Assert
        assertEquals(1, result);
        assertEquals(1, stack.size());
    }

    @Test
    void peek_WhenEmpty_ShouldThrowException() {
        assertThrows(IllegalStateException.class, () -> stack.peek());
    }

    @Test
    void push_WhenFull_ShouldExpandCapacity() {
        // Arrange
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        
        // Act
        stack.push(10);
        
        // Assert
        assertEquals(11, stack.size());
        assertEquals(10, stack.peek());
    }
} 