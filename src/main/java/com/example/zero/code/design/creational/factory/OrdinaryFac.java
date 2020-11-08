package com.example.zero.code.design.creational.factory;

/**
 * 简单工厂模式
 * </p>
 * 建立一个工厂类，对实现了同一接口的一些类进行实例的创建
 * @Author: Mr.Li
 * @Date: 2020/11/4 11:05
 */
public class OrdinaryFac {

    public Sender produce(String type) {
        if ("mail".equals(type)) {
            return new MailSender();
        }
        if ("phone".equals(type)) {
            return new PhoneSender();
        }
        System.out.println("请输入正确的类型");
        return null;
    }

    public static void main(String[] args) {
        OrdinaryFac ordinaryFac = new OrdinaryFac();
        Sender mail = ordinaryFac.produce("mail");
        mail.send("哈哈哈哈");
    }
}

interface Sender {
    void send(String data);
}


class MailSender implements Sender {

    @Override
    public void send(String data) {
        System.out.println("发送"+ data +"消息到邮箱成功");
    }
}

class PhoneSender implements Sender {

    @Override
    public void send(String data) {
        System.out.println("发送"+ data +"消息到手机成功");
    }
}