package com.fevzi.algorithms.sorting;

public final class SelectionSort implements SortMethod {

	@Override
	public <T extends Comparable<T>> void sort(T[] sortable) {
		int size = sortable.length;
		for (int i = 0; i < size; i++) {
			int minIndex = i;
			for (int j = i + 1; j < size; j++)
				if (firstLess(sortable[j], sortable[minIndex]))
					minIndex = j;

			swap(sortable, minIndex, i);
		}
	}
}
