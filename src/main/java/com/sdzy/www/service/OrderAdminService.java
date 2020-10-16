package com.sdzy.www.service;

import com.sdzy.www.pojo.Order;

import java.util.List;

public interface OrderAdminService {

    List<Order> getOrder(String tel, String carName, Integer getid, Integer backid, String status);

    List<Order> getAll();

    int delete(int oid);
}
