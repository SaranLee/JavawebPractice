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
        if(user != null && rtnUser.getPassword().equals(user.getPassword())) {
            System.out.println("user = rtnuser");
            return rtnUser;
        }
        else
            return null;
    }

    @Override
    public List<User> getAllUsers() {
        return dao.getAllUsers();
    }
}
