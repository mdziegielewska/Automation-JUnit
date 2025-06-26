package org.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Fibonacci Sequence Test")
class FibonacciSequenceTest {

    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {-1000, -440, -12})
    @DisplayName("Should handle negative values")
    void shouldThrowExceptionIfNegative(int value) {
        assertThrows(IllegalArgumentException.class,
                () -> FibonacciSequence.fibonacci(value),
                "Expected IllegalArgumentException for negative input: " + value);
    }

    @ParameterizedTest(name = "fibonacci({0}) should return {1}")
    @CsvSource({
            "0, 0",
            "1, 1",
            "2, 1",
            "3, 2",
            "4, 3",
            "5, 5",
            "6, 8",
            "10, 55",
            "20, 6765"
    })
    @DisplayName("Should calculate correct Fibonacci values for small positive integers")
    void shouldCalculateCorrectValues(int input, int expected) {
        assertEquals(expected, FibonacciSequence.fibonacci(input),
                "Fibonacci calculation incorrect for input: " + input);
    }

    @ParameterizedTest(name = "fibonacci({0}) should follow the Fibonacci recurrence relation")
    @ValueSource(ints = {3, 5, 8, 15, 25})
    @DisplayName("Should adhere to the Fibonacci recurrence relation (F(n) = F(n-1) + F(n-2))")
    void shouldAdhereToRecurrenceRelation(int n) {
        if (n >= 2) {
            int expected = FibonacciSequence.fibonacci(n - 1) + FibonacciSequence.fibonacci(n - 2);
            assertEquals(expected, FibonacciSequence.fibonacci(n),
                    "Fibonacci recurrence relation failed for n=" + n);
        }
    }

    @RepeatedTest(value = 5, name = "Performance Test Run #{currentRepetition}")
    @DisplayName("Measure Fibonacci performance for a larger values")
    void measureFibonacciPerformance() {
        long startTime = System.nanoTime();
        FibonacciSequence.fibonacci(38);
        long endTime = System.nanoTime();

        long durationMillis = (endTime - startTime) / 1_000_000;
        System.out.println("Execution time for fibonacci(38): " + durationMillis + " ms");
        Assertions.assertTrue(durationMillis < 50,
                "Fibonacci calculation for 38 took too long (expected < 50ms)");
    }
}