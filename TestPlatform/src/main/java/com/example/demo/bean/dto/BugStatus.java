package com.example.demo.bean.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Bug状态的实体类",description = "这是BugStatus对象")
public class BugStatus {

    @ApiModelProperty(value="Bug状态的ID", example="1")
    private int id;

    @ApiModelProperty(value="Bug的状态", example="关闭")
    private String bugStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBugStatus() {
        return bugStatus;
    }

    public void setBugStatus(String bugStatus) {
        this.bugStatus = bugStatus;
    }
}
