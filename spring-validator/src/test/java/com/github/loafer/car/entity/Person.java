package com.github.loafer.car.entity;

import javax.validation.constraints.NotNull;

/**
 * @author zhaojh.
 */
public class Person {
    @NotNull
    private String name;

    public Person(String name) {
        this.name = name;
    }
}
