package com.example.zero.code.design.creational.prototype;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProtoTypeShape {

    public static void main(String[] args) {
        ProtoTypeManager typeManager = new ProtoTypeManager();
        Shape circular = typeManager.getShape("square");
        circular.countArea();

    }

}

interface Shape extends Cloneable {
    Object clone();
    void countArea();
}

class Circular implements Shape {

    @Override
    public Object clone() {
        Circular circular = null;
        try {
            circular = (Circular) super.clone();
        } catch (CloneNotSupportedException  e) {
            System.out.println("拷贝圆形失败");
        }
        return circular;
    }

    @Override
    public void countArea() {
        int radius = 0;
        System.out.print("这是一个圆，请输入圆的半径：");
        Scanner input=new Scanner(System.in);
        radius=input.nextInt();
        System.out.println("该圆的面积="+3.1415*radius*radius+"\n");
    }
}

class Square implements Shape {

    @Override
    public Object clone() {
        Square square = null;
        try {
            square = (Square) super.clone();
        } catch (CloneNotSupportedException  e) {
            System.out.println("拷贝正方形失败");
        }
        return square;
    }

    @Override
    public void countArea() {
        int sideChief = 0;
        System.out.print("这是一个正方形，请输入正方形的边长：");
        Scanner input=new Scanner(System.in);
        sideChief=input.nextInt();
        System.out.println("该正方形的面积="+ sideChief * sideChief +"\n");
    }
}

class ProtoTypeManager{
    private final Map<String, Shape> ht = new HashMap<>();

    public ProtoTypeManager() {
        ht.put("square", new Square());
        ht.put("circular", new Circular());
    }

    public void addShape(String key, Shape object) {
        ht.put(key, object);
    }

    public Shape getShape(String key) {
        Shape shape = ht.get(key);
        return (Shape) shape.clone();
    }
}