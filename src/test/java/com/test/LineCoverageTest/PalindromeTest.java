package com.test.LineCoverageTest;

import com.test.Palindrome;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    
    @Test
    void testNullInput() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }
    
    @Test
    void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }
    
    @Test
    void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"));
    }
    
    @Test
    void testValidPalindrome() {
        assertTrue(Palindrome.isPalindrome("kayak"));
    }
    
    @Test
    void testValidPalindromeWithSpaces() {
        assertTrue(Palindrome.isPalindrome("Esope reste ici et se repose"));
    }
    
    @Test
    void testValidPalindromeWithMixedCase() {
        assertTrue(Palindrome.isPalindrome("KaYaK"));
    }
    
    @Test
    void testNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }
} 