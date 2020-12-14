package jm.task.core.jdbc.service.implementation;

import jm.task.core.jdbc.dao.implementation.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;

import java.util.List;


public class UserServiceJDBCImpl implements UserService {
    UserDaoJDBCImpl dao = new UserDaoJDBCImpl();

    public void createUsersTable() {
        dao.createUsersTable();
    }

    public void dropUsersTable() {
        dao.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        dao.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        dao.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    public void cleanUsersTable() {
        dao.cleanUsersTable();
    }
}
