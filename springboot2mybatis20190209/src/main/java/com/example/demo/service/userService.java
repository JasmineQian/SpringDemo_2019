package com.example.demo.service;

import com.example.demo.pojo.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface userService {

	List<User> findAll(int currentPage,int pageSize);

	List<User> selectAll();

	List<User> selectById(int id);

	int countAll();

	int create(User user);

	int updateUserById(User user);

	int deleteUserById(int id);
}
