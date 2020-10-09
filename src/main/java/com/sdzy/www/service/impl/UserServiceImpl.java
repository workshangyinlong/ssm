package com.sdzy.www.service.impl;

import com.sdzy.www.mapper.UserMapper;
import com.sdzy.www.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;
}
