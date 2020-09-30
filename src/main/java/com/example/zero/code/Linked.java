package com.example.zero.code;

import java.util.NoSuchElementException;

public class Linked<E> {

    transient Node<E> first;

    transient Node<E> last;

    transient int size = 0;

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    public Linked() {
    }


    void addLast(E item) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<E>(item, l, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    void addFirst(E item) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(item, null, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size ++;
    }

    public boolean add(E item) {
        addLast(item);
        return true;
    }

    public E removeList() {
        final Node<E> head = first;
        if (head == null)
            throw new NoSuchElementException();
        final E item = head.item;
        final Node<E> next = head.next;
        head.item = null;
        head.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return item;
    }






}
