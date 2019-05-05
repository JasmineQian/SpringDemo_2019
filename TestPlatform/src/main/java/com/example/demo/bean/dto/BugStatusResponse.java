package com.example.demo.bean.dto;

import com.example.demo.common.Response;

import java.util.List;

public class BugStatusResponse extends Response {
    List<BugStatus> lists;

    BugStatus info;

    public List<BugStatus> getLists() {
        return lists;
    }

    public void setLists(List<BugStatus> lists) {
        this.lists = lists;
    }

    public BugStatus getInfo() {
        return info;
    }

    public void setInfo(BugStatus info) {
        this.info = info;
    }
}
