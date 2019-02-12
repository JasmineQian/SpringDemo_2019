package com.example.demo.service.impl;


import com.example.demo.jdbc.UserRowMapper;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(UserEntity userEntity) {
        String username =userEntity.getName();
        String password =userEntity.getPassword();
        String nickname =userEntity.getNickname();
        String role =userEntity.getRole();

        String sql = "insert into user(username,password,nickname,roles) values(?,?,?,?)";
        int count = jdbcTemplate.update(sql,username,password,nickname,role);
        return count;
    }

    @Override
    public UserEntity getUserByname(String name) {
        String sql ="select * from user where username =? ";
        UserEntity userEntity = jdbcTemplate.queryForObject(sql,new UserRowMapper(),name);
        System.out.println(userEntity);
        return userEntity;
    }
}
