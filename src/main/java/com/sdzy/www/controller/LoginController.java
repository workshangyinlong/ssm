package com.sdzy.www.controller;

import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/load")

public class LoginController {
    private UserService userService;
    @RequestMapping("/relLogin")
    public Msg login(String tel, String password, HttpSession session) {
        User user = userService.login(tel);
        Msg msg = new Msg();
        if(user!=null){
            if(password==user.getPassword()){
                user.setPassword("");
                session.setAttribute("user",user);
            }
        }else{
            msg.setCode(0);
            msg.setMsg("用户名或密码错误！");
        }
        return msg;
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

}
