package com.example.week3day5.service;

import com.example.week3day5.entity.User;

public interface UserService {
    User getUser(String name,String password);
    int addUser(User user);
}
