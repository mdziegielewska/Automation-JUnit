package org.exercises;

import java.text.Normalizer;

public class Palindrome {
    public static Boolean isPalindrome(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }

        String normalizedWord = Normalizer.normalize(word, Normalizer.Form.NFKD);

        String cleanedWord = normalizedWord
                .replaceAll("[^\\sa-zA-Z]", "")
                .replaceAll("\\s", "")
                .toLowerCase();

        String reversed = new StringBuilder(cleanedWord).reverse().toString();

        return reversed.equals(cleanedWord);
    }
}