package com.sdzy.www.controller;


import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.UserService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

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

    @Autowired
    private UserService userService;

    @RequestMapping("/regist")
    //注册,判断手
    public Msg registPage(@RequestParam Map<String,String> map) {

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
            user.setPassWord(password);
            user.setEmail(email);
            user.setInvitation(invitation);
            userService.regist(user);

        }
        //msg.setCode(1);
        msg.setMsg("注册成功");
        return  msg;

    }
}
