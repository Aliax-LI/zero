package com.example.zero.code;

import lombok.Setter;

import java.util.LinkedList;


@Setter
public class Array {

    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        // 判断数组长度是否等于当前容量
        if (items.length == count) {
            // 对原数组扩容2倍
            int[] newItems = new int[count * 2];
            // 复制原数组的值到新数组中
            for (int i = 0; i < count; i++) {
                newItems[i] = items[i];
            }
            // 将新数组赋值给原数组
            items = newItems;
        }
        // 对数组进行添加元素操作
        items[count++] = item;
    }


    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(items[i]);
        }
    }

    public void delete(int index) {
        // 判断索引是否在该数组中
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        // 对需要删除的后面所有元素向前移动一位
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }


    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (items[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.delete(4);
        array.print();
        String a = "111";
    }
}
