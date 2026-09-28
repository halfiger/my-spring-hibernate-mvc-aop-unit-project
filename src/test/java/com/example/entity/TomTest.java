package com.example.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TomTest {

    @Test
    public void tomName() {
        Tom tom = new Tom();
        tom.setName("Tom");
        String name = tom.getName();
        assertEquals("Tom", name);
    }

    @Test
    public void tomColor () {
        Tom tom = new Tom();
        tom.setColor("White");
        String color = tom.getColor();
        assertEquals("White", color);
    }
}
