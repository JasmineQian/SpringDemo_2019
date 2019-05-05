package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Book implements Serializable {

    public static final long seriaVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)//,unique=true)
    private String name;

    @Column(nullable=false)
    private String author;

    @Column(nullable=false)
    private String ontime;

    @Column(nullable=false)
    private int number;

    @Column(nullable=false)
    private float price;

    @Column(nullable=false)
    private String createdt;
    @Column(nullable=false)
    private String updatedt;
    @Column(nullable=false)
    private String creatuid;
    @Column(nullable=false)
    private String updateuid;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getOntime() {
        return ontime;
    }

    public void setOntime(String ontime) {
        this.ontime = ontime;
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

    public String getCreatedt() {
        return createdt;
    }

    public void setCreatedt(String createdt) {
        this.createdt = createdt;
    }

    public String getUpdatedt() {
        return updatedt;
    }

    public void setUpdatedt(String updatedt) {
        this.updatedt = updatedt;
    }

    public String getCreatuid() {
        return creatuid;
    }

    public void setCreatuid(String creatuid) {
        this.creatuid = creatuid;
    }

    public String getUpdateuid() {
        return updateuid;
    }

    public void setUpdateuid(String updateuid) {
        this.updateuid = updateuid;
    }

    protected Book(){super();};

    public Book(String name, String author, String ontime, int number, float price, String createdt, String updatedt, String creatuid, String updateuid) {
        this.name = name;
        this.author = author;
        this.ontime = ontime;
        this.number = number;
        this.price = price;
        this.createdt = createdt;
        this.updatedt = updatedt;
        this.creatuid = creatuid;
        this.updateuid = updateuid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", ontime='" + ontime + '\'' +
                ", number=" + number +
                ", price=" + price +
                ", createdt='" + createdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                ", creatuid='" + creatuid + '\'' +
                ", updateuid='" + updateuid + '\'' +
                '}';
    }
}
