package demo.mapper;

import demo.domain.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User getUserById(int id);
    List<User> getUserByAddrAndSex(@Param("addr") String addr, @Param("sex")String sex);
    List<User> getUserByAddrAndSexUser(@Param("user") User user);
    List<User> getUserByAddrs(@Param("addrs") List<String> addrs);
    List<User> getUserLikeName(String pattern);
    List<User> getUserLikeName1(String pattern);
    void insertUser(User user);
    void insertUsers(@Param("list") List<User> users);
    void updateUserByUsername(User user);
    void updateUserById(User user);
    List<User> listByUser(User user);
    @MapKey("id")
    Map<Integer, User> getUsers();
    List<User> getAllUsers();
}
