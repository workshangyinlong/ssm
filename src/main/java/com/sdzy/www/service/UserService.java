package com.sdzy.www.service;

import com.sdzy.www.pojo.User;

/*
    用户相关逻辑处理
 */
public interface UserService {
    User login(String tel);
    void  regist(User user);
    String getEmail(String email);
    String getInvitation(String invitation);
    String getTel(String tel);
}
