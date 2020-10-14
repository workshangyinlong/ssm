package com.sdzy.www.service;

import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.Orders;

public interface OrderService {

    Car getCar(String cid);

    boolean setOrders(Orders orders);
}
