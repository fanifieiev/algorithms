package com.fevzi.algorithms.btree;

import java.util.ArrayList;
import java.util.Collection;

import com.fevzi.algorithms.tree.Node;
import com.fevzi.algorithms.tree.Tree;

public final class BinaryTree<V extends Comparable<V>> implements Tree<V> {

	private final Node<V> root;

	public BinaryTree(final V value) {
		this.root = new Node<V>(value);
	}

	@Override
	public Node<V> find(final V value) {
		return find(this.root, value);
	}

	@Override
	public Node<V> insert(final V value) {
		return insert(this.root, value);
	}

	@Override
	public boolean remove(V e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Node<V> findMin() {
		return findMin(this.root);
	}

	@Override
	public Node<V> findMax() {
		return findMax(this.root);
	}

	@Override
	public boolean isEmpty() {
		return isEmpty(this.root);
	}

	@Override
	public int depth() {
		return depth(this.root);
	}

	@Override
	public Collection<V> list() {
		if (!isEmpty(this.root)) {
			final Collection<V> list = new ArrayList<>();
			walkInReverse(this.root, list);
			return list;
		}
		return null;
	}

	// ------private section------//

	private void walkDirectly(final Node<V> node, final Collection<V> container) {
		if (node != null) {
			container.add(node.getValue());
		}

		if (node.getLeft() != null) {
			walkDirectly(node.getLeft(), container);
		}

		if (node.getRight() != null) {
			walkDirectly(node.getRight(), container);
		}
	}

	private void walkInReverse(final Node<V> node, final Collection<V> container) {
		if (node.getLeft() != null) {
			walkInReverse(node.getLeft(), container);
		}

		if (node.getRight() != null) {
			walkInReverse(node.getRight(), container);
		}
		
		if (node != null) {
			container.add(node.getValue());
		}
	}
	
	private void walkInternally(final Node<V> node, final Collection<V> container) {
		if (node.getLeft() != null) {
			walkInternally(node.getLeft(), container);
		}

		if (node != null) {
			container.add(node.getValue());
		}
		
		if (node.getRight() != null) {
			walkInternally(node.getRight(), container);
		}
	}

	
	private boolean isEmpty(final Node<V> node) {
		return node == null;
	}

	private Node<V> find(final Node<V> root, final V value) {
		Node<V> node = root;
		while (node != null) {
			final int compared = value.compareTo(node.getValue());
			if (compared == 0) {
				return node;
			} else if (compared < 0) {
				node = node.getLeft();
			} else {
				node = node.getRight();
			}
		}
		return null;
	}

	private Node<V> insert(final Node<V> node, V value) {
		if (node == null) {
			return new Node<>(value);
		}
		if (value.compareTo(node.getValue()) < 0) {
			node.setLeft(insert(node.getLeft(), value));
		} else if (value.compareTo(node.getValue()) > 0) {
			node.setRight(insert(node.getRight(), value));
		}
		return node;
	}

	private boolean remove(final Node<V> node, V value) {
		if (isEmpty(node)) {
			return false;
		}

		return false;
	}

	private Node<V> findMax(final Node<V> node) {
		Node<V> candidate = node;
		while (candidate.getRight() != null) {
			candidate = candidate.getRight();
		}
		return candidate;
	}

	private Node<V> findMin(final Node<V> node) {
		Node<V> candidate = node;
		while (candidate.getLeft() != null) {
			candidate = candidate.getLeft();
		}
		return candidate;
	}

	private int depth(final Node<V> node) {
		if (node != null) {
			return Math.max(depth(node.getLeft()), depth(node.getRight())) + 1;
		}
		return 0;
	}
}
