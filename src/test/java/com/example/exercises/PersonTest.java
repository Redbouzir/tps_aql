package com.example.exercises;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    
    @Test
    void getFullName_ShouldReturnCorrectFormat() {
        // Arrange
        Person person = new Person("John", "Doe", 25);
        
        // Act
        String result = person.getFullName();
        
        // Assert
        assertEquals("John Doe", result);
    }

    @Test
    void isAdult_WhenAgeIs18OrMore_ShouldReturnTrue() {
        // Arrange
        Person adult = new Person("John", "Doe", 18);
        Person olderAdult = new Person("Jane", "Doe", 25);
        
        // Act & Assert
        assertTrue(adult.isAdult());
        assertTrue(olderAdult.isAdult());
    }

    @Test
    void isAdult_WhenAgeIsLessThan18_ShouldReturnFalse() {
        // Arrange
        Person child = new Person("John", "Doe", 17);
        Person teenager = new Person("Jane", "Doe", 15);
        
        // Act & Assert
        assertFalse(child.isAdult());
        assertFalse(teenager.isAdult());
    }
} 