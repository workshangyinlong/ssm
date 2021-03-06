package com.sdzy.www.controller;


import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.UserService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

/*
用户登录注册跳转以及结果处理处理器
*/


@Controller
@RequestMapping("/public")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(){
        return "pagehome/register";
    }

    //注册,判断手
    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    @ResponseBody
    public Msg registPage(@RequestParam Map<String,String> map, HttpSession session) {
        String tel = map.get("tel");
        String password = map.get("password");
        String email = map.get("email");
        String invitation = map.get("invitation");
        //判断数据是否存在
        String reltel = userService.getTel(tel);
        String relemail = userService.getEmail(email);
        String relinvaitation = userService.getInvitation(invitation);
        Msg msg = ApBean.getBean(Msg.class);
        if (reltel != null) {
            msg.setCode(0);
            msg.setMsg("该用户名已注册");
            return msg;
        }
        if (relemail != null) {
            msg.setCode(0);
            msg.setMsg("该邮箱已注册");
            return msg;
        }
        if (relinvaitation == null) {
            msg.setCode(0);
            msg.setMsg("激活码不正确,或激活码未填写,请重新确认");
            return msg;
        } else {
            User user = ApBean.getBean(User.class);
            user.setTel(tel);
            user.setPassword(password);
            user.setEmail(email);
            String s = UUID.randomUUID().toString();
            String[] split = s.split("-");

            user.setInvitation(split[0]);
            userService.regist(user);
            user.setPassword("");
            session.setAttribute("user",user);
            msg.setMsg("注册成功");
            return  msg;
        }
        //msg.setCode(1);


    }

    @RequestMapping("/index")
    public String index(){
        return "pagehome/index";
    }
}
