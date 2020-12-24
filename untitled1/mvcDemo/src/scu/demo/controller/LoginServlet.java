package scu.demo.controller;

import scu.demo.domain.User;
import scu.demo.service.UserService;
import scu.demo.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        User temp = new User(req.getParameter("username"), req.getParameter("password"));
        User rtnUser = userService.login(temp);
        if(rtnUser != null){
            //登录成功
            List<User> allUsers = userService.getAllUsers();
            req.setAttribute("allUsers", allUsers);
            req.getRequestDispatcher("/WEB-INF/success.jsp").forward(req,resp);
        }else{
            //登录失败
            req.setAttribute("msg", "用户名密码错误");
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
        }

    }
}
