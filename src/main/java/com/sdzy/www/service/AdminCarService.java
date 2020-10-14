package com.sdzy.www.service;

import com.sdzy.www.pojo.Car;

import java.util.List;

public interface AdminCarService {

    List<Car> getCar();

    Car getIdCar(int id);

    boolean setCar(Car car);

    boolean delCar(int id);

    List<Car> selectCar(String carName, String serviceName);
}
