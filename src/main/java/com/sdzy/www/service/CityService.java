package com.sdzy.www.service;

import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.City;
import com.sdzy.www.pojo.CityAdmin;

import java.util.List;

public interface CityService {
    List<City> getCityForPid(String pid);

    String getname(String getid);

    List<Car> getprice(String getid);

    List<Car> getNumber(String getid);

    List<CityAdmin> getCityAdmin();

    List<CityAdmin> getCityAdminByPid(Integer pid);

    boolean deleteCityById(String id);

    boolean addCityForP(String cityname, Integer citypid);

    City getCity(int cid);

    boolean updateCity(Integer cid, String cname);
}
