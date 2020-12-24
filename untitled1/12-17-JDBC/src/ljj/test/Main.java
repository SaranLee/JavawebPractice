package ljj.test;

import ljj.common.JDBCUtil;
import ljj.dao.DeptDao;
import ljj.dao.DeptDapImpl;
import ljj.dao.EmpDao;
import ljj.dao.EmpDaoImpl;
import ljj.domain.Dept;
import ljj.domain.Emp;

import java.sql.Connection;
import java.util.*;

public class Main {

    private Scanner scanner;
    private Connection conn;
    EmpDao empDao;
    DeptDao deptDao;

    public Main() {
        scanner = new Scanner(System.in);
        conn = JDBCUtil.getConn();
        empDao = new EmpDaoImpl(conn);
        deptDao = new DeptDapImpl(conn);
    }

    private void exit(){
        JDBCUtil.close(null, null, conn);
    }

    //查看所有员工信息
    //根据员工姓名查询员工信息
    //根据姓名删除一个员工
    //新增一个员工
    //查看所有部门，包括部门所有员工信息
    //根据部门名称查询一个部门的所有员工

    public void main() {
        System.out.println("================员工管理系统===============");
        System.out.println(" 1. 查看员工");
        System.out.println(" 2. 删除员工");
        System.out.println(" 3. 添加员工");
        System.out.println(" 4. 查看部门");
        System.out.println(" 0. 退出");
        int choice = getChoice(4);
        switch (choice) {
            case 1:
                showEmp();
                break;
            case 2:
                deleteEmp();
                break;
            case 3:
                addEmp();
                break;
            case 4:
                showDept();
                break;
            case 0:
                System.exit(0);
        }
    }

    public void showEmp() {
        System.out.println("================查看员工===============");
        System.out.println(" 1. 查看所有员工信息");
        System.out.println(" 2. 通过姓名查询员工");
        System.out.println(" 0. 返回");
        int choice = getChoice(2);
        if (choice == 1) {
            Map<Emp, Dept> map = empDao.getAllEmps();
            if(map.size() == 0)
                System.err.println("没有任何员工！");
            else{
                Set<Emp> emps = map.keySet();
                Iterator<Emp> itr = emps.iterator();
                int i = 1;
                while(itr.hasNext()){
                    Emp e = itr.next();
                    Dept dept = map.get(e);
                    System.out.println("员工" + i + "（" + "员工号：" + e.getEmpno() + ", " + "姓名：" + e.getEname() + ", " + "性别：" + e.getEgender() + ", " + "年龄：" + e.getEage() + ", " + "部门号：" + dept.getDeptno() + ", 部门名称" + dept.getDname() + "）");
                    i++;
                }
            }
        } else if (choice == 2) {
            System.out.print("请输入员工姓名（支持模糊查询）：");
            String ename = scanner.next();
            ename = "%" + ename + "%";
            Emp emp = new Emp();
            emp.setEname(ename);
            Map<Emp, Dept> map = empDao.getEmpByName(emp);
            if(map.size() == 0)
                System.err.println("未找到员工！");
            else{
                Set<Emp> emps = map.keySet();
                Iterator<Emp> itr = emps.iterator();
                int i = 1;
                while(itr.hasNext()){
                    Emp e = itr.next();
                    Dept dept = map.get(e);
                    System.out.println("员工" + i + "（" + "员工号：" + e.getEmpno() + ", " + "姓名：" + e.getEname() + ", " + "性别：" + e.getEgender() + ", " + "年龄：" + e.getEage() + ", " + "部门号：" + dept.getDeptno() + ", 部门名称：" + dept.getDname() + "）");
                    i++;
                }
            }
        }
        main();
    }

    public void deleteEmp() {
        System.out.println("================删除员工===============");
        System.out.print(" 请输入员工姓名：");
        String ename = scanner.next();
        Emp emp = new Emp();
        emp.setEname(ename);
        Emp ret = empDao.deleteByName(emp);
        if(ret == null)
            System.err.println("删除失败！");
        else
            System.err.println("员工（" + ret.getEmpno() + ", " + ret.getEname() + ", " + ret.getEgender() + ", " + ret.getEage() + ", " + ret.getDeptno() + "）已删除！");

        main();
    }

    public void addEmp() {
        int empno;
        String ename;
        String egender;
        int eage;
        int deptno;
        System.out.println("================添加员工===============");
        System.out.print(" 请输入员工编号：");
        empno = scanner.nextInt();
        System.out.print(" 请输入员工姓名：");
        ename = scanner.next();
        System.out.print(" 请输入员工性别：");
        egender = scanner.next();
        System.out.print(" 请输入员工年龄：");
        eage = scanner.nextInt();
        System.out.print(" 请输入员工部门编号：");
        deptno = scanner.nextInt();

        Emp emp = new Emp();
        emp.setEmpno(empno);
        emp.setEname(ename);
        emp.setEgender(egender);
        emp.setEage(eage);
        emp.setDeptno(deptno);

        empDao = new EmpDaoImpl(conn);
        if(empDao.insert(emp))
            System.err.println("成功添加员工!");
        else
            System.err.println("添加员工失败！");

        main();
    }

    public void showDept(){
        System.out.println("================查看部门===============");
        System.out.println(" 1. 查看所有部门及其员工 ");
        System.out.println(" 2. 通过部门名称查看部门信息，及该部门所有员工");
        System.out.println(" 0. 返回");
        int choice = getChoice(2);
        if(choice == 1){
            List<Dept> depts = deptDao.getAllDepts();
            for(Dept dept : depts){
                List<Emp> emps = empDao.getEmpsIn(dept);
                System.out.println("部门编号：" + dept.getDeptno() + ", 部门名称：" + dept.getDname() + ", 部门地址：" + dept.getLoc());
                printEmps(emps.iterator());
            }
        }else if(choice == 2){
            System.out.print("请输入部门名称：");
            Dept temp = new Dept();
            temp.setDname(scanner.next());
            Dept dept = deptDao.getDeptByName(temp);
            if(dept == null)
                System.err.println("没有查找到部门！");
            else {
                System.out.println("部门编号：" + dept.getDeptno() + ", 部门名称：" + dept.getDname() + ", 部门地址：" + dept.getLoc());
                List<Emp> emps = empDao.getEmpsIn(dept);
                printEmps(emps.iterator());
            }
        }
        main();
    }


    private void printEmps(Iterator<Emp> itr){
        int i = 1;
        while(itr.hasNext()){
            Emp e = itr.next();
            System.out.println("\t员工" + i + "（" + "员工号：" + e.getEmpno() + ", " + "姓名：" + e.getEname() + ", " + "性别：" + e.getEgender() + ", " + "年龄：" + e.getEage() + "）");
            i++;
        }
    }

    private int getChoice(int max){
        int choice = scanner.nextInt();
        while(choice < 0 || choice > max) {
            System.err.print("请输入0 ~ " + max + "之间的数字：");;
            choice = scanner.nextInt();
        }
        return choice;
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.main();
    }
}
