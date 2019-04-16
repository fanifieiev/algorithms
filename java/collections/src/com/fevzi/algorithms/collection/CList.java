package com.fevzi.algorithms.collection;

public interface CList<E> {

	CList<E> reverse();
	
	boolean add(E element);
	
	int size();
	
	E get(int position);
	
	boolean remove(E element);
	
	boolean remove(int index);
	
	boolean isEmpty();
}
