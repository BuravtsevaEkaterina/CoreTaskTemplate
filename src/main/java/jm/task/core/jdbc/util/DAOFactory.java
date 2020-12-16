package jm.task.core.jdbc.util;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.implementation.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.implementation.UserDaoJDBCImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class DAOFactory implements UserDao {
    public static DAOFactory getDAOFactory() {
        Properties property = new Properties();
        String system = null;
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            property.load(fis);
            system = property.getProperty("system");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (system.equalsIgnoreCase("jdbc")) {
            return new UserDaoJDBCImpl();
        } else if (system.equalsIgnoreCase("hibernate")) {
            return new UserDaoHibernateImpl();
        } else {
            return null;
        }
    }
}
