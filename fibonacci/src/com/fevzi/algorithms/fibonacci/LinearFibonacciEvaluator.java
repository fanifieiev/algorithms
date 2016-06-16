package com.fevzi.algorithms.fibonacci;

public final class LinearFibonacciEvaluator implements FibonacciEvaluator {

	@Override
	public long evaluate(int n) {
		if (n <= 1) {
			return n;
		} else {
			long a = 0;
			long b = 1;

			for (int i = 2; i <= n; i++) {
				a = a + b;
				b = b + a;
			}
			return a + b;
		}

	}

}
