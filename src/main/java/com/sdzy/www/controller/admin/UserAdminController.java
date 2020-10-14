package com.sdzy.www.controller.admin;

import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.UserAdminService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserAdminController {
    @Autowired
    private UserAdminService userAdminService;
    @RequestMapping("/userAdmin")
    public String userAdmin(){
        return "admin/userAdmin";
    }


    //根据条件,获取数据
    @RequestMapping("/getUserList")
    @ResponseBody
    public List<User> getUserByTelAndEmail(String tel,String email){

        List<User> list=userAdminService.selectByTelAndEmail(tel,email);
        return list;
    }

    //展现所有用户
    @RequestMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        List<User> users=userAdminService.selectAllUser();
        if(users!=null){
            return users;
        }else {
            return null;
        }

    }
    //密码重置
    @RequestMapping("/repassword")
    @ResponseBody
    public Msg repassword(String id){
        int uid=Integer.valueOf(id);
        Msg msg=ApBean.getBean(Msg.class);
        User user=userAdminService.selectById(uid);
        user.setPassword("123456");
        int count=userAdminService.updatePass(uid);

        if(count!=0){
            msg.setCode(1);
            msg.setMsg("修改成功");
        }else {
            msg.setMsg("重置失败");
        }
        return msg;
    }
@RequestMapping("/update")
@ResponseBody
    public Msg update(String id,String email,String tel,String invitation){
        int uid=Integer.valueOf(id);
        User user=userAdminService.update(uid,email,tel,invitation);
        Msg msg=ApBean.getBean(Msg.class);

        return msg;
    }
}
