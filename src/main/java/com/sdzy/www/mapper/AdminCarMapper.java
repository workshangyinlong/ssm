package com.sdzy.www.mapper;

import com.sdzy.www.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminCarMapper {
    List<Car> getCar();

    Car getIdCar(int id);

    int setCar(Car car);

    int delCar(int id);

    List<Car> selectCar(@Param("carName") String carName,@Param("serviceName") String serviceName);

}
