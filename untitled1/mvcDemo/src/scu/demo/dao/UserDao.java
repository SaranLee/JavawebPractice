package scu.demo.dao;

import scu.demo.domain.User;

import java.util.List;

public interface UserDao {
    User getByUsername(User user);
    List<User> getAllUsers();
}
