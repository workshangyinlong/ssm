package com.sdzy.www.pojo;

public class Car {
    private Integer id ;
    private  String name ;
    private  String type;
    private  Integer sitnum;
    private  Integer cid;
    private  double price;
    private  Integer number;
    private  String picture;


    public Car() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getSitnum() {
        return sitnum;
    }

    public void setSitnum(Integer sitnum) {
        this.sitnum = sitnum;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Car(Integer id, String name, String type, Integer sitnum, Integer cid, double price, Integer number, String picture) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.sitnum = sitnum;
        this.cid = cid;
        this.price = price;
        this.number = number;
        this.picture = picture;
    }
}
