package demo.domain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String role;
    private String sex;
    private Integer age;
    private String addr;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", addr='" + addr + '\'' +
                '}';
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public int getRoleCount(){
        return Role.class.getDeclaredFields().length;
    }
    public List<String> getRoles(){
        Class<Role> roleClass = Role.class;
        Field[] fields = roleClass.getDeclaredFields();
        Role role = new Role() {
        };
        List<String> roles = new ArrayList<>();
        Arrays.stream(fields).forEach(field->{
            try {
                roles.add((String) field.get(role));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
        return roles;
    }

    interface Role{
        String STUDENT = "学生";
        String TEACHER = "老师";
        String ADMIN= "管理员";
    }
}
