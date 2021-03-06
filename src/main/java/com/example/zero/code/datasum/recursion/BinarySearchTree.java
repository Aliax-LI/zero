package com.example.zero.code.datasum.recursion;

import java.nio.BufferUnderflowException;

/**
 * 二叉查找树构建
 * @Author: Mr.Li
 * @Date: 2020/12/3 11:04
 */
public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private static class BinaryNode<AnyType> {
        // 该节点元素
        AnyType element;
        // 左儿子节点
        BinaryNode<AnyType> left;
        // 右儿子节点
        BinaryNode<AnyType> right;
        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }
        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt) {
            element = theElement; left = lt; right = rt;
        }
    }

    private BinaryNode<AnyType> root;

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(AnyType x) {
        return contains(x, root);
    }

    public AnyType findMin() {
        if (isEmpty())
            throw new BufferUnderflowException();
        return findMin(root).element;
    }

    public AnyType findMax() {
        if (isEmpty())
            throw new BufferUnderflowException();
        return findMax(root).element;
    }

    public void insert(AnyType x) {
        root = insert(x, root);
    }

    public void remove(AnyType x) {
        root = remove(x, root);
    }

    public void printTree() {
        if (isEmpty())
            System.out.println("Empty Tree");
        else
            printTree(root);
    }

    private boolean contains(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return false;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true;
    }
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> t) {
        if (t == null)
            return null;
        else if(t.left == null)
            return t;
        return findMin(t.left);
    }

    private BinaryNode<AnyType> findMax(BinaryNode<AnyType> t) {
        if (t != null)
            while (t.right != null)
                t = t.right;
        return t;
    }

    private BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return new BinaryNode<>(x, null, null);
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ;
        return t;
    }

    private BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t) {
        if (t == null)
            return t;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        }
        else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    private void printTree(BinaryNode<AnyType> t) {
        if (t != null) {
            printTree(t.left);
            System.out.println(t.element);
            printTree(t.right);
        }
    }
}
