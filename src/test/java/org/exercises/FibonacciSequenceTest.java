package org.exercises;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FibonacciSequenceTest {
    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {-1000, -440, -12})
    @DisplayName("Should handle negative values")
    void shouldThrowExceptionIfNegative(int value) {
        assertThrows(IllegalArgumentException.class,
                () -> FibonacciSequence.fibonacci(value));
    }

    @Test
    @DisplayName("Should return 0 if n=0")
    void shouldReturn0() {
        assertEquals(FibonacciSequence.fibonacci(0), 0);
    }

    @Test
    @DisplayName("Should return 0 if n=1")
    void shouldReturn1() {
        assertEquals(FibonacciSequence.fibonacci(1), 1);
    }

    @ParameterizedTest(name = "{0}")
    @ValueSource(ints = {6, 14, 30})
    @DisplayName("Should calculate correctly")
    void shouldCalculateFibonacci(int value) {
        int nextValue = FibonacciSequence.fibonacci(value-1)+FibonacciSequence.fibonacci(value-2);
        assertEquals(FibonacciSequence.fibonacci(value), nextValue);
    }

    @RepeatedTest(10)
    @DisplayName("Measure Fibonacci performance for larger values")
    void measureFibonacciPerformance() {
        long startTime = System.nanoTime();
        FibonacciSequence.fibonacci(38);
        long endTime = System.nanoTime();

        long duration = endTime - startTime;
        System.out.println("Execution time: " + duration + " nanoseconds");

        Assertions.assertTrue(duration < 100000000, "Fibonacci calculation took too long");
    }
}