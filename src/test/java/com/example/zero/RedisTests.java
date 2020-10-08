package com.example.zero;

import com.example.zero.model.Person;
import com.example.zero.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import java.util.UUID;

@SpringBootTest
public class RedisTests {

    @Autowired
    private RedisUtils redisUtils;


    @Test
    void testRedisString() {
        Person person = new Person(UUID.randomUUID(), "张三");
        redisUtils.set("person:0", person);
        System.out.println(redisUtils.get("person:0"));
    }
}
