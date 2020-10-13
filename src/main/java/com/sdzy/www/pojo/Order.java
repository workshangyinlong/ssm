package com.sdzy.www.pojo;

public class Order {
    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    private Integer id;
    private Car  car;
    private String carName;
    private User user;
    private String getcity;
    private String backcity;
    private String oprice;
    private String status;
    private Integer code;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getGetcity() {
        return getcity;
    }

    public void setGetcity(String getcity) {
        this.getcity = getcity;
    }

    public String getBackcity() {
        return backcity;
    }

    public void setBackcity(String backcity) {
        this.backcity = backcity;
    }

    public String getOprice() {
        return oprice;
    }

    public void setOprice(String oprice) {
        this.oprice = oprice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", car=" + car +
                ", carName='" + carName + '\'' +
                ", user=" + user +
                ", getcity='" + getcity + '\'' +
                ", backcity='" + backcity + '\'' +
                ", oprice='" + oprice + '\'' +
                ", status='" + status + '\'' +
                ", code=" + code +
                '}';
    }
}
