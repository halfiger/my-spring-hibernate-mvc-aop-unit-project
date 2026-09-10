package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "frogs")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Frog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String color;
    private int age;
}
