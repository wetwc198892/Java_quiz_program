package com.example.week3day5.config;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.SQLException;

public class MySqlDS {
    private static DataSource ds;

    static {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setServerName("localhost");
        dataSource.setPortNumber(3306);
        dataSource.setDatabaseName("test");
        dataSource.setUser("root");
        dataSource.setPassword("admin");
        try {
            dataSource.setAllowMultiQueries(true);
            dataSource.setServerTimezone("PST");
            dataSource.setRewriteBatchedStatements(true);
            ds = dataSource;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private MySqlDS() {
    }

    public static DataSource getDs() {
        return ds;
    }
}
