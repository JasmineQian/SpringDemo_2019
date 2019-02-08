package com.example.demo.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "类")
public class User implements Serializable {
	@ApiModelProperty(value = "用户ID")
	private int id;
	@ApiModelProperty(value = "用户姓名")
	private String name;
	@ApiModelProperty(value = "用户年龄")
	private int age;
	@ApiModelProperty(value = "用户手机")
	private String phone;
	@ApiModelProperty(value = "用户密码")
	private String password;
	@ApiModelProperty(value = "用户标记")
	private boolean flag;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
