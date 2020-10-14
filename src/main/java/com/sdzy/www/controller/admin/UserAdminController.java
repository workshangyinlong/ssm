package com.sdzy.www.controller.admin;

import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.UserAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/userAdmin")
public class UserAdminController {
    @RequestMapping("/userAdmin")
    public String userAdmin(){
        return "/admin/userAdmin";
    }
    @Autowired
    private UserAdminService userAdminService;

    //根据条件,获取数据
    @RequestMapping("/getUserList")
    @ResponseBody
    public List<User> getUserByTelAndEmail(String tel,String email){
        List<User> list=userAdminService.selectByTelAndEmail(tel,email);
        return list;
    }
}
