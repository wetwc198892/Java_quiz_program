package com.example.week3day5.entity;

import java.util.Date;

public class User {
    private int id;
    private String name;
    private String password;
    private Date birthDate;
    private String email;
    private String address;
    private short active;
    private short admin;
    private String image;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public short isActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public short isAdmin() {
        return admin;
    }

    public void setAdmin(short admin) {
        this.admin = admin;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
