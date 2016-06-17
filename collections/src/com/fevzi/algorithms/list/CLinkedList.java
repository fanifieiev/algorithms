package com.fevzi.algorithms.list;

public final class CLinkedList<E> implements CList<E> {

	private Node<E> head;
	private int size = 0;

	public CLinkedList() {
	}

	public CLinkedList(Node<E> node) {
		addNode(node);
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
		return addNode(node);
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
		Node<E> node = getNode(element);
		return removeNode(node);
	}

	@Override
	public boolean remove(int index) {
		Node<E> node = getNode(index);
		return removeNode(node);
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	private boolean removeNode(Node<E> node) {
		boolean removed = false;
		if (node != null) {
			if (node == head) {
				head = head.next;
			} else {
				Node<E> currentNode = head.next;
				while (currentNode.next != null && !removed) {
					if (currentNode.next.data.equals(node.data)) {
						removed = true;
						currentNode.next = currentNode.next.next;
						node.next = null;
						node = null;
						size--;
					}
				}
			}
		}
		return removed;
	}

	private Node<E> getNode(int position) {
		Node<E> current = head;
		for (int i = 0; i < position; i++) {
			current = current.next;
		}
		return current;
	}

	private Node<E> getNode(E element) {
		Node<E> current = head;
		while (current.next != null) {
			if (element.equals(current.data)) {
				return current;
			}
			current = current.next;
		}
		return null;
	}

	private boolean addNode(Node<E> node) {
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

	private static final class Node<E> {
		E data;
		Node<E> next;

		Node(E data) {
			super();
			this.data = data;
		}
	}

}
