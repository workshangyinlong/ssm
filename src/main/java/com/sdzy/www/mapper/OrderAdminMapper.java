package com.sdzy.www.mapper;

import com.sdzy.www.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderAdminMapper {
    List<Order> selectOrder(@Param("tel") String tel,
                            @Param("carName") String carName,
                            @Param("getid") Integer getid,
                            @Param("backid") Integer backid,
                            @Param("status") String status);

    List<Order> selectAll();

    int updateById(int oid);
}
