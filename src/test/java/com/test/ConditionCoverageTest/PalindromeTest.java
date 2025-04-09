package com.test.ConditionCoverageTest;

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
    void testTwoCharactersEqual() {
        assertTrue(Palindrome.isPalindrome("aa"));
    }
    
    @Test
    void testTwoCharactersDifferent() {
        assertFalse(Palindrome.isPalindrome("ab"));
    }
    
    @Test
    void testThreeCharactersPalindrome() {
        assertTrue(Palindrome.isPalindrome("aba"));
    }
    
    @Test
    void testThreeCharactersNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("abc"));
    }
    
    @Test
    void testFourCharactersPalindrome() {
        assertTrue(Palindrome.isPalindrome("abba"));
    }
    
    @Test
    void testFourCharactersNonPalindrome() {
        assertFalse(Palindrome.isPalindrome("abcd"));
    }
} 