package com.example.demo.conditionDemo.bean;

import lombok.Data;

/**
 * @ClassName: User1
 * @Description: User1
 * @Author: Alphonse
 * @Version: 1.0
 * @Date: 2019/10/12 11:49
 **/
@Data
public class User1 {
    private String name;
    private int age;

    public User1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User1() {
        this.name = "Unnamed";
        this.age = -1;
    }
    public User1 getUser1() {
        System.out.println("创建user1实例");
        return new User1("Ayra", 12);
    }
}
