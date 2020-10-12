package com.sdzy.www.service;

import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.City;

import java.util.List;

public interface CityService {
    List<City> getCityForPid(String pid);

    String getname(String getid);

    List<Car> getprice(String getid);

    List<Car> getNumber(String getid);
}
