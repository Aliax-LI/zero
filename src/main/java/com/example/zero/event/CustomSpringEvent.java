package com.example.zero.event;


import org.springframework.context.ApplicationEvent;
import org.springframework.lang.NonNull;
import org.springframework.util.Assert;

/**
 * 系统通知事件
 * @Author: Mr.Li
 * @Date: 2020/10/14 13:50
 */
public abstract class CustomSpringEvent<T> extends ApplicationEvent {

    // 该类型事件存放的信息
    private final T message;


    /**
     * @Author: Mr.Li
     * @Date: 2020/10/14 14:13
     * @param source: 最初促发该事件的对象
     * @param message: 该类型事件携带的信息
     */
    public CustomSpringEvent(Object source, @NonNull T message) {

        super(source);
        Assert.notNull(message, "message must not be null");
        this.message = message;
    }

    @NonNull
    public T getMessage() {
        return message;
    }
}
