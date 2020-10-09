package com.sdzy.www.service;

import com.sdzy.www.pojo.User;

/*
    用户相关逻辑处理
 */
public interface UserService {
    User getTel(String tel);
    void  insert(User user);

}
