package com.sdzy.www.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sdzy.www.bean.Msg;
import com.sdzy.www.bean.Msg_Order;
import com.sdzy.www.pojo.Order;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.ManagerService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @RequestMapping("/allOrder")
    @ResponseBody
  public Msg_Order findAllOrder(String page,HttpSession session){
        Msg_Order msg= ApBean.getBean(Msg_Order.class);
      int p=page==null?1:Integer.valueOf(page);
        PageHelper.startPage(p,5);
        User user=(User)session.getAttribute("user");
        Integer uid=user.getId();
        List<Order> list=managerService.findAll(uid);


        if (list!=null){
            msg.setCode(1);
            msg.setOrders(list);
            msg.setTotalCount(list.size());
        }else {
            msg.setCode(0);
        }
        return msg;

  }
  @RequestMapping( "/delete")
  @ResponseBody
   public Msg delete(String id){
        Msg msg=ApBean.getBean(Msg.class);
        Integer oid=Integer.parseInt(id);
       int count= managerService.delete(oid);
        if(count!=0){
            msg.setCode(1);

        }else {
           msg.setMsg("删除失败");
        }
       return msg;
  }

  @RequestMapping("/userInfo")
  @ResponseBody
  public String  userInfo(HttpSession session){
        Msg msg=ApBean.getBean(Msg.class);
        User user=(User)session.getAttribute("user");
        if(user!=null){
            user.getTel();
            user.getEmail();
            user.getPassword();

        }
        return "";
  }

  public Msg updateUser(String tel,String email,String password,HttpSession session){
        Msg msg=ApBean.getBean(Msg.class);
        User user=(User)session.getAttribute("user");
        int id=user.getId();
        user=managerService.UpdateUser(tel,email,password,id);
        if(user!=null){
            msg.setCode(1);
        }else{
            msg.setMsg("修改失败");
        }
        return msg;
  }

  @RequestMapping("/mymain")
  public String mymain(){
       return "mymain/mymain" ;
  }
}
