package com.sdzy.www.controller;

import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.UserService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/load")
public class LoginController {
    @Autowired
    private UserService userService;
    @RequestMapping(value="/relLogin",method= RequestMethod.POST)
    @ResponseBody
    public Msg login(String tel, String password, HttpSession session) {
        User user = userService.login(tel);
        Msg msg = ApBean.getBean(Msg.class);
        if(user!=null){
            if(password.equals(user.getPassword())){
                user.setPassword("");
                session.setAttribute("user",user);
            }else{
                msg.setCode(0);
                msg.setMsg("用户名或密码错误！");
            }
        }else{
            msg.setCode(0);
            msg.setMsg("用户名或密码错误！");
        }
        return msg;
    }

    @RequestMapping("/login")
    public String login(){
        return "pagehome/login";
    }

    @RequestMapping("/loginsuccess")
    public String loginsuccess(HttpSession session){
        User user = (User)session.getAttribute("user");
        System.out.println("1__2");
        System.out.println("user = " + user);
        if(user==null){
            return "redirect:/load/login";
        }else{
            return "pagehome/loginsuccess";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/public/index";
    }

}
