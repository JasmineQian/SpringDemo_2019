package com.example.login.service;

import com.example.login.dao.UserRepository;
import com.example.login.domian.MyUserDetails;
import com.example.login.domian.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 从数据库查询用户
        User user = userRepository.findByUsername(username);
        System.out.println(user);
        if(user == null) {
            throw new UsernameNotFoundException("用户" + username + "不存在");
        }
        return new MyUserDetails(user);
    }
}
