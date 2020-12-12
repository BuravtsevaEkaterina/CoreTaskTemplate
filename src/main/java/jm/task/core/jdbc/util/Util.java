package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String URL = "jdbc:mysql://localhost:3306/users?serverTimezone=UTC";
    private static final String LOGIN = "root";
    private static final String PASS = "root";

    public static Connection connection() throws SQLException, ClassNotFoundException {
        return DriverManager.getConnection(URL, LOGIN, PASS);
    }
}
