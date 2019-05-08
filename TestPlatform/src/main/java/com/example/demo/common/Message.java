package com.example.demo.common;

public class Message {

    public static final String SUCCESS_CODE = "0000";
    public static final String SUCCESS_MESSAGE = "success";


    public static final String ERROR_CODE = "5000";
    public static final String ERROR_MESSAGE = "system error";

    // token 校验失败
    public static final String TOKEN_INVALID_CODE = "4001";
    public static final String TOKEN_INVALID_MESSAGE = "token.invalid";
    public static final String TOKEN_EXPIRE_MESSAGE = "token.expire";
    // 字段校验失败
    public static final String FIELD_INVALID = "4002";


    public static final String ID_NOT_EXIST_CODE = "4003";
    public static final String ID_NOT_EXIST_MESSAGE = "This id is not exist plsease check";


    public static final String VAR_NOT_EXIST_CODE = "4004";
    public static final String VAR_NOT_EXIST_MESSAGE = "nessary params not eixt plsease check";

    public static final String CAPTCHA_ERROR_CODE= "4003";
    public static final String CAPTCHA_ERROR_MESSAGE= "captcha code is error please try again";



}

