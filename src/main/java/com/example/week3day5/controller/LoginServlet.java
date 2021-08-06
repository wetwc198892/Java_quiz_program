package com.example.week3day5.controller;

import com.example.week3day5.domain.LoginResponse;
import com.example.week3day5.domain.common.ServiceStatus;
import com.example.week3day5.entity.User;
import com.example.week3day5.service.UserService;
import com.example.week3day5.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    public void init() {
        this.userService = new UserServiceImpl();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LoginResponse loginResponse = new LoginResponse();
        User user = userService.getUser(request.getParameter("userName"), request.getParameter("password"));
        Gson gson = new GsonBuilder().setDateFormat("MM-dd-yyyy").create();
        if (user.getName() != null) {
            request.getSession().setAttribute("user", user);
            loginResponse.setUser(user);
            loginResponse.setRedirectUrl(request.getContextPath()+"/home.jsp");
            prepareLoginResponse(loginResponse,true,"");
        }else{
            prepareLoginResponse(loginResponse,false,"Login Failed");
        }
        PrintWriter writer = response.getWriter();
        String getResponseJson = gson.toJson(loginResponse);
        writer.append(getResponseJson);
        writer.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        LoginResponse loginResponse = new LoginResponse();
        request.getSession().removeAttribute("user");
        loginResponse.setRedirectUrl(request.getContextPath()+"/home.jsp");
        prepareLoginResponse(loginResponse,true,"");
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        String getResponseJson = gson.toJson(loginResponse);
        writer.append(getResponseJson);
        writer.close();
    }

    private void prepareLoginResponse(LoginResponse response, boolean success, String errorMessage) {
        response.setServiceStatus(new ServiceStatus(success ? "SUCCESS" : "FAILED", success, errorMessage));
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
