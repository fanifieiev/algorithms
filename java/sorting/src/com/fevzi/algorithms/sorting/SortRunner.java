package com.fevzi.algorithms.sorting;

import java.util.Arrays;

public class SortRunner {

	public static void main(String[] args) {
		Integer[] ints = { 10, 2, 6, 5, 45, 11 };
		SortMethod sortable = new MergeSort();
		sortable.sort(ints);
		System.out.println(Arrays.toString(ints));
	}
}
