package com.sdzy.www.mapper;

import com.sdzy.www.pojo.Order;
import com.sdzy.www.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ManagerMapper {
    //查询用户所有订单
    List<Order> selectAllOrder(Integer uid);
    //删除用户,改变状态code,为1是即为删除
    int update(Integer oid);
    //修改用户
    void updateUser(@Param("tel") String tel,@Param("email") String email, @Param("id") int id);
    User selectUser(int id);

    int updatePassword(@Param("password") String newPassword,@Param("id") int id);
}
