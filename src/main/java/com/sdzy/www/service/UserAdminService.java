package com.sdzy.www.service;

import com.sdzy.www.pojo.User;

import java.util.List;

public interface UserAdminService {

    List<User> selectByTelAndEmail(String tel, String email);
}
