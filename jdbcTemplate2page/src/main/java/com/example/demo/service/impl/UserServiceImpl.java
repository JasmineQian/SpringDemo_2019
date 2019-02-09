package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.rowMapper.UserRowMapper;
import com.example.demo.service.UserService;
import com.sun.rowset.internal.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service

public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<User> findAll() {
        String sql = "select id, name,age  from user";
        List<User> list = jdbcTemplate.query(sql,new UserRowMapper());

        return list;
    }

    @Override
    public List<User> findAllbyPage(int pagenum, int pagerow) {
        int starter = (pagenum-1)*pagerow;
        String sql = "select id, name, age from user order by id asc  limit " + starter +" , "+ pagerow;
        List<User> list = jdbcTemplate.query(sql,new UserRowMapper());

        return list;
    }

    @Override
    public int countAll() {

        String sql= "select * from user";
        RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
        jdbcTemplate.query(sql,countCallback);
        int count = countCallback.getRowCount();
        System.out.println("目前的条数是"+count);
        return count;
    }
}
