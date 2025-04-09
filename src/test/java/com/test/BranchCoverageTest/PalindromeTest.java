package com.test.BranchCoverageTest;

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
    void testEvenLengthPalindrome() {
        assertTrue(Palindrome.isPalindrome("abba"));
    }
    
    @Test
    void testOddLengthPalindrome() {
        assertTrue(Palindrome.isPalindrome("aba"));
    }
    
    @Test
    void testNonPalindromeDifferentCharacters() {
        assertFalse(Palindrome.isPalindrome("ab"));
    }
    
    @Test
    void testNonPalindromeSimilarCharacters() {
        assertFalse(Palindrome.isPalindrome("abca"));
    }
} 