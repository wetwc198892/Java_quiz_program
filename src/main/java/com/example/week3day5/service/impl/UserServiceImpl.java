package com.example.week3day5.service.impl;

import com.example.week3day5.dao.UserDAO;
import com.example.week3day5.entity.User;
import com.example.week3day5.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDAO userDAO;

    public UserServiceImpl() {
        if (userDAO == null) userDAO = new UserDAO();
    }

    @Override
    public User getUser(String name, String password) {
        return userDAO.getUser(name, password);
    }

    @Override
    public int addUser(User user) {
        return userDAO.addUser(user);
    }

    @Override
    public List<User> getAdmins() {
        return userDAO.getAdmins();
    }
}
