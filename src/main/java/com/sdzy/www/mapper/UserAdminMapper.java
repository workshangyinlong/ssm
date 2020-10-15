package com.sdzy.www.mapper;


import com.sdzy.www.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAdminMapper {

    List<User> selectByTelAndEmail(@Param("tel") String tel, @Param("email") String email);

    List<User> selectAllUser();

    int updatePassword(int uid);

    User selectById(int uid);

    void update(@Param("id") int uid, @Param("email") String email, @Param("tel") String tel,@Param("invitation") String invitation);

    int deleteById(int uid);
}
