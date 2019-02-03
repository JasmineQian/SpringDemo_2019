package com.test.mybatis.mapper;

import com.test.mybatis.entity.User;

import java.util.List;

public interface UserMapper {

    User selectById(int id);

    List<User> selectAll();

    int  addUser(User user);

    int updateUser(User user);

    int deleteUserById(int id);
}
