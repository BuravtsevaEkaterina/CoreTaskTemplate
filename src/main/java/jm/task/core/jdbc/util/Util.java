package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    public static final String URL = "jdbc:mysql://localhost:3306/users?serverTimezone=UTC";
    public static final String LOGIN = "root";
    public static final String PASS = "root";

    public static Connection connection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(URL, LOGIN, PASS);
    }
}
