package jm.task.core.jdbc.service.implementation;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    public void createUsersTable() {
        this.createUsersTable();
    }

    public void dropUsersTable() {
        this.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        this.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        this.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return this.getAllUsers();
    }

    public void cleanUsersTable() {
        this.cleanUsersTable();
    }
}
