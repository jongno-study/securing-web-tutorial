package com.chori.springsecurityrest.dto;

public class Foo {
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public Foo setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Foo setName(String name) {
        this.name = name;
        return this;
    }
}
