package com.example.week3day5.controller;

import com.example.week3day5.domain.AllUsersResponse;
import com.example.week3day5.domain.common.ServiceStatus;
import com.example.week3day5.entity.User;
import com.example.week3day5.service.UserService;
import com.example.week3day5.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "userServlet", value = "/user")
public class UserServlet extends HttpServlet {
    private UserService userService;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public void init() {
        this.userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AllUsersResponse allUsersResponse = new AllUsersResponse();
        User user = new User();
        user.setName(request.getParameter("userName"));
        user.setAddress(request.getParameter("address"));
        try {
            user.setBirthDate(sdf.parse(request.getParameter("birthDate")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        user.setEmail(request.getParameter("email"));
        user.setAdmin(Short.parseShort(request.getParameter("isAdmin")));
        user.setActive((short) 1);
        user.setPassword(request.getParameter("password"));
        int res = userService.addUser(user);
        if (res > 0) {
            prepareAllUserResponse(allUsersResponse, true, "");
            allUsersResponse.setRedirectUrl(request.getContextPath());
        } else if (res == -1) {
            prepareAllUserResponse(allUsersResponse, false, "User Name Exist");
        } else {
            prepareAllUserResponse(allUsersResponse, false, "Add User Failed");
        }
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();
        String addResponseJson = gson.toJson(allUsersResponse);
        writer.append(addResponseJson);
        writer.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AllUsersResponse allUsersResponse = new AllUsersResponse();
        List<User> users = userService.getAdmins();
        request.getSession().setAttribute("admins",users);
        if (users.size() > 0) {
            prepareAllUserResponse(allUsersResponse, true, "");
        } else {
            prepareAllUserResponse(allUsersResponse, false, "Admins not found");
        }
        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();
        String addResponseJson = gson.toJson(allUsersResponse);
        writer.append(addResponseJson);
        writer.close();
    }

    private void prepareAllUserResponse(AllUsersResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }
}
