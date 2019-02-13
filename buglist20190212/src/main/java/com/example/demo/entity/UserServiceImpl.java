package com.example.demo.entity;


import com.example.demo.constant.RoleConstant;
import com.example.demo.jdbc.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Primary
public class UserServiceImpl implements UserService {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int insert(UserEntity userEntity) {
        String username =userEntity.getUsername();
        String password =userEntity.getPassword();

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String pass =passwordEncoder.encode(password);
        String nickname =userEntity.getNickname();
        String role ="ROLE_USER";

        String sql = "insert into user(username,password,nickname,roles) values(?,?,?,?)";
        int count = jdbcTemplate.update(sql,username,pass,nickname,role);
        return count;
    }

    @Override
    public UserEntity getByUsername(String username) {
        String sql ="select * from user where username =? ";
        UserEntity userEntity = jdbcTemplate.queryForObject(sql,new UserRowMapper(),username);
        System.out.println(userEntity);
        return userEntity;
    }

}
