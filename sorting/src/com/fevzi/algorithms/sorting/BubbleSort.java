package com.fevzi.algorithms.sorting;

public class BubbleSort implements SortMethod {

	@Override
	public <T extends Comparable<T>> void sort(T[] sortable) {

		int size = sortable.length;
		for (int i = size - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (firstLess(sortable[j], sortable[j + 1])) {
					swap(sortable, j, j + 1);
				}
			}
		}
	}

}
