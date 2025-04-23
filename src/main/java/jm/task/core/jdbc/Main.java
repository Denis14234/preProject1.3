package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Иван", "Сидоров", (byte) 33);
        userService.saveUser("Николай", "Абромович", (byte) 45);
        userService.saveUser("Анастасия", "Романова", (byte) 33);
        userService.saveUser("Ольга", "Серябкина", (byte) 40);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
        SessionFactory sessionFactory = null;
        try {
            sessionFactory = Util.getSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            Util.shutdown();
        }
    }
}
