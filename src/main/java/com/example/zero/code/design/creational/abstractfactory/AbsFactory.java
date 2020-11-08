package com.example.zero.code.design.creational.abstractfactory;

/**
 * 抽象工厂模式
 * <p/>
 *
 * @Author: Mr.Li
 * @Date: 2020/11/4 11:36
 */
public class AbsFactory {

    public static void main(String[] args) {
        SendMailFactory sendMailFactory = new SendMailFactory();
        Sender produce = sendMailFactory.produce();
        produce.send("大大大");
    }
}


interface Provider {
    Sender produce();
}
class SendMailFactory implements Provider{

    @Override
    public Sender produce() {
        return new MailSender();
    }
}

class SendPhoneFactory implements Provider{

    @Override
    public Sender produce() {
        return new PhoneSender();
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