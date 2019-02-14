package com.example.demo.controller;


import com.example.demo.entity.UserEntity;
import com.example.demo.entity.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/index", "/home"})
    public String root(){
        return "index";
    }

/*    @GetMapping("/login")
    public String login(){
        return "login";
    }*/

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(UserEntity userEntity){

        int count=userService.insert(userEntity);


        // 此处省略校验逻辑
        if (count>0)
            return "redirect:register?success";
        return "redirect:register?error";
    }

}