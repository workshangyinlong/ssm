package com.sdzy.www.mapper;

import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.City;

import java.util.List;

public interface CityMapper {
    List<City> getCityForPid(String pid);

    String getname(String getid);

    List<Car> getprice(String getid);

    List<Car> getNumber(String getid);
}
