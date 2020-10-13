package com.sdzy.www.service;

import com.sdzy.www.pojo.Car;
import com.sdzy.www.pojo.Order;
import com.sdzy.www.pojo.User;

import java.util.List;

public interface ManagerService {

    List<Order> findAll(Integer uid);

    int delete(Integer oid);

    public User UpdateUser(String tel, String email, String password, int id);
}
