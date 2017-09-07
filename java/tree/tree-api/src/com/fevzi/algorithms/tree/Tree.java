package com.fevzi.algorithms.tree;

import java.util.Collection;

public interface Tree<E extends Comparable<E>> {

	Node<E> insert(E e);
	
	boolean remove(E e);

	Node<E> find(E e);

	Node<E> findMin();

	Node<E> findMax();

	boolean isEmpty();
	
	int depth();
	
	Collection<E> list();
}
