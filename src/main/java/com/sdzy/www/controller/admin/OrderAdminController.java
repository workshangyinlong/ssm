package com.sdzy.www.controller.admin;

import com.sdzy.www.bean.Msg;
import com.sdzy.www.bean.Msg_Order;
import com.sdzy.www.pojo.Order;
import com.sdzy.www.service.OrderAdminService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/orderAdmin")
public class OrderAdminController {

    @Autowired
    private OrderAdminService orderAdminService;
    @RequestMapping("orderAdmin")
    public String orderAdmin(){
        return "/admin/orderAdmin";
    }

    //查询所有
    @RequestMapping("/getAll")
    @ResponseBody
    public Msg_Order findAll(){
        Msg_Order msg= ApBean.getBean(Msg_Order.class);
       List<Order> orders= orderAdminService.getAll();
        if (orders != null) {
            msg.setCode(1);
            msg.setOrders(orders);

        } else {
            msg.setCode(0);
        }
        return msg;
    }
    //模糊查询

    @RequestMapping("getOrder")
    @ResponseBody
    public Msg_Order getOrder(String tel,String carName,Integer getid,Integer backid,String status){
        System.out.println("tel = " + tel);
        System.out.println("carName = " + carName);
        if(tel.equals("")) tel=null;
        if(carName.equals("")) carName=null;
//        System.out.println("getid = " + getid);
//        if(getid==0) getid=null;
//        if(backid==0) backid=null;
        if(status.equals("0")) status=null;
        Msg_Order msg=ApBean.getBean(Msg_Order.class);
       List<Order> orders=orderAdminService.getOrder(tel,carName,getid,backid,status);
        if (orders != null) {
            msg.setCode(1);
            msg.setOrders(orders);

        } else {
            msg.setCode(0);
        }
        return msg;
    }

    //删除订单
    @ResponseBody
    @RequestMapping("/delete")
    public Msg delete(String id){
        int oid=Integer.valueOf(id);
        Msg msg=ApBean.getBean(Msg.class);
        int count=orderAdminService.delete(oid);
        if(count!=0){
            msg.setCode(1);
        }else{
            msg.setMsg("删除失败");
        }
        return msg;
    }

}
