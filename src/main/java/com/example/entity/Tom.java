package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "toms")
@Data
public class Tom {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String color;
    private int age;
}
