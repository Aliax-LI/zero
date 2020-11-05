package com.example.zero.code.design.singleton;


/**
 * 饿汉式单例
 * <p/>
 * 该模式的特点是类一旦加载就创建一个单例，
 * 保证在调用 getInstance 方法之前单例已经存在了
 * @Author: Mr.Li
 * @Date: 2020/11/5 9:45
 */
public class EagerSingleton {

    private final static EagerSingleton INSTANCE = new EagerSingleton();

    private EagerSingleton() {};


    public static EagerSingleton getInstance() {
        return INSTANCE;
    }


}
