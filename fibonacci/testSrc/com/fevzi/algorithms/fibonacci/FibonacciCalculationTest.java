package com.fevzi.algorithms.fibonacci;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class FibonacciCalculationTest {
	
	@Test
	public void shouldCalculateFibonacciRecursively() {
		FibonacciEvaluator fibonacci = new RecursiveFibonacciEvaluator();
		long result = fibonacci.evaluate(6);
		assertThat(String.format("Fibonacci result with reccursion"), result == 8);
	}
	
	@Test
	public void shouldCalculateFibonacciLinearly() {
		FibonacciEvaluator fibonacci = new LinearFibonacciEvaluator();
		long result = fibonacci.evaluate(6);
		assertThat(String.format("Fibonacci result with reccursion"), result == 10);
	}

}
