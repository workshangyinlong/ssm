package com.sdzy.www.controller;


import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.City;
import com.sdzy.www.service.CityService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/city")

public class CityController {
    @Autowired
    private CityService cityService;

    /*
        是否登录 ajax
    */
    @RequestMapping(value = "/yonlogin",method = RequestMethod.POST)
    @ResponseBody
    public Msg yonLogin(HttpSession session){
        Msg msg = ApBean.getBean(Msg.class);
        Object user = session.getAttribute("user");
        if(user!=null){
            msg.setCode(0);
            return msg;
        }else{
            return msg;
        }
    }

    /*
        取车还车ajax
     */


    @RequestMapping(value = "/position")
    @ResponseBody
    public List<City> getCitys(String pid){
        Integer integer = Integer.valueOf(pid);
        List<City> list=cityService.getCityForPid(pid);
        return list;
    }



    @RequestMapping("/shortrent")
    public String shortrent(){
        return "shortRent/shortrent";
    }
}
