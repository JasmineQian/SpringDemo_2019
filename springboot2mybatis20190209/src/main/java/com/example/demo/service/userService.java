package com.example.demo.service;

import com.example.demo.pojo.User;
import com.example.demo.pojo.Page;


import java.util.List;

public interface userService {

	List<User> findAll(Page page);

	List<User> findAllByConditions(User user);

	List<User> findAllByCondition(User user);

	List<User> selectAll();

	List<User> selectById(int id);

	int countAll();

	int create(User user);

	int updateUserById(User user);

	int deleteUserById(int id);
}
