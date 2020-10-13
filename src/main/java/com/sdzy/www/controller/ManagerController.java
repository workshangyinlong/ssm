package com.sdzy.www.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdzy.www.bean.Msg;
import com.sdzy.www.bean.Msg_Order;
import com.sdzy.www.pojo.Order;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.ManagerService;
import com.sdzy.www.service.UserService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private UserService userService;
    @RequestMapping("/allOrder")
    @ResponseBody
    public Msg_Order findAllOrder(String page, HttpSession session) {
        Msg_Order msg = ApBean.getBean(Msg_Order.class);
        int p = page == null ? 1 : Integer.valueOf(page);
        PageHelper.startPage(p, 5);
        User user = (User) session.getAttribute("user");
        Integer uid = user.getId();
        List<Order> list = managerService.findAll(uid);


        if (list != null) {
            msg.setCode(1);
            msg.setOrders(list);
            msg.setTotalCount(list.size());
        } else {
            msg.setCode(0);
        }
        return msg;

    }

    @RequestMapping("/delete")
    @ResponseBody
    public Msg delete(String id) {
        Msg msg = ApBean.getBean(Msg.class);
        Integer oid = Integer.parseInt(id);
        int count = managerService.delete(oid);
        if (count != 0) {
            msg.setCode(1);

        } else {
            msg.setMsg("删除失败");
        }
        return msg;
    }

    @RequestMapping("/userInfo")
    @ResponseBody
    public User userInfo(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user != null) {
            user.getTel();
            user.getEmail();

        }
        return user;
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    @ResponseBody
    public Msg updateUser(String tel, String email,HttpSession session) {
        Msg msg = ApBean.getBean(Msg.class);
        User user = (User) session.getAttribute("user");
        int id = user.getId();
        user = managerService.UpdateUser(tel, email, id);
        if (user != null) {
            user.setPassword("");
            session.setAttribute("user",user);
            msg.setCode(1);
        } else {
            msg.setMsg("修改失败");
        }
        return msg;
    }



    /*
    * 密码修改*/
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    @ResponseBody
    public Msg updatePassword(String oldPassword,String newPassword,HttpSession session){
        Msg msg = ApBean.getBean(Msg.class);
       User user=(User)session.getAttribute("user");
        String tel = user.getTel();
        System.out.println("user = " + user);
        User login = userService.login(tel);
        if(login.getPassword().equals(oldPassword)){
            boolean result=managerService.updatePassword(newPassword,login.getId());
            if(result){
                return msg;
            }else{
                msg.setCode(0);
                msg.setMsg("修改失败");
                return msg;
            }
        }else {
            msg.setCode(0);
            msg.setMsg("原密码输入不正确");
            return msg;
        }

    }


    @RequestMapping("/mymain")
    public String mymain() {
        return "mymain/mymain";
    }

    @RequestMapping("/myinfo")
    public String getMyInfo(HttpSession session){
        Object user = session.getAttribute("user");
        if(user!=null){
            return "mymain/myinfo";
        }else{
            return "redirect:/load/login";
        }
    }

}

