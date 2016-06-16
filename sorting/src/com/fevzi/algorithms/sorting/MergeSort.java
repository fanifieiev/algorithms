package com.fevzi.algorithms.sorting;

import java.lang.reflect.Array;

public final class MergeSort implements SortMethod {

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Comparable<T>> void sort(T[] arr) {
		T[] sorted = mergeSort(arr);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sorted[i];
		}
	}

	@SuppressWarnings("unchecked")
	private <T extends Comparable<T>> T[] mergeSort(T[] arr) {
		int length = arr.length;
		if (length <= 1) {
			return arr;
		} else {
			int middle = length / 2;
			T[] left = (T[]) Array.newInstance(arr[0].getClass(), middle);
			T[] right = (T[]) Array.newInstance(arr[0].getClass(), length - middle);

			for (int i = 0; i < length; i++) {
				if (i < middle)
					left[i] = arr[i];
				else
					right[i - middle] = arr[i];
			}
			return merge(mergeSort(left), mergeSort(right));
		}
	}

	/*
	 * a and b are sorted
	 */
	private <T extends Comparable<T>> T[] merge(T[] a, T[] b) {
		int i = 0;
		int j = 0;
		int k = 0;

		int aSize = a.length;
		int bSize = b.length;

		@SuppressWarnings("unchecked")
		T[] result = (T[]) Array.newInstance(a[0].getClass(), aSize + bSize);

		while (i < aSize && j < bSize) {
			if (firstLess(a[i], b[j]) || same(a[i], b[j])) {
				result[k] = a[i++];
			} else {
				result[k] = b[j++];
			}
			k++;
		}

		while (i < aSize) {
			result[k] = a[i];
			i++;
			k++;
		}

		while (j < bSize) {
			result[k] = b[j];
			j++;
			k++;
		}

		return result;
	}
}
