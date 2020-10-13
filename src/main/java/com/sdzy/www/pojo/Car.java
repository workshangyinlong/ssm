package com.sdzy.www.pojo;

public class Car {
   /* idint(11) NOT NULL
    namevarchar(50) NULL
    typevarchar(10) NULL
    sitnumint(11) NULL
    cidint(11) NULL
    pricedouble(10,2) NULL
    numberint(11) NULL
    picturevarchar(255) NULL*/
  private Integer id;
  private  String name;
  private String type;
  private Integer sitnum;
  private City city;
  private double price;
  private Integer number;
  private String picture;

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

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
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

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", sitnum=" + sitnum +
                ", city=" + city +
                ", price=" + price +
                ", number=" + number +
                ", picture='" + picture + '\'' +
                '}';
    }
}
