package com.sdzy.www.service.impl;

import com.sdzy.www.mapper.ManagerMapper;
import com.sdzy.www.pojo.Order;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("managerService")
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;
    @Override
    public List<Order> findAll(Integer uid) {
       List<Order> list= managerMapper.selectAllOrder(uid);
        return list;
    }

    @Override
    public int delete(Integer oid) {
       return managerMapper.update(oid);
    }

    @Override
    public User UpdateUser(String tel, String email,int id) {
        managerMapper.updateUser(tel,email,id);

        return managerMapper.selectUser(id);
    }

    @Override
    public boolean updatePassword(String newPassword,int id) {
        int result = managerMapper.updatePassword(newPassword,id);
        if(result!=0){
            return true;
        }else{
            return false;
        }
    }


}
