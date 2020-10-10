package com.sdzy.www.mapper;

import com.sdzy.www.pojo.City;

import java.util.List;

public interface CityMapper {
    List<City> getCityForPid(String pid);
}
