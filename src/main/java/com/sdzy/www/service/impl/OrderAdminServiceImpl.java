package com.sdzy.www.service.impl;

import com.sdzy.www.mapper.OrderAdminMapper;
import com.sdzy.www.pojo.Order;
import com.sdzy.www.service.OrderAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("orderAdminService")
public class OrderAdminServiceImpl implements OrderAdminService {
    @Autowired
    private OrderAdminMapper orderAdminMapper;
    @Override
    public List<Order> getOrder(String tel, String carName, Integer getid, Integer backid, String status) {
        return orderAdminMapper.selectOrder(tel,carName,getid,backid,status);
    }

    @Override
    public List<Order> getAll() {
        return orderAdminMapper.selectAll();
    }

    @Override
    public int delete(int oid) {
        return orderAdminMapper.updateById(oid);
    }
}
