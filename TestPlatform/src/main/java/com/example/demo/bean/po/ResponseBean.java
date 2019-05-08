package com.example.demo.bean.po;

import java.io.Serializable;

public class ResponseBean<T>  extends Response implements Serializable {

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
