package scu.demo.controller;

import scu.demo.domain.Dept;
import scu.demo.service.DeptService;
import scu.demo.service.DeptServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class DeptServlet extends HttpServlet {
    private DeptService deptService = new DeptServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        System.out.println("methodName: " + methodName);
        try {
            Class<?> deptServlet = DeptServlet.class;
            Method method = deptServlet.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> depts = deptService.getAll();
        PrintWriter out = resp.getWriter();

    }
}
