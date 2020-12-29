package com.servlet;

import com.common.JDBCUtil;
import com.dao.UserDao;
import com.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + " : " + password);

        Connection conn = JDBCUtil.getConn();
        UserDao userDao = new UserDao(conn);
        User user = userDao.check(username, password);
        //用户名密码正确
        if(user != null){

            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else{
            req.setAttribute("warning", "用户名密码不正确！");
            req.getRequestDispatcher("WEB-INF/web.xml").forward(req, resp);
//            resp.sendRedirect("http://192.168.0.27:8080/myweb/pages/login.jsp");
        }


    }
}
