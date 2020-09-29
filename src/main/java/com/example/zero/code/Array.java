package com.example.zero.code;

import lombok.Setter;


@Setter
public class Array {

    private int[] items;
    private int count;

    public Array(int length) {
        items = new int[length];
    }

    public void insert(int item) {
        // 判断数组长度是否等于当前索引
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
        for (int i = index; i < count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public static void main(String[] args) {
        Array array = new Array(3);
        array.insert(10);
        array.insert(20);
        array.insert(30);
        array.insert(40);
        array.delete(4);
        array.print();
    }
}
