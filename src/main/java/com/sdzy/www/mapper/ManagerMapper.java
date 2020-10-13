package com.sdzy.www.mapper;

import com.sdzy.www.pojo.Order;
import com.sdzy.www.pojo.User;

import java.util.List;

public interface ManagerMapper {
    //查询用户所有订单
    List<Order> selectAllOrder(Integer uid);
    //删除用户,改变状态code,为1是即为删除
    int update(Integer oid);
    //修改用户
    void updateUser(String tel,String email,String password,int id);
    User selectUser(int id);
}
