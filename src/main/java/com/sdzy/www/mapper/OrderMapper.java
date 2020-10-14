package com.sdzy.www.mapper;

import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.Orders;

public interface OrderMapper {

    Car getCar(String cid);

    Integer setOrders(Orders orderss);
}
