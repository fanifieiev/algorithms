package com.fevzi.algorithms.list;

public final class CSingleLinkedList<E> implements CList<E> {

    private ListNode<E> head;
    private int size = 0;

    public CSingleLinkedList() {
    }

    public CSingleLinkedList(ListNode<E> node) {
        addNode(node);
    }

    @Override
    public CSingleLinkedList<E> reverse() {
        if (head == null || head.next == null) {
            return this;
        }
        ListNode<E> prev = null;
        ListNode<E> current = head;
        ListNode<E> next = null;

        while (current.next != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        current.next = prev;
        return new CSingleLinkedList<E>(current);
    }

    @Override
    public boolean add(E element) {
        ListNode<E> node = new ListNode<>(element);
        return addNode(node);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int position) {
        ListNode<E> node = getNode(position);
        return node.data;
    }

    @Override
    public boolean remove(E element) {
        ListNode<E> node = getNode(element);
        return removeNode(node);
    }

    @Override
    public boolean remove(int index) {
        ListNode<E> node = getNode(index);
        return removeNode(node);
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private boolean removeNode(ListNode<E> node) {
        boolean removed = false;
        if (node != null) {
            if (node == head) {
                head = head.next;
            } else {
                ListNode<E> currentNode = head.next;
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

    private ListNode<E> getNode(int position) {
        ListNode<E> current = head;
        for (int i = 0; i < position; i++) {
            current = current.next;
        }
        return current;
    }

    private ListNode<E> getNode(E element) {
        assert element != null;
        for (ListNode<E> current = head; current != null; current = current.next) {
            if (element.equals(current.data)) {
                return current;
            }
        }
        return null;
    }

    private boolean addNode(ListNode<E> node) {
        if (head == null) {
            head = node;
        } else {
            ListNode<E> tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = node;
        }
        size++;
        return true;
    }

    private static final class ListNode<E> {
        E data;
        ListNode<E> next;

        ListNode(E data) {
            super();
            this.data = data;
        }
    }

}
