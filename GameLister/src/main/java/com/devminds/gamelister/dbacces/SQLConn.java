package com.devminds.gamelister.dbacces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConn {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/listagames", "root", "root");
    }
}
