package com.sdzy.www.mapper;

import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.City;
import com.sdzy.www.pojo.CityAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CityMapper {
    List<City> getCityForPid(String pid);

    String getname(String getid);

    List<Car> getprice(String getid);

    List<Car> getNumber(String getid);

    List<CityAdmin> getCityAdmin();

    List<CityAdmin> getCityAdminByPid(Integer pid);

    int deleteCityById(String id);

    int addCityForP(@Param("cityname") String cityname, @Param("pid") int pid);

    City getCityForName(String cityname);

    City getCity(int cid);

    int updateCity(@Param("cid") Integer cid,@Param("cname") String cname);
}
