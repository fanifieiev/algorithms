package com.fevzi.algorithms.fibonacci;

public final class LinearFibonacciEvaluator implements FibonacciEvaluator {

	@Override
	public long evaluate(int n) {
		if (n <= 1) {
			return n;
		} else {
			long first = 1;
			long second = 1;

			long current = 0;
			for (int i = 3; i <= n; i++) {
				current = first + second;
				first = second;
				second = current;
			}
			return current;
		}
	}
}
