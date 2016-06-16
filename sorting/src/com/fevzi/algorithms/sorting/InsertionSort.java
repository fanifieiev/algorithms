package com.fevzi.algorithms.sorting;

public final class InsertionSort implements SortMethod {

	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {

		int size = arr.length;
		for (int i = 1; i < size; i++) {
			T value = arr[i];
			for (int j = i - 1; (j >= 0 && firstGreater(arr[j], value)); j--) {
				swap(arr, j, j + 1);
			}
		}
	}

}
