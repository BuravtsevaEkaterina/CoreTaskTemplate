package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.implementation.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.implementation.UserDaoJDBCImpl;

import java.io.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        Properties property = new Properties();
        String system = null;
        UserDao userDao = null;
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            property.load(fis);
            system = property.getProperty("system");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (system.equals("jdbc")) {
            userDao = new UserDaoJDBCImpl();
        } else if (system.equals("hibernate")) {
            userDao = new UserDaoHibernateImpl();
        }
        userDao.createUsersTable();
        userDao.saveUser("Ekaterina", "Buravtseva", (byte) 24);
        userDao.saveUser("Emily", "Scott", (byte) 25);
        userDao.saveUser("Alex", "Miller", (byte) 31);
        userDao.saveUser("Mike", "Ivanov", (byte) 37);
        System.out.println(userDao.getAllUsers());
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}

