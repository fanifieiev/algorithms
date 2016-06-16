package com.fevzi.algorithms.fibonacci;

import org.junit.Test;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;

public class FibonacciCalculationTimeMesureTest {

	@Test
	public void testTimeExecutionForRecursive() {
		FibonacciEvaluator evaluator = new RecursiveFibonacciEvaluator();
		
		Monitor monitor = MonitorFactory.start("FIBONACCI_RECURSIVELY");
		long result = evaluator.evaluate(50);
		monitor.stop();
		System.out.println(monitor);
	}
	
	@Test
	public void testTimeExecutionForLinear() {
		FibonacciEvaluator evaluator = new LinearFibonacciEvaluator();
		
		Monitor monitor = MonitorFactory.start("FIBONACCI_LINEARLY");
		long result = evaluator.evaluate(50);
		monitor.stop();
		System.out.println(monitor);
	}
}
