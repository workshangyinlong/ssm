package com.sdzy.www.mapper;


import com.sdzy.www.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAdminMapper {

    List<User> selectByTelAndEmail(@Param("tel") String tel, @Param("email") String email);
}
