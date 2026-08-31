package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String color;

    private int age;

    public void setId (int id) {
        this.id = id;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setColor (String color) {
        this.color = color;
    }

    public void setAge (int age) {
        this.age = age;
    }

    public int getId () {
        return id;
    }

    public String getName () {
        return name;
    }

    public String getColor () {
        return color;
    }

    public int getAge () {
        return age;
    }

    @Override
    public String toString () {
        return id + "  = id " + name + " = name";
    }
}
