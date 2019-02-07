package com.example.demo.service;

import com.example.demo.pojo.User;

import java.util.List;

public interface userService {

	List<User> findAll();

	List<User> selectAll();

	List<User> selectById(int id);

	int create(User user);

	int updateUserById(User user);

	int deleteUserById(int id);
}
