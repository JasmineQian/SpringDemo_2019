package com.example.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @RequestMapping("/login")
    public String login() {
        return "login";
    }
}
