package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "birds")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Bird {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String color;
    private int age;
}
