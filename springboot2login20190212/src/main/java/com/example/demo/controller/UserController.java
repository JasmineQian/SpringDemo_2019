package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping(value="/hello1")
    @ResponseBody
    public String hello(){return "=======Welcome to HelloWorld==============";}


    @RequestMapping("/login")
    public String login() {
        //这边我们,默认是返到templates下的login.html
        return "baklogin";
    }
}
