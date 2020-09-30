package com.sdzy.www.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
用户登录注册跳转以及结果处理处理器
*/


@Controller
@RequestMapping("/public")
public class UserController {
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }
}
