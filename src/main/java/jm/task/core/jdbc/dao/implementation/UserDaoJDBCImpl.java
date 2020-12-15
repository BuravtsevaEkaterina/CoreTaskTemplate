package jm.task.core.jdbc.dao.implementation;

import jm.task.core.jdbc.dao.DAOFactory;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl extends DAOFactory {
    private Connection connection;
    private Statement statement;

    {
        try {
            connection = Util.connection();
            statement = connection.createStatement(
                    ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_UPDATABLE
            );
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public UserDaoJDBCImpl() {}

    public void createUsersTable() {
        try {
            statement.executeUpdate("CREATE TABLE users (ID INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(15), lastName VARCHAR(20), age INT)");
        } catch (SQLSyntaxErrorException e) {
            System.out.println("Table already exist");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try {
            statement.executeUpdate("DROP TABLE users");
        } catch (SQLSyntaxErrorException e) {
            System.out.println("Table do not exist");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void saveUser(User user) {
        try {
            statement.execute("INSERT INTO users(name, lastName, age) VALUES ('" + user.getName() + "', '" + user.getLastName() + "', '" + user.getAge() + "')");
            System.out.println("User с именем - " + user.getName() + " добавлен в базу данных");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

    public void removeUserById(User user) {
        try {
            statement.execute("DELETE FROM users WHERE ID='" + user.getId() + "'");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<>();
        User user;
        try {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            while (resultSet.next()) {
                user = new User(resultSet.getString("name"),
                        resultSet.getString("lastName"),
                        (byte)resultSet.getInt("age"));
                user.setId((long) resultSet.getInt("ID"));
                usersList.add(user);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } finally {
            return usersList;
        }
    }

    public void cleanUsersTable() {
        try {
            statement.execute("DELETE FROM users");
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
