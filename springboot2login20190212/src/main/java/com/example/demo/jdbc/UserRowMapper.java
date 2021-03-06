package com.example.demo.jdbc;


import com.example.demo.entity.UserEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserEntity> {
    @Override
    public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        //此处要使用表中的字段，不能使用属性
        int id =resultSet.getInt("id");
        String username = resultSet.getString("username");
        String password = resultSet.getString("password");
        String nickname = resultSet.getString("nickname");
        String role = resultSet.getString("roles");

        UserEntity userEntity = new UserEntity();
        userEntity.setId(id);
        userEntity.setName(username);
        userEntity.setPassword(password);
        userEntity.setNickname(nickname);
        userEntity.setRole(role);

        return userEntity;
    }
}
