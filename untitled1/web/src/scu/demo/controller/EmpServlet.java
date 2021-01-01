package scu.demo.controller;

import scu.demo.domain.Emp;
import scu.demo.service.EmpService;
import scu.demo.service.EmpServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/emp")
public class EmpServlet extends HttpServlet {

    private EmpService empService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        empService = new EmpServiceImpl();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String methodName = req.getParameter("method");
        System.out.println("methodName: " + methodName);
        try {
            Class<?> empServlet = EmpServlet.class;
            Method method = empServlet.getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    //list全部员工
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> emps = empService.getAll();
        req.setAttribute("emps", emps);
        req.getRequestDispatcher("/pages/emplist.jsp").forward(req, resp);
    }

    //修改信息
    protected void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Emp emp = new Emp();
        emp.setEmpNo(Integer.valueOf(req.getParameter("empNo")));
        emp.setEName(req.getParameter("eName"));
        emp.setJob(req.getParameter("job"));
        emp.setSal(Double.valueOf(req.getParameter("sal")));
        empService.modify(Integer.valueOf(req.getParameter("oldEmpNo")), emp);
        PrintWriter out = resp.getWriter();
        out.print("ok");
        out.flush();
    }
}
