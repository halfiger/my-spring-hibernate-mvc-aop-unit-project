package com.example.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FishTest {

    @Test
    public void fishName() {
        Fish fish = new Fish();
        fish.setName("Dori");
        String name = fish.getName();
        assertEquals("Dori", name);
    }

    @Test
    public void fishColor() {
        Fish fish = new Fish();
        fish.setColor("Yellow");
        String color = fish.getColor();
        assertEquals("Yellow", color);
    }
}
