package scu.demo.service;

import scu.demo.dao.UserDao;
import scu.demo.dao.UserDaoImpl;
import scu.demo.domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao dao;

    public UserServiceImpl() {
        this.dao = new UserDaoImpl();
    }

    @Override
    public User login(User user) {
        User rtnUser = dao.getByUsername(user);
        if(rtnUser != null && rtnUser.getPassword().equals(user.getPassword())) {
            System.out.println("user = rtnuser");
            rtnUser.setPassword(null);
            return rtnUser;
        }
        else
            return null;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }

    @Override
    public void delete(String username) {
        dao.deleteByUsername(username);
    }

    @Override
    public void add(User user) {
        dao.insert(user);
    }

    @Override
    public boolean exist(String username) {
        User user = dao.getByUsername(username);
        return user != null;
    }
}
