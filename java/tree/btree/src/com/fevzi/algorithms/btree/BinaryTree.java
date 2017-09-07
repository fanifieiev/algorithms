package com.fevzi.algorithms.btree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Function;

import com.fevzi.algorithms.tree.Node;
import com.fevzi.algorithms.tree.Tree;

public final class BinaryTree<V extends Comparable<V>> implements Tree<V> {

    private final Node<V> root;

    public BinaryTree(final V value) {
        this.root = new Node<V>(value);
    }

    @Override
    public Node<V> find(final V value) {
        return findIteratively(this.root, value);
    }

    @Override
    public Node<V> insert(final V value) {
        return insert(this.root, value);
    }

    @Override
    public boolean remove(V e) {
        return remove(this.root, e) != null;
    }

    @Override
    public Node<V> findMin() {
        return findMin(this.root);
    }

    @Override
    public Node<V> findMax() {
        return findMaxRecursively(this.root);
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
            walkInReverse(this.root, v -> list.add(v));
            return list;
        }
        return null;
    }

    // ------private section------//

    private void walkDirectly(final Node<V> node, final Function<V, Boolean> function) {
        if (node != null) {
            function.apply(node.getValue());
        }

        if (node.getLeft() != null) {
            walkDirectly(node.getLeft(), function);
        }

        if (node.getRight() != null) {
            walkDirectly(node.getRight(), function);
        }
    }

    private void walkInReverse(final Node<V> node, final Function<V, Boolean> function) {
        if (node.getLeft() != null) {
            walkInReverse(node.getLeft(), function);
        }

        if (node.getRight() != null) {
            walkInReverse(node.getRight(), function);
        }

        if (node != null) {
            function.apply(node.getValue());
        }
    }

    private void walkInternally(final Node<V> node, final Function<V, Boolean> function) {
        if (node.getLeft() != null) {
            walkInternally(node.getLeft(), function);
        }

        if (node != null) {
            function.apply(node.getValue());
        }

        if (node.getRight() != null) {
            walkInternally(node.getRight(), function);
        }
    }

    private boolean isEmpty(final Node<V> node) {
        return node == null;
    }

    private Node<V> findIteratively(final Node<V> root, final V value) {
        Node<V> node = root;
        while (node != null) {
            final int compared = value.compareTo(node.getValue());
            if (compared == 0) {
                return node;
            } else {
                node = compared < 0 ? node.getLeft() : node.getRight();
            }
        }
        return null;
    }

    private Node<V> findRecursively(final Node<V> node, final V value) {
        if (node == null || value.compareTo(node.getValue()) == 0) {
            return node;
        }
        if (value.compareTo(node.getValue()) < 0) {
            return findRecursively(node.getLeft(), value);
        } else {
            return findRecursively(node.getRight(), value);
        }
    }

    private Node<V> insert(final Node<V> node, V value) {
        if (node == null) {
            return new Node<>(value);
        }
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insert(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) >= 0) {
            node.setRight(insert(node.getRight(), value));
        }
        return node;
    }

    private Node<V> remove(Node<V> node, V value) {
        if (node == null) {
            return node;
        }
        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(remove(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(remove(node.getRight(), value));
        } else if (hasBothChildren(node)) {
            node.setValue(findMin(node.getRight()).getValue());
            node.setRight(remove(node.getRight(), node.getValue()));
        } else {
            node = node.getLeft() != null ? node.getLeft() : node.getRight();
        }
        return node;
    }

    private Node<V> findMax(final Node<V> node) {
        Node<V> candidate = node;
        while (candidate.getRight() != null) {
            candidate = candidate.getRight();
        }
        return candidate;
    }

    private Node<V> findMaxRecursively(final Node<V> node) {
        if (node.getRight() == null) {
            return node;
        } else {
            return findMaxRecursively(node.getRight());
        }
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

    private boolean hasBothChildren(final Node<V> node) {
        return node.getLeft() != null && node.getRight() != null;
    }

    private boolean hasNoChildren(final Node<V> node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    private boolean hasOneChild(final Node<V> node) {
        return node.getLeft() != null || node.getRight() != null;
    }
}
