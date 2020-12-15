package jm.task.core.jdbc.service.implementation;

import jm.task.core.jdbc.dao.DAOFactory;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class UserServiceImpl implements UserService {
    private static final UserDao userDao;
    static {
        Properties property = new Properties();
        String system = null;
        try (FileInputStream fis = new FileInputStream("src/main/resources/config.properties")) {
            property.load(fis);
            system = property.getProperty("system");
        } catch (IOException e) {
            e.printStackTrace();
        }
        userDao = DAOFactory.getDAOFactory(system);
    }

    public void createUsersTable() {
        userDao.createUsersTable();
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(new User(name, lastName, age));
    }

    @Override
    public User getUserById(long id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    public void removeUserById(long id) {
        userDao.removeUserById(getUserById(id));
    }

    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
    }

}
