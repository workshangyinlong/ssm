package com.sdzy.www.bean;

import com.sdzy.www.pojo.Order;

import java.util.List;

public class Msg_Order {
    private Integer code;
    private List<Order> orders;
    private Integer totalCount;

    public Msg_Order(Integer code, List<Order> orders, Integer totalCount) {
        this.code = code;
        this.orders = orders;
        this.totalCount = totalCount;
    }


    public Msg_Order() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
