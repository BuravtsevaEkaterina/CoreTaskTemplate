package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.implementation.UserServiceImpl;

public class Main {
    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        userService.createUsersTable();
        userService.saveUser("Ekaterina", "Buravtseva", (byte) 24);
        userService.saveUser("Emily", "Scott", (byte) 25);
        userService.saveUser("Alex", "Miller", (byte) 31);
        userService.saveUser("Mike", "Ivanov", (byte) 39);
        System.out.println(userService.getAllUsers());
        userService.removeUserById(1);
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        System.out.println(userService.getAllUsers());
        userService.dropUsersTable();
    }
}

