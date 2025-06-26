package org.exercises;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Nested;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Palindrome Class Tests")
class PalindromeTest {

    @Nested
    @DisplayName("Valid Palindrome Class Tests")
    class ValidPalindromes {

        @ParameterizedTest(name = "Test word: {0}")
        @ValueSource(strings = {
                "madam",
                "nun",
                "mom",
                "a",
                "b",
                "Madam",
                "Never ODD or eVEn",
                "A",
                "anna",
                "racecar",
                "level"
        })
        @DisplayName("Should identify palindromes")
        void shouldBePalindrome(String word) {
            assertTrue(Palindrome.isPalindrome(word));
        }

        @ParameterizedTest(name = "Test string: {0}")
        @ValueSource(strings = {
                "go hang a salami, i’m a lasagna hog.",
                "yo! banana boy.",
                "on a clover, if alive, erupts a vast pure evil; a fire volcano.",
                "A m4n, a plan, a canal, Pan4ma!",
                "rac3car!",
                "Madam, I'm 5Adam.",
                "Eva, can I see bees in a cave?",
                "No 'x' in Nixon"
        })
        @DisplayName("Should correctly handle whitespace and punctuation")
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

    @Nested
    @DisplayName("Invalid Palindrome Class Tests")
    class InvalidPalindromes {

        @ParameterizedTest(name = "Test word: {0}")
        @ValueSource(strings = {
                "cake",
                "beige",
                "mouses",
                "hello",
                "world",
                "programming",
                "Not a palindrome"
        })
        @DisplayName("Should identify non-palindromes")
        void shouldNotBePalindrome(String word) {
            assertFalse(Palindrome.isPalindrome(word));
        }
    }

    @Nested
    @DisplayName("Error Handling Class Tests")
    class ErrorHandling {

        @ParameterizedTest(name = "Should not let {0} values")
        @NullAndEmptySource
        @DisplayName("Should throw IllegalArgumentException for null or empty strings")
        void shouldThrowExceptionForNullOrEmpty(String word) {
            assertThrows(IllegalArgumentException.class, () -> Palindrome.isPalindrome(word),
                    "Expected IllegalArgumentException for '" + word + "'");
        }
    }
}