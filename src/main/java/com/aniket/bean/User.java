package com.aniket.bean;

import com.aniket.constant.Gender;
import com.aniket.constant.Role;

public class User {
    private String userId;
    private String name;
    private Role role;
    private String password;
    private Gender gender;
    private String address;
    private String country;

    public User() {
        
    }

    public User(String userId, String name, Role role, String password, Gender gender, String address, String country) {
        this.userId = userId;
        this.name = name;
        this.role = role;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.country = country;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
