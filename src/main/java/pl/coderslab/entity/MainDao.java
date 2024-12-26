package pl.coderslab.entity;

import java.sql.SQLException;

import java.util.List;

public class MainDao {
    public static void main(String[] args) throws SQLException {

        UserDao userDao = new UserDao();

        User user = new User();
        user.setUserName("test1");
        user.setPassword("12345");
        user.setEmail("test@test1.com");
        userDao.create(user);

        User user2 = new User();
        user2.setUserName("test2");
        user2.setPassword("12345");
        user2.setEmail("test@test2.com");
        userDao.create(user2);

        User user3 = new User();
        user3.setUserName("test3");
        user3.setPassword("12345");
        user3.setEmail("test@test3.com");
        userDao.create(user3);

        System.out.println(userDao.read(1));
        System.out.println(userDao.read(2));
        System.out.println(userDao.read(3));

        User updateUser = userDao.read(1);
        updateUser.setUserName("Maksim Abramovich");
        updateUser.setEmail("maksim@gmail.com");
        updateUser.setPassword("12345AM");
        userDao.update(updateUser);

        User updateUser2 = userDao.read(2);
        updateUser2.setUserName("Herbert Schildt");
        updateUser2.setEmail("herbert@gmail.com");
        updateUser2.setPassword("12345HS");
        userDao.update(updateUser2);

        System.out.println(userDao.read(1));
        System.out.println(userDao.read(2));
        System.out.println(userDao.read(3));

        userDao.delete(3);


        List<User> users = userDao.findAll();
        for (User u : users) {
            System.out.println(u);

        }
    }
}