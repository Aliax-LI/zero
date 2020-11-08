package com.example.zero.code.design.creational.singleton;


/**
 * 懒汉式单例
 * <p/>
 * 该模式的特点是类加载时没有生成单例，
 * 只有当第一次调用 getlnstance 方法时才去创建这个单例。
 * @Author: Mr.Li
 * @Date: 2020/11/5 9:46
 */
public class LazySingleton {

    //保证 instance 在所有线程中同步
    private static volatile LazySingleton INSTANCE = null;

    //private 避免类在外部被实例化
    private LazySingleton(){}

    //getInstance 方法前加同步
    public static synchronized LazySingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazySingleton();
        }
        return INSTANCE;
    } 

}
