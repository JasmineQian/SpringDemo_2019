package com.example.mybatis02;

public enum ConstantsCodeEnum {
    SUCCESS(0, "成功"),
    FAILURE(-1, "失败"),
    INEXISTENCE(1001, "账户不存在"),
    ACCOUNT_ALREADY_EXIST(1002, "账户已存在"),
    PASSWORD_INCORRECT(1003, "密码错误"),
    ACCOUNT_NULL(1004, "账号不能为空"),
    PASSWORD_NULL(1005, "密码不能为空");

    private int code;
    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    ConstantsCodeEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

}
