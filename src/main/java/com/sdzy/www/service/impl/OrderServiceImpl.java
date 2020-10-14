package com.sdzy.www.service.impl;

import com.sdzy.www.mapper.OrderMapper;
import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.Orders;
import com.sdzy.www.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("orderservice")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Car getCar(String cid) {
        return orderMapper.getCar(cid);
    }

    @Override
    public boolean setOrders(Orders orders) {
        Integer i = orderMapper.setOrders(orders);
        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

}
