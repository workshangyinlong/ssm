package com.sdzy.www.service.impl;

import com.sdzy.www.mapper.UserAdminMapper;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.UserAdminService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userAdminService")
public class UserAdminServiceImpl implements UserAdminService {
    @ Autowired
    private UserAdminMapper userAdminMapper;
    @Override
    public List<User> selectByTelAndEmail(String tel, String email) {
        return userAdminMapper.selectByTelAndEmail(tel,email);
    }
}
