package com.example.week3day5.dao;

import com.example.week3day5.config.MySqlDS;
import com.example.week3day5.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private DataSource ds;
    private Connection conn;
    private ResultSet rs;
    private PreparedStatement ps;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

    private static final String SELECT_USER = "SELECT * FROM USERS WHERE name = ? and password = ? and isActive = 1;";
    private static final String SELECT_USER_BY_NAME = "SELECT * FROM USERS WHERE name = ? and isActive = 1;";
    private static final String ADD_USER = "INSERT INTO USERS(name,password,email,isAdmin,birthDate,image,isActive,address) VALUES(?,?,?,?,?,?,?,?)";
    private static final String SELECT_ADMINS = "SELECT * FROM USERS WHERE isAdmin=1 and isActive=1";

    public UserDAO() {
        this.ds = MySqlDS.getDs();
    }

    public User getUser(String name, String password) {
        User user = new User();
        try {
            this.conn = ds.getConnection();
            this.ps = conn.prepareStatement(SELECT_USER);
            ps.setString(1, name);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setName(rs.getString("name"));
                user.setBirthDate(sdf.parse(rs.getString("birthDate")));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setImage(rs.getString("image"));
                user.setId(rs.getInt("id"));
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    public int addUser(User user) {
        try {
            this.conn = ds.getConnection();
            if (isExist(user.getName())) return -1;
            this.ps = conn.prepareStatement(ADD_USER);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setShort(4, user.isAdmin());
            ps.setString(5, sdf.format(user.getBirthDate()));
            ps.setString(6, "empty");
            ps.setInt(7, user.isActive());
            ps.setString(8, user.getAddress());
            int res = ps.executeUpdate();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    public List<User> getAdmins() {
        List<User> users = new ArrayList<>();
        try {
            this.conn = ds.getConnection();
            this.ps = conn.prepareStatement(SELECT_ADMINS);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setName(rs.getString("name"));
                user.setBirthDate(sdf.parse(rs.getString("birthDate")));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setId(rs.getInt("id"));
                users.add(user);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return users;
    }

    private boolean isExist(String name) throws SQLException {
        if (this.conn == null) this.conn = ds.getConnection();
        this.ps = conn.prepareStatement(SELECT_USER_BY_NAME);
        ps.setString(1, name);
        rs = ps.executeQuery();
        while (rs.next()) {
            if (rs.getString("name") != null) return true;
        }
        return false;
    }
}
