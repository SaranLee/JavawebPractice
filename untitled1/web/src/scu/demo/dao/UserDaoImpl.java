package scu.demo.dao;

import scu.demo.common.utils.JDBCUtil;
import scu.demo.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User getByUsername(User user) {
        Connection conn = JDBCUtil.getConn();
        User rtn = null;
        String sql = "select username, password, avatar from user where username = ? limit 1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rtn = new User();
                rtn.setUsername(rs.getString("username"));
                rtn.setPassword(rs.getString("password"));
                rtn.setImgUrl(rs.getString("avatar"));
                System.out.println("UserDaoImpl: 查到user：" + rtn.getUsername());
                return rtn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getByUsername(String username) {
        User user = new User();
        user.setUsername(username);
        return getByUsername(user);
    }

    @Override
    public List<User> getAllUsers() {
        Connection conn = JDBCUtil.getConn();
        List<User> users = new ArrayList<>();
        String sql = "select username, password, avatar from user";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User temp = new User();
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                temp.setImgUrl(rs.getString("avatar"));
                users.add(temp);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteByUsername(String username) {
        Connection conn = JDBCUtil.getConn();
        String sql = "delete from user where username = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(User user) {
        Connection conn = JDBCUtil.getConn();
        String sql = "insert into user(username, password, avatar) values(?, ?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getImgUrl());
            ps.execute();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}
