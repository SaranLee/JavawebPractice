package scu.demo.dao;

import scu.demo.domain.User;

import java.util.List;

public interface UserDao {
    User getByUsername(User user);
    User getByUsername(String username);
    List<User> getAllUsers();
    void deleteByUsername(String username);
    void insert(User user);
}
