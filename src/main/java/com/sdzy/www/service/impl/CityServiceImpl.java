package com.sdzy.www.service.impl;

import com.sdzy.www.mapper.CityMapper;
import com.sdzy.www.pojo.City;
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
}
