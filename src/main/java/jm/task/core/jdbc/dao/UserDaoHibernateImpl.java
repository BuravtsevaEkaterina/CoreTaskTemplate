package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {
    private static Transaction transaction;
    private static Session session;


    public UserDaoHibernateImpl() {}


    @Override
    public void createUsersTable() {
        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("CREATE TABLE users_table");
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error in createTable");
            e.printStackTrace();
        }
    }

    @Override
    public void dropUsersTable() {
        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("DROP TABLE users_table").executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error in dropTable");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            session = Util.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            User user = new User(name, lastName, age);
            session.save(user);
            transaction.commit();
            System.out.println("User с именем - " + name + " добавлен в базу данных");
        } catch (Exception e) {
            System.out.println("Error in save");
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void removeUserById(long id) {
        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("DELETE FROM users_table WHERE ID = " + id).executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error in removeByID");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            userList = (List<User>) session.createSQLQuery("SELECT * FROM users_table").addEntity(User.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error in getUsers");
            e.printStackTrace();
        } finally {
            session.close();
            return userList;
        }

    }

    @Override
    public void cleanUsersTable() {
        try {
            session = Util.getSessionFactory().openSession();
            session.beginTransaction();
            session.createSQLQuery("DELETE FROM users_table").executeUpdate();
        } catch (Exception e) {
            System.out.println("Error in cleanTable");
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
