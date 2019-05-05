package com.example.demo.bean.dto;

public class BugRequest {

    private String timestamp;
    private Integer id;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "BugRequest{" +
                "timestamp='" + timestamp + '\'' +
                ", id=" + id +
                '}';
    }
}
