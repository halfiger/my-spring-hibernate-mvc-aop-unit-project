package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ducks")
@Data
public class Duck {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String color;
    private int age;
}
