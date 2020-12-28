package scu.demo.service;

import scu.demo.domain.User;

import java.util.List;

public interface UserService {
    User login(User user);
    List<User> getAllUsers();
    void delete(String username);
    void add(User user);
    boolean exist(String username);
}
