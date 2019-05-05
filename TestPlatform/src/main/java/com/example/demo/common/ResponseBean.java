package com.example.demo.common;

public class ResponseBean<T> {

    private T data;
    private String code;
    private String message;


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseBean() {
        this.code = Message.SUCCESS_CODE;
        this.message = Message.SUCCESS_MESSAGE;
    }


    public ResponseBean(T data) {
        this.code = Message.SUCCESS_CODE;
        this.message = Message.SUCCESS_MESSAGE;
        this.data = data;
    }
}
