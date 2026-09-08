package com.example.entity;

import jakarta.persistence.*;
import lombok.*;


@Setter
@Getter
@ToString
@AllArgsConstructor
@Entity
@Table(name="Mice")
@NoArgsConstructor
public class Mouse {
    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String cheese;

    private String age;

}
