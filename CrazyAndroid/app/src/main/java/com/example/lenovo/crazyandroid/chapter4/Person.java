package com.example.lenovo.crazyandroid.chapter4;

import java.io.Serializable;

/**
 * Created by LENOVO on 2015/12/21.
 */
public class Person implements Serializable{

    private String name;
    private String password;
    private String gender;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
