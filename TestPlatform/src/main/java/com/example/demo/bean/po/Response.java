package com.example.demo.bean.po;

import com.example.demo.common.Message;

import java.io.Serializable;

public class Response implements Serializable {

    String code;
    String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return message;
    }

    public void setMsg(String msg) {
        this.message = msg;
    }

    public Response(){
        this.code=Message.SUCCESS_CODE;
        this.message=Message.SUCCESS_MESSAGE;
    }
}
