package com.example.zero.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

/**
 * @program: zero
 * @description:
 * @author: Mr.Li
 * @create: 2020-09-09 21:18
 **/

@Data
public class Person {

    private UUID id;

    @NotBlank(message = "名字不能为空")
    private String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}
