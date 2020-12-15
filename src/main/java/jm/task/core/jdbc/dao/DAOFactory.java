package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.dao.implementation.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.implementation.UserDaoJDBCImpl;

public abstract class DAOFactory implements UserDao{
    public static DAOFactory getDAOFactory(String factory) {
        if (factory.equalsIgnoreCase("jdbc")) {
            return new UserDaoJDBCImpl();
        } else if (factory.equalsIgnoreCase("hibernate")) {
            return new UserDaoHibernateImpl();
        } else {
            return null;
        }
    }
}
