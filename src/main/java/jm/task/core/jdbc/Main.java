package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;

public class Main {
    private static final UserDaoHibernateImpl userDaoHib = new UserDaoHibernateImpl();

    public static void main(String[] args) {
        userDaoHib.createUsersTable();
        userDaoHib.saveUser("Ekaterina", "Buravtseva", (byte) 24);
        userDaoHib.saveUser("Emily", "Scott", (byte) 25);
        userDaoHib.saveUser("Alex", "Miller", (byte) 31);
        userDaoHib.saveUser("Mike", "Ivanov", (byte) 37);
        System.out.println(userDaoHib.getAllUsers());
        userDaoHib.cleanUsersTable();
        userDaoHib.dropUsersTable();
    }
}

