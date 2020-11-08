package com.example.zero.code.design.creational.factory;


/**
 * 静态工厂方法模式
 * <p/>
 * 将多个工厂方法模式里的方法置为静态的，不需要创建实例，直接调用即可
 * @Author: Mr.Li
 * @Date: 2020/11/4 11:25
 */
public class StaticFac {

    public static Sender mailFactory() {
        return new MailSender();
    }

    public static Sender phoneFactory() {
        return new PhoneSender();
    }

    public static void main(String[] args) {
        Sender sender = StaticFac.phoneFactory();
        sender.send("顶顶顶");
    }
}
