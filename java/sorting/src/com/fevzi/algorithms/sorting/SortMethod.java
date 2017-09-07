package com.fevzi.algorithms.sorting;

public interface SortMethod {

	<T extends Comparable<T>> void sort(T[] arr);

	default <T extends Comparable<T>> boolean firstLess(T first, T second) {
		return first.compareTo(second) < 0;
	}

	default <T extends Comparable<T>> boolean firstGreater(T first, T second) {
		return first.compareTo(second) > 0;
	}

	default <T extends Comparable<T>> boolean same(T first, T second) {
		return first.compareTo(second) == 0;
	}

	default <T extends Comparable<T>> void swap(T[] t, int i, int j) {
		T min = t[i];
		t[i] = t[j];
		t[j] = min;
	}
}
