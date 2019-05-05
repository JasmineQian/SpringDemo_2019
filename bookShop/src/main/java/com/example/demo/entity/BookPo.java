package com.example.demo.entity;

import javax.persistence.Column;
import java.io.Serializable;


public class BookPo implements Serializable {


    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int number;

    @Column(nullable = false)
    private float price;

    protected BookPo() {
        super();
    }

    ;

    public BookPo(String name, String author, int number, float price) {
        this.name = name;
        this.author = author;
        this.number = number;
        this.price = price;
    }

    @Override
    public String toString() {
        return "BookPo{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", number=" + number +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
