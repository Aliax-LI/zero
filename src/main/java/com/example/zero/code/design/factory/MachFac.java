package com.example.zero.code.design.factory;


/**
 * 多个工厂方法模式
 * <p/>
 * 是对普通工厂方法模式的改进，在普通工厂方法模式中，如果传递的字符串出错，
 * 则不能正确创建对象，而多个工厂方法模式是提供多个工厂方法
 *
 * @Author: Mr.Li
 * @Date: 2020/11/4 11:19
 */
public class MachFac {

    public Sender mailFactory() {
        return new MailSender();
    }

    public Sender phoneFactory() {
        return new PhoneSender();
    }

    public static void main(String[] args) {
        MachFac machFac = new MachFac();
        Sender sender = machFac.phoneFactory();
        sender.send("哒哒哒");
    }
}

