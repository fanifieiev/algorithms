package com.fevzi.algorithms.fibonacci;

import java.time.Duration;
import java.time.Instant;

public class FibonacciRunner {

	public static void main(String[] args) {
		Instant instant = Instant.now(); 
		
		FibonacciEvaluator evaluator = new RecursiveFibonacci();
		final long result = evaluator.evaluate(30);
		
		System.out.println(String.format("Execution took '%s'ms with result='%d'", 
				Duration.between(instant, Instant.now()).toMillis(), result));
		
	}
}
