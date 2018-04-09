package com.fevzi.algorithms.fibonacci;

import static org.hamcrest.MatcherAssert.assertThat;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class FibonacciCalculationTest {

	private int input;
	private long expected;
	private FibonacciEvaluator fibonacciEvaluator;

	@Parameterized.Parameters(name = "{0}.toString(): Fibonacci calculation (Fib({1}) should be equal to {2}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{new RecursiveFibonacciEvaluator(), 30, 832040L},
				{new LinearFibonacciEvaluator(), 30, 832040L},
				{new LinearFibonacciEvaluator(), 50, 12586269025L},
				{new RecursiveFibonacciEvaluator(), 50, 12586269025L}
		});
	}

	public FibonacciCalculationTest(FibonacciEvaluator fibonacciEvaluator, int input, long expected) {
		this.fibonacciEvaluator = fibonacciEvaluator;
		this.input = input;
		this.expected = expected;
	}

	@Test
	public void shouldProperlyCalculateFibonacciNumber() {
		Monitor monitor = MonitorFactory.start(this.fibonacciEvaluator.getClass().getSimpleName());
		assertCalculation(this.fibonacciEvaluator, this.input, this.expected);
		monitor.stop();
		System.out.println(String.format("Label: %s, calculation of Fib(%s) took %s ms", monitor.getLabel(),
				this.input, monitor.getAvg()));
	}


	private void assertCalculation(FibonacciEvaluator evaluator, int input, long expectedResult) {
		long result = evaluator.evaluate(input);
		assertThat("Fibonacci result", result == expectedResult);
	}

}
