package com.sdzy.www.pojo;

import java.io.Serializable;

public class City implements Serializable {
    private Integer id;
    private String name;
    private String pid;

    public City() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public City(Integer id, String name, String pid) {


        this.id = id;
        this.name = name;
        this.pid = pid;
    }
}
