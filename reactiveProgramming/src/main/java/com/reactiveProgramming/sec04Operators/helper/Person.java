package com.reactiveProgramming.sec04Operators.helper;

import com.reactiveProgramming.utility.Util;

public class Person {

    private String name;

    private int age;

    public Person(){
        this.name = Util.faker().name().fullName();
        this.age = Util.faker().random().nextInt(1,50);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
