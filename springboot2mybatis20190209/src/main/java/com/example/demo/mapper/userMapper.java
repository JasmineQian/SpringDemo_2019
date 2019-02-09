package com.example.demo.mapper;

import com.example.demo.pojo.User;
import com.example.demo.util.TestPage;

import java.util.List;


public interface userMapper {

	List<User> findAll();

	List<User> selectAll();

	List<User> selectById(int id);

	int countAll();

	int create(User user);

	int updateUserById(User user);

	int deleteUserById(int id);
}
