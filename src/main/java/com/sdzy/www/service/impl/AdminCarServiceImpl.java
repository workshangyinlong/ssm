package com.sdzy.www.service.impl;

import com.sdzy.www.mapper.AdminCarMapper;
import com.sdzy.www.pojo.Car;
import com.sdzy.www.service.AdminCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("/adminCarSerice")
public class AdminCarServiceImpl implements AdminCarService {
   @Autowired
    private AdminCarMapper adminCarMapper;

    @Override
    public List<Car> getCar() {

        return adminCarMapper.getCar();
    }

    @Override
    public Car getIdCar(int id) {
        return adminCarMapper.getIdCar(id);
    }

    @Override
    public boolean setCar(Car car) {
        int i = adminCarMapper.setCar(car);
        if(i!=0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean delCar(int id) {
        int i = adminCarMapper.delCar(id);
        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Car> selectCar(String carName, String serviceName) {

        return  adminCarMapper.selectCar(carName,serviceName);
    }

    @Override
    @Transactional(rollbackFor=Exception.class)
    public boolean addCar(Car car) {
        int result =adminCarMapper.addCar(car);
        if(result!=0){
            return true;
        }else{
            return false;
        }
    }
}
