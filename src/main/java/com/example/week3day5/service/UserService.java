package com.example.week3day5.service;

import com.example.week3day5.entity.User;

import java.util.List;

public interface UserService {
    User getUser(String name,String password);
    int addUser(User user);
    List<User> getAdmins();
}
