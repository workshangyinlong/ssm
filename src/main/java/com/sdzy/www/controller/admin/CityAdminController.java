package com.sdzy.www.controller.admin;


import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.City;
import com.sdzy.www.pojo.CityAdmin;
import com.sdzy.www.service.CityService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admincity")
public class CityAdminController {
    @Autowired
    private CityService cityService;


    @RequestMapping("/citymanage")
    public String getCityAdminPage(){
       return "admin/admincity";
    }

    @RequestMapping("/allcity")
    @ResponseBody
    public List<CityAdmin> getAllCity(){
        List<CityAdmin> cityAdmins=cityService.getCityAdmin();
        return cityAdmins;
    }

    @RequestMapping("/pidcity")
    @ResponseBody
    public List<CityAdmin> getAllCity(Integer pid){
        if(pid==0){
            return getAllCity();
        }
        List<CityAdmin> cityAdmins = cityService.getCityAdminByPid(pid);
        return cityAdmins;
    }


    @RequestMapping(value = "/deletecity")
    @ResponseBody
    public Msg deletecity(String id){
        List<Car> getprice = cityService.getprice(id);
        Msg msg = ApBean.getBean(Msg.class);
        if(getprice!=null){
            msg.setCode(0);
            msg.setMsg("改服务站点存在车辆，请先删除车辆信息！");
            return msg;
        }else{
            boolean result=cityService.deleteCityById(id);
            if(result){
                return msg;
            }else{
                msg.setCode(0);
                msg.setMsg("删除失败，未知错误");
                return msg;
            }
        }
    }


    /*城市添加页面跳转
    */


    @RequestMapping("/cityaddpage")
    public String getCityAddPage(){
        return "admin/admincityadd";
    }


    @RequestMapping("/addcity")
    @ResponseBody
    public Msg addCity(String cityname,Integer pid){
        Msg msg = ApBean.getBean(Msg.class);
        boolean result=cityService.addCityForP(cityname,pid);
        if (result){
            return msg;
        }else{
            msg.setCode(0);
            msg.setMsg("添加失败!该城市或服务点已存在");
            return msg;
        }
    }

    @RequestMapping("/getcity")
    @ResponseBody
    public City getCity(Integer cid){
        City city=cityService.getCity(cid);
        return city;
    }


    @RequestMapping("/updatecity")
    @ResponseBody
    public Msg updateCity(Integer cid,String cname){
        Msg msg = ApBean.getBean(Msg.class);
        boolean result=cityService.updateCity(cid,cname);
        if(result){
            return msg;
        }else{
            msg.setCode(0);
            msg.setMsg("修改失败，未知错误");
            return msg;
        }
    }

}
