package com.sdzy.www.service;

import com.sdzy.www.pojo.User;

import java.util.List;

public interface UserAdminService {

    List<User> selectByTelAndEmail(String tel, String email);

    List<User> selectAllUser();

    int updatePass(int uid);

    User selectById(int uid);

    User update(int uid, String email, String tel, String invitation);

    int deleteById(int uid);
}
