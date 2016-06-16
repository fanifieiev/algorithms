package com.fevzi.algorithms.fibonacci;

import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class FibonacciCalculationTest {
	
	@Test
	public void shouldCalculateFibonacciRecursively() {
		assertCalculation(new LinearFibonacciEvaluator(), 6, 8);
	}
	
	@Test
	public void shouldCalculateFibonacciLinearly() {
		assertCalculation(new LinearFibonacciEvaluator(), 6, 8);
	}
	
	private void assertCalculation(FibonacciEvaluator evaluator, int input, long expectedResult) {
		long result = evaluator.evaluate(input);
		assertThat("Fibonacci result", result == expectedResult);
	}

}
