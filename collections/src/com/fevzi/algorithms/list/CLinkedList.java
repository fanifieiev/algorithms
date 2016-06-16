package com.fevzi.algorithms.list;

public final class CLinkedList<E> implements CList<E> {

	private Node<E> head;
	private int size = 0;

	public CLinkedList() {
	}

	public CLinkedList(Node<E> node) {
		this.head = node;
	}

	@Override
	public CLinkedList<E> reverse() {
		if (head == null || head.next == null) {
			return this;
		}
		Node<E> prev = null;
		Node<E> current = head;
		Node<E> next = null;

		while (current.next != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		current.next = prev;
		return new CLinkedList<E>(current);
	}

	@Override
	public boolean add(E element) {
		Node<E> node = new Node<>(element);
		if (head == null) {
			head = node;
		} else {
			Node<E> tempNode = head;
			while (tempNode.next != null) {
				tempNode = tempNode.next;
			}
			tempNode.next = node;
		}
		size++;
		return true;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E get(int position) {
		Node<E> node = getNode(position);
		return node.data;
	}

	@Override
	public boolean remove(E element) {
		return false;
	}

	@Override
	public boolean remove(int index) {
		Node<E> element = getNode(index);
		if (element != null) {
			
			
			
			element.next = null;
			element = null;
			size--;
			return true;
		}
		return false;
	}

	private Node<E> getNode(int position) {
		Node<E> current = head;
		for (int i = 0; i < position; i++) {
			current = current.next;
		}
		return current;
	}

	private static final class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			super();
			this.data = data;
		}
	}

}
