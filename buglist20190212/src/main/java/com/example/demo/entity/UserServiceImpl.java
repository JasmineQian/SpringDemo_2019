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

    /*private final UserMapper userMapper;

    public BaseUserService(UserMapper userMapper){
        this.userMapper = userMapper;
    }

    @Override
    public boolean insert(UserEntity userEntity) {
        String username = userEntity.getUsername();
        if (exist(username))
            return false;
        userEntity.setRoles(RoleConstant.ROLE_USER);
        int result = userMapper.insert(userEntity);
        return  result == 1;
    }

    @Override
    public UserEntity getByUsername(String username) {
        return userMapper.selectByUsername(username);
    }

    *//**
     * 判断用户是否存在
     * @param username 账号
     * @return 密码
     *//*
    private boolean exist(String username){
        UserEntity userEntity = userMapper.selectByUsername(username);
        return (userEntity != null);
    }*/

}
