package com.sdzy.www.controller;

import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.CityService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sort")
public class SortController {

    @Autowired
    public CityService cityService;
//登录选车界面
    @RequestMapping("/shortsort")
    public  String shortSort(){

        return "shortRent/shortsort";
    }

//导航栏判定是否登录成功
    @RequestMapping(value = "/judgesuccess" ,method = RequestMethod.POST)
    @ResponseBody
    public Msg judgeLogin(HttpSession session){
        Msg msg = ApBean.getBean(Msg.class);
        User user=(User)session.getAttribute("user");
        if (user!=null){
            msg.setCode(1);
            return msg;
        }else{
            msg.setCode(0);
            return msg;
        }


    }
    //通过id查询地址名字
    @RequestMapping("/getname")
    @ResponseBody
    public  Map<String, String> getName(String getid , String backid){
        String getname = cityService.getname(getid);
        String backname = cityService.getname(backid);
        Map<String,String> map=new HashMap<String,String>();
        map.put("getname",getname);
        map.put("backname",backname);
        map.put("code","1");
        return map;
    }

    //通过getid和价格排序来查询所有车辆信息
    @RequestMapping("/getprice")
    @ResponseBody
    public List<Car> getPrice(String getid){
        List<Car> cars = cityService.getprice(getid);
        return cars;
    }
    //通过getid和商品热度查询商品
    @RequestMapping("/getnumber")
    @ResponseBody
    public  List<Car> getNumber(String getid){
        List<Car> number = cityService.getNumber(getid);
        return number;

    }
}
