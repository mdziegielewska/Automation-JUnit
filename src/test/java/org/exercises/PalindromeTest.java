package org.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    @ParameterizedTest(name = "Test word: {0}")
    @ValueSource(strings={ "madam", "nun", "mom" })
    @DisplayName("Should identify palindromes")
    void shouldBePalindrome(String word) {
        assertTrue(Palindrome.isPalindrome(word));
    }

    @ParameterizedTest(name = "Test word: {0}")
    @ValueSource(strings={ "cake", "beige", "mouses" })
    @DisplayName("Should identify non-palindromes")
    void shouldNotBePalindrome(String word) {
        assertFalse(Palindrome.isPalindrome(word));
    }

    @Test
    @DisplayName("Should not let empty string")
    void shouldThrowExceptionForEmptyString() {
        String empty = "";

        assertThrows(IllegalArgumentException.class, () -> {
            Palindrome.isPalindrome(empty);
        });
    }

    @Test
    @DisplayName("Should not let null values")
    void shouldThrowExceptionForNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            Palindrome.isPalindrome(null);
        });
    }

    @DisplayName("Should consider single chars as palindromes")
    @ParameterizedTest(name = "Test char: {0}")
    @ValueSource(strings = { "a", "b", "d" })
    void shouldConsiderSingleChars(String character) {
        assertTrue(Palindrome.isPalindrome(character));
    }

    @DisplayName("Should handle whitespace and punctuation")
    @ParameterizedTest(name = "Test string: {0}")
    @ValueSource(strings = {
            "go hang a salami, i’m a lasagna hog.",
            "yo! banana boy.",
            "on a clover, if alive, erupts a vast pure evil; a fire volcano."
    })
    void shouldAcceptWhiteSpaceAndPunctuation(String string) {
        assertTrue(Palindrome.isPalindrome(string));
    }

    @DisplayName("Should handle uppercase letters")
    @ParameterizedTest(name = "Test string: {0}")
    @ValueSource(strings = {
            "aBBbaRbRabBBa",
            "Madam",
            "Never ODD or eVEn"
    })
    void shouldAcceptUpperCaseLetter(String string) {
        assertTrue(Palindrome.isPalindrome(string));
    }

    @DisplayName("Should handle numeric characters")
    @ParameterizedTest(name = "Test string: {0}")
    @ValueSource(strings = {
            "A m4n, a plan, a canal, Pan4ma!",
            "rac3car!",
            "Madam, I'm 5Adam."
    })
    void shouldHandleNonAlphanumericCharacters(String string) {
        assertTrue(Palindrome.isPalindrome(string));
    }

    @DisplayName("Should handle non-ASCII characters")
    @ParameterizedTest(name = "Test string: {0}")
    @ValueSource(strings = {
            "Élu par cette crapule",
            "E sine, ženi se",
            "Mus rev inuits öra, sa röst i universum"
    })
    void shouldHandleNonAsciiCharacters(String string) {
        assertTrue(Palindrome.isPalindrome(string));
    }
}