package com.sdzy.www.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
     对象工厂
*/
public class ApBean {

    public static Object getBean(String beanId){
        return  new ClassPathXmlApplicationContext("spring/spring_core.xml").getBean(beanId);
    }

    public static <T> T getBean(Class<T> tClass){
        return new ClassPathXmlApplicationContext("spring/spring_core.xml").getBean(tClass);
    }
}
