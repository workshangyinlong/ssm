package com.sdzy.www.service.impl;

import com.sdzy.www.mapper.CityMapper;
import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.City;
import com.sdzy.www.pojo.CityAdmin;
import com.sdzy.www.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cityService")
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;
    @Override
    public List<City> getCityForPid(String pid) {
        return cityMapper.getCityForPid(pid);
    }

    @Override
    public String getname(String getid) {

        return cityMapper.getname(getid);
    }

    @Override
    public List<Car> getprice(String getid) {

        return cityMapper.getprice(getid);
    }

    @Override
    public List<Car> getNumber(String getid) {
        return cityMapper.getNumber(getid);
    }

    @Override
    public List<CityAdmin> getCityAdmin() {
        List<CityAdmin> cityAdmin = cityMapper.getCityAdmin();
        return  cityAdmin;
    }

    @Override
    public List<CityAdmin> getCityAdminByPid(Integer pid) {
        return  cityMapper.getCityAdminByPid(pid);
    }

    @Override
    public boolean deleteCityById(String id) {
        int result=cityMapper.deleteCityById(id);
        if(result!=0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean addCityForP(String cityname, Integer citypid) {
        City yon=cityMapper.getCityForName(cityname);
        if(yon!=null){
            return false;
        }else{
            int result=cityMapper.addCityForP(cityname,citypid);
            if(result!=0){
                return true;
            }else{
                return false;
            }
        }

    }
}
