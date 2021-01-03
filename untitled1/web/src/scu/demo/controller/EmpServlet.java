package scu.demo.controller;

import scu.demo.common.Constant;
import scu.demo.common.PageInfo;
import scu.demo.domain.Dept;
import scu.demo.domain.Emp;
import scu.demo.service.DeptService;
import scu.demo.service.DeptServiceImpl;
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
    private DeptService deptService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        empService = new EmpServiceImpl();
        deptService = new DeptServiceImpl();
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
        String pnStr = req.getParameter("pn");
        String psStr = req.getParameter("ps");
        int pn = Integer.parseInt((pnStr == null)?"1":pnStr);
        int ps = Integer.parseInt((psStr == null)?"10":psStr);
        PageInfo<Emp> pageInfo = new PageInfo<>(pn, ps);

        List<Emp> mgrs = empService.getAllMgr();
        pageInfo = empService.list(pageInfo);
        List<Dept> depts = deptService.getAll();
        req.setAttribute("pageInfo", pageInfo);
        req.setAttribute("depts", depts);
        req.setAttribute("mgrs", mgrs);
        req.getRequestDispatcher("/pages/emplist.jsp").forward(req, resp);
    }

    //修改信息
    protected void modify(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Emp emp = new Emp();
        emp.setEmpNo(Integer.valueOf(req.getParameter("empNo")));
        emp.setEName(req.getParameter("eName"));
        emp.setJob(req.getParameter("job"));
        emp.setMgr(Integer.valueOf(req.getParameter("mgr")));
        emp.setSal(Double.valueOf(req.getParameter("sal")));
        emp.setDeptNo(Integer.valueOf(req.getParameter("deptNo")));
        empService.modify(Integer.valueOf(req.getParameter("oldEmpNo")), emp);
        PrintWriter out = resp.getWriter();
        out.print("ok");
        out.flush();
    }

    //删除员工
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Emp emp = new Emp();
        emp.setEmpNo(Integer.valueOf(req.getParameter("empNo")));
        empService.deleteById(emp);
        PrintWriter out = resp.getWriter();
        out.print("ok");
        out.flush();
    }

    //批量删除员工
    protected void deleteBatch(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empNos = req.getParameter("empNos");
        empService.deleteBatch(empNos);
        PrintWriter out = resp.getWriter();
        out.print(Constant.RESP_SUCCESS);
        out.flush();
    }

    //获取所有emp，返回json字符串
    protected void getAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Emp> emps = empService.getAll();
    }
}
