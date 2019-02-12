package com.example.demo.service;

import com.example.demo.entity.UserEntity;

public interface UserService {

    int insert(UserEntity userEntity);

    UserEntity getUserByname(String name);

}
