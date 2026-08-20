package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id ;

    private String title;

    private String author;

    private int price;

    public Book () {}

    public void setId(int id) {
        this.id=id;
    }

    public void setTitle(String title) {
        this.title =  title;
    }

    public void setAuthor(String author) {
        this.author =  author;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "id = " + id + ", title = " + title + ", author = " + author + ", price = " + price;
    }
}
