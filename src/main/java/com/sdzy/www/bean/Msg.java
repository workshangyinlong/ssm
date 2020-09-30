package com.sdzy.www.bean;


/*
用于ajax回复json数据
*/
public class Msg {
    private Integer code;//为0则为错误失败消息
    private String msg;//错误信息

    public Msg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Msg(){}

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
