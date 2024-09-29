package org.exercises;

public class FibonacciSequence {
    public static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be positive");
        } else if (n == 0) {
            return 0;
        } else if (n == 1 ) {
            return 1;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
