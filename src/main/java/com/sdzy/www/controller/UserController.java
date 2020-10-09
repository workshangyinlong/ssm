package com.sdzy.www.controller;


import com.sdzy.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
用户登录注册跳转以及结果处理处理器
*/


@Controller
@RequestMapping("/public")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login")
    public String loginPage(){
        return "login";
    }

    @RequestMapping("/index")
    public String indexPage(){
        return "index";
    }
}
