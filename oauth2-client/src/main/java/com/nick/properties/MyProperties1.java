package com.nick.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 解析application.yml中的my1
 * Created by nick on 2018/11/7.
 */
@Component
@PropertySource("classpath:application.yml")
@ConfigurationProperties(prefix = "my1")

public class MyProperties1 {

    private int age;
    private String name;
    // 省略 get set

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyProperties1{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
