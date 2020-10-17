package com.sdzy.www.controller.admin;

import com.sdzy.www.bean.Msg;
import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.City;
import com.sdzy.www.service.AdminCarService;
import com.sdzy.www.utils.ApBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.AnnotatedWildcardType;
import java.util.List;
import java.util.UUID;

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

    @RequestMapping(value = "/addcar",method = RequestMethod.POST)
    @ResponseBody
    //模糊查询时候的car数据集合
    public Msg addCar(Integer cid , String carname, MultipartFile pic , Car car , HttpServletRequest request){
//        System.out.println("cid = " + cid);
//        System.out.println("carname = " + carname);
//        System.out.println("pic = " + pic);
//        System.out.println(pic.getOriginalFilename());
        System.out.println("carname = " + carname);
        Msg msg = ApBean.getBean(Msg.class);

/*        if(carname==null||carname.equals("")) {
            msg.setCode(0);
            msg.setMsg("请输入车辆名称");
            return msg;
        }if(car.getNumber()==null||car.getNumber().equals("")){
            msg.setCode(0);
            msg.setMsg("请输入车辆热度排行");
            return msg;
        }

        if(car.getPrice()==0){
            msg.setCode(0);
            msg.setMsg("请输入车辆价格");
            return msg;}
        if(car.getType()==null||car.getType().equals("")){
            msg.setCode(0);
            msg.setMsg("请输入正确的车辆类型");
            return msg;
        }if(cid==0||cid==null){
            msg.setCode(0);
            msg.setMsg("请选择服务点");
            return msg;
        }
        if(pic==null||!pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf(".")).equals("jsp")||!pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf(".")).equals("png")){
            msg.setCode(0);
            msg.setMsg("请选择正确的照片格式");
            return msg;
        }
        */String realPath = request.getSession().getServletContext().getRealPath("/static/images");
        File file = new File(realPath);
        String originalFilename = pic.getOriginalFilename();
        String fileName = UUID.randomUUID().toString()+originalFilename.substring(originalFilename.lastIndexOf("."));
        car.setName(carname);
        car.setPicture("NO_Three_war_exploded/static/images/"+fileName);
        System.out.println("car.getPicture() = " + car.getPicture());
        City city = ApBean.getBean(City.class);
        city.setId(cid);
        car.setCity(city);
        System.out.println("car = " + car);
        try {
            pic.transferTo(new File(file,fileName));
            System.out.println(adminCarSerice.addCar(car));
        } catch (Exception e) {
            e.printStackTrace();
            msg.setMsg("添加失败！未知错误");
        }
        msg.setCode(0);
        return msg;
    }


    @RequestMapping("/addcarpage")
    public String getaddcarPage(){
        return "admin/addcar";
    }

}
