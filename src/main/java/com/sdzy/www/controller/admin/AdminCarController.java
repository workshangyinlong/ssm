package com.sdzy.www.controller.admin;

import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.Car;
import com.sdzy.www.service.AdminCarService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.AnnotatedWildcardType;
import java.util.List;

//查看所有车型
//添加车型
@Controller
@RequestMapping("/admincar")
public class AdminCarController {
    @Autowired
    private AdminCarService adminCarSerice;

    //拿出所有车辆的信息
    @RequestMapping("/getallcar")
    @ResponseBody
    public List<Car> getAllCar(){
        List<Car> car = adminCarSerice.getCar();
        return car;
    }

    @RequestMapping("/opencheckcar")
    //打开所有车型界面
    public String  openCheckcar(){
        return "admin/checkcar";
    }
    //根据id拿出单个车辆信息
    @RequestMapping("/getcar")
    @ResponseBody
    public Car getcar(String id){
        Car idCar = adminCarSerice.getIdCar(Integer.valueOf(id));
       if (idCar!=null){
           return idCar;
       }else{
           return null;
       }
    }
    @RequestMapping(value = ("/setcar") ,method = RequestMethod.PUT  ,produces="application/json;charset=utf-8")
    @ResponseBody
    //直接接受json字符串的数据并转换为car的实体类
    public Msg setCar(@RequestBody Car car){
        Msg msg = ApBean.getBean(Msg.class);
        boolean b = adminCarSerice.setCar(car);
        if(b){
            msg.setMsg("数据修改成功");
            return msg;
        }
            msg.setMsg("数据修改失败");
            return msg;
    }
    @RequestMapping("/delcar")
    @ResponseBody
    //删除car
    public Msg delCar(String id){
        Msg msg = ApBean.getBean(Msg.class);
        boolean b = adminCarSerice.delCar(Integer.valueOf(id));
        if(b){
            msg.setMsg("数据修改成功");
            return msg;
        }else{
            msg.setMsg("数据修改失败");
            return msg;
        }
    }
    @RequestMapping("/selectcar")
    @ResponseBody
    //模糊查询时候的car数据集合
    public List<Car> select(String carName ,String serviceName){
        List<Car> cars = adminCarSerice.selectCar(carName, serviceName);
        return cars;
    }
}
