package com.fevzi.algorithms.list;

public final class CArrayList<E> implements CList<E> {

	private static final int DEFAULT_CAPACITY = 10;

	private static final Object[] EMPTY_ARRAY = {};

	private Object[] elements;

	private int size = 0;

	public CArrayList(final int capacity) {
		if (capacity > 0) {
			elements = new Object[capacity];
		} else if (capacity == 0) {
			elements = EMPTY_ARRAY;
		} else {
			throw new IllegalArgumentException(String.format("Capacity cannot be negative with value '%d'", capacity));
		}
	}

	public CArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public CList<E> reverse() {
		// TODO:implement
		return null;
	}

	@Override
	public boolean add(E element) {
		// TODO: implement
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E get(int position) {
		// TODO: implement
		return null;
	}

	@Override
	public boolean remove(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

}
