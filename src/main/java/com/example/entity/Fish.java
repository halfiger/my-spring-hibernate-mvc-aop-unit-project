package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "fishes")
@Data
public class Fish {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String color;
    private int age;
}
