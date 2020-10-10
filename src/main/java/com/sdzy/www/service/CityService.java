package com.sdzy.www.service;

import com.sdzy.www.pojo.City;

import java.util.List;

public interface CityService {
    List<City> getCityForPid(String pid);
}
