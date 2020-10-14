package com.sdzy.www.controller;

import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.Orders;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.CityService;
import com.sdzy.www.service.OrderService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private CityService cityService;
    @Autowired
   private OrderService orderService;
    //页面转发
    @RequestMapping("/ordersubmit")
    public String order(){
        return "order/ordersubmit";
    }
    //拿去页面需要的数据,id在表头
    @RequestMapping("/getcar")
    @ResponseBody
    public  Car orderSubmit(String cid ){
        Car car = orderService.getCar(cid);
        return car;
    }
    @RequestMapping("/setorder")
    @ResponseBody
    public Msg setOrder(String getid , String backid, String oprice, String cid, HttpSession session){
        Orders orders = ApBean.getBean(Orders.class);
        orders.setBackid(Integer.valueOf(backid));
        orders.setGetid(Integer.valueOf(getid));
        orders.setOprice(Integer.valueOf(oprice));
        orders.setCid(Integer.valueOf(cid));
        User user =(User)session.getAttribute("user");
        orders.setUid(user.getId());
        orders.setStatus("已预订");
        //数据库传入参数
        boolean b = orderService.setOrders(orders);
        Msg bean = ApBean.getBean(Msg.class);
        if (b){
            bean.setMsg("已成功预定");
            return bean;
        }else {
            bean.setMsg("预定失败");
            return bean;
        }
    }
}
