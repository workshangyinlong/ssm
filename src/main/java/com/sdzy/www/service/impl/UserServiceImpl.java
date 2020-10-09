package com.sdzy.www.service.impl;

import com.sdzy.www.mapper.UserMapper;
import com.sdzy.www.pojo.User;
import com.sdzy.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String tel) {
        return userMapper.selectByTel(tel);
    }

    @Override
    public void regist(User user) {
        userMapper.insert(user);
    }

    @Override
    public String getEmail(String email) {
        return userMapper.select(null,null,email);
    }

    @Override
    public String  getInvitation(String invitation) {
        return userMapper.select(invitation,null,null);
    }

    @Override
    public String getTel(String tel) {
        return userMapper.select(null,tel,null);
    }
}
