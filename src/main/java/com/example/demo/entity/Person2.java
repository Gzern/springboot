package com.example.demo.entity;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "person")  //读取注入属性值  其中属性值person开头
//@EnableConfigurationProperties //开启属性注入
@PropertySource("classpath:conf/person.properties")
@Component //将bean对象注入到spring容器中
public class Person2 {

    private int age;
    private String name;


    //通过setter方法,将读取到的属性值注入到属性中.
    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
