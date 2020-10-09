package com.sdzy.www.mapper;


import com.sdzy.www.pojo.User;
import org.apache.ibatis.annotations.Param;

/*
    用户dao层 格式为实体Mapper
*/
public interface UserMapper {
    User selectByTel(String tel);
    String select(@Param("invitation") String invitation,@Param("tel") String tel,@Param("email") String email);
    void insert(User user);
}
