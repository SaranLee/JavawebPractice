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
        String sql = "select username, password from user where username = ? limit 1";
        System.out.println("查询user...");
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rtn = new User();
                rtn.setUsername(rs.getString("username"));
                rtn.setPassword(rs.getString("password"));
                System.out.println("查到user：" + rtn.getUsername());
                return rtn;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        Connection conn = JDBCUtil.getConn();
        List<User> users = new ArrayList<>();
        String sql = "select username, password from user";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                User temp = new User();
                temp.setUsername(rs.getString("username"));
                temp.setPassword(rs.getString("password"));
                users.add(temp);
                return users;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
