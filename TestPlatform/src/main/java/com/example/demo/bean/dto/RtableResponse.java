package com.example.demo.bean.dto;

import com.example.demo.bean.po.Response;

import java.util.List;

public class RtableResponse extends Response {
    List<Rtable> lists;

    Rtable info;

    public List<Rtable> getLists() {
        return lists;
    }

    public void setLists(List<Rtable> lists) {
        this.lists = lists;
    }

    public Rtable getInfo() {
        return info;
    }

    public void setInfo(Rtable info) {
        this.info = info;
    }
}
