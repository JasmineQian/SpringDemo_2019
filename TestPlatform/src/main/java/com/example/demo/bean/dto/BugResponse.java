package com.example.demo.bean.dto;

import com.example.demo.common.Response;

import java.util.List;

public class BugResponse extends Response {

    List<Bug> buglists;

    Bug buginfo;

    public List<Bug> getBuglists() {
        return buglists;
    }

    public void setBuglists(List<Bug> buglists) {
        this.buglists = buglists;
    }

    public Bug getBuginfo() {
        return buginfo;
    }

    public void setBuginfo(Bug buginfo) {
        this.buginfo = buginfo;
    }
}
