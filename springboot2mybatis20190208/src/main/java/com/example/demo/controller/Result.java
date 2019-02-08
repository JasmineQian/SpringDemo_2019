package com.example.demo.controller;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
	private String code;
	private String msg;
	private T data;

	public Result() {
	}

	public Result(String code, String msg) {
		this(code, msg, null);
	}

	public Result(String code, String msg, T data) {
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public Result(Errors errors) {
		StringBuilder msg = new StringBuilder();
		errors.getFieldErrors().forEach((ObjectError error) -> {
			msg.append(error.getDefaultMessage() + "\n");
		});

		this.code = "E01";
		this.msg = msg.toString();
	}


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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}