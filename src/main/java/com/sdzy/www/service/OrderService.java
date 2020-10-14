package com.sdzy.www.service;

import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.orders;

public interface OrderService {

    Car getCar(String cid);

    boolean setOrders(orders orders);
}
