package com.example.demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Customer implements Serializable {

    public static final long seriaVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=true)
    private String name;

    @Column(nullable=false)
    private String createdt;
    @Column(nullable=false)
    private String updatedt;
    @Column(nullable=false)
    private String createuid;
    @Column(nullable=false)
    private String updateuid;

    protected Customer(){super();};

    public Customer(String name, String createdt, String updatedt, String createuid, String updateuid) {
        this.name = name;
        this.createdt = createdt;
        this.updatedt = updatedt;
        this.createuid = createuid;
        this.updateuid = updateuid;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdt='" + createdt + '\'' +
                ", updatedt='" + updatedt + '\'' +
                ", createuid='" + createuid + '\'' +
                ", updateuid='" + updateuid + '\'' +
                '}';
    }

    public static long getSeriaVersionUID() {
        return seriaVersionUID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCreateuid() {
        return createuid;
    }

    public void setCreateuid(String createuid) {
        this.createuid = createuid;
    }

    public String getUpdateuid() {
        return updateuid;
    }

    public void setUpdateuid(String updateuid) {
        this.updateuid = updateuid;
    }
}
