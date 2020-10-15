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
    //模糊查询用户
    @Override
    public List<User> selectByTelAndEmail(String tel, String email) {
        return userAdminMapper.selectByTelAndEmail(tel,email);
    }

    //查所有用户
    @Override
    public List<User> selectAllUser() {
        return userAdminMapper.selectAllUser();
    }

    //密码重置
    @Override
    public int updatePass(int uid) {
        return userAdminMapper.updatePassword(uid);
    }

    @Override
    public User selectById(int uid) {
        return userAdminMapper.selectById(uid);
    }
//修改用户
    @Override
    public User update(int uid, String email, String tel, String invitation) {
        userAdminMapper.update(uid,email,tel,invitation);
        User user =userAdminMapper.selectById(uid);
        return user;
    }

    @Override
    public int deleteById(int uid) {
        return userAdminMapper.deleteById(uid);
    }
}
