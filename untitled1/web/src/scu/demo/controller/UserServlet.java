package scu.demo.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import scu.demo.domain.User;
import scu.demo.service.UserService;
import scu.demo.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String methodName = req.getParameter("method");
        System.out.println("methodName: " + methodName);
        try {
            Class<?> userServlet = UserServlet.class;
            Method method = userServlet.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //登录
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        User temp = new User(req.getParameter("username"), req.getParameter("password"), null);
        User rtnUser = userService.login(temp);
        if (rtnUser != null) {
            //登录成功
            //用户成功登录，没有loginUser的cookie就添加这个cookie
//            boolean flag = false;
//            Cookie[] cookies = req.getCookies();
//            for(Cookie e : cookies){
//                if(e.getName().equals("loginUser")){
//                    flag = true;
//                    break;
//                }
//            }
//            if(!flag) {
//                Cookie cookie = new Cookie("loginUser", rtnUser.getUsername());
//                cookie.setMaxAge(10);
//                resp.addCookie(cookie);
//            }
            HttpSession session = req.getSession();
            session.setAttribute("loginUser", rtnUser);
            req.getRequestDispatcher("pages/main.jsp").forward(req, resp);
        } else {
            //登录失败
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher("pages/login.jsp").forward(req, resp);
        }
    }

    //获取所有用户list
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        List<User> users = userService.getAllUsers();
        req.setAttribute("userList", users);
        req.getRequestDispatcher("/pages/userlist.jsp").forward(req, resp);
    }

    //删除用户
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserService userService = new UserServiceImpl();
        userService.delete(username);
        PrintWriter out = resp.getWriter();
        out.print("ok");
        out.flush();
    }

    //添加用户
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        UserService userService = new UserServiceImpl();
        userService.add(new User(req.getParameter("username"), req.getParameter("password"), req.getContextPath() + "static/adminlte/dist/img/avatar.png"));
        PrintWriter out = resp.getWriter();
        out.print("ok");
        out.flush();
    }

    //查询用户（用户名）是否已经存在
    protected void exist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserServiceImpl();
        PrintWriter out = resp.getWriter();
        out.print(String.valueOf(userService.exist(req.getParameter("username"))));
        System.out.println("用户名重名：" + userService.exist(req.getParameter("username")));
        out.flush();
    }

}
