package com.fevzi.algorithms.fibonacci;

public final class RecursiveFibonacciEvaluator implements FibonacciEvaluator {

	@Override
	public long evaluate(int n) {
		if(n <= 1) {
			return n;
		} else {
			return evaluate(n - 1) + evaluate(n - 2);
		}
	}

}
