package com.example.demo.bean.dto;

public class Task {

    private int taskid;
    private int task_pid;
    private String task_project;
    private int task_tid;
    private String task_tname;
    private String taskname;
    private String crnum;
    private String description;
    private String details;
    private String note;
    private String creationdt;
    private String updatedt;
    private String creationuid;
    private String updateuid;

    public int getTaskid() {
        return taskid;
    }

    public void setTaskid(int taskid) {
        this.taskid = taskid;
    }

    public int getTask_pid() {
        return task_pid;
    }

    public void setTask_pid(int task_pid) {
        this.task_pid = task_pid;
    }

    public String getTask_project() {
        return task_project;
    }

    public void setTask_project(String task_project) {
        this.task_project = task_project;
    }

    public int getTask_tid() {
        return task_tid;
    }

    public void setTask_tid(int task_tid) {
        this.task_tid = task_tid;
    }

    public String getTask_tname() {
        return task_tname;
    }

    public void setTask_tname(String task_tname) {
        this.task_tname = task_tname;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getCrnum() {
        return crnum;
    }

    public void setCrnum(String crnum) {
        this.crnum = crnum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getCreationdt() {
        return creationdt;
    }

    public void setCreationdt(String creationdt) {
        this.creationdt = creationdt;
    }

    public String getUpdatedt() {
        return updatedt;
    }

    public void setUpdatedt(String updatedt) {
        this.updatedt = updatedt;
    }

    public String getCreationuid() {
        return creationuid;
    }

    public void setCreationuid(String creationuid) {
        this.creationuid = creationuid;
    }

    public String getUpdateuid() {
        return updateuid;
    }

    public void setUpdateuid(String updateuid) {
        this.updateuid = updateuid;
    }
}
