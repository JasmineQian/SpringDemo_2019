package com.example.demo.bean.dto;

import com.example.demo.bean.po.Page;

public class TaskSearchRequest extends Page {

    private String pname;
    private String crnum;
    private String taskname;

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getCrnum() {
        return crnum;
    }

    public void setCrnum(String crnum) {
        this.crnum = crnum;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }
}
