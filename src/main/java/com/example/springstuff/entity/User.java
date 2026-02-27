package com.example.springstuff.entity;

import org.springframework.stereotype.Component;

@Component
public class User {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public User() {
    }

    public String getName() {
        return name;
    }


    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }
}
