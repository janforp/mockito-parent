package com.janita.mock.one.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by Janita on 2017-04-18 20:03
 */
@Data
public class User implements Serializable {

    private String userId;

    private String name;

    private Integer age;

    public User(String userId, String name, Integer age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}
