package com.fevzi.algorithms.list;

public interface CList<E> {

	CList<E> reverse();
	
	boolean add(E element);
	
	int size();
	
	E get(int position);
	
	boolean remove(E element);
	
	boolean remove(int index);
}
