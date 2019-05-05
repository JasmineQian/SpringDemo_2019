package com.example.demo.common;

public class Response {

    String code;
    String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public Response(){
        this.code=Message.SUCCESS_CODE;
        this.msg=Message.SUCCESS_MESSAGE;
    }
}
