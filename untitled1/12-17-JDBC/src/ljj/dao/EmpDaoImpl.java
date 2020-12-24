package ljj.dao;

import ljj.domain.Dept;
import ljj.domain.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class EmpDaoImpl implements EmpDao {

    private Connection conn;

    public EmpDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean insert(Emp emp) {
        try {
            PreparedStatement ps = conn.prepareStatement("insert into emp(empno, ename, eage, egender, deptno) values (?, ?, ?, ?, ?)");
            ps.setInt(1, emp.getEmpno());
            ps.setString(2, emp.getEname());
            ps.setInt(3, emp.getEage());
            ps.setString(4, emp.getEgender());
            ps.setInt(5, emp.getDeptno());
            ps.execute();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Emp deleteByName(Emp emp) {
        Emp ret = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from emp where ename = ? LIMIT 1");
            ps.setString(1, emp.getEname());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ret = new Emp();
                ret.setEmpno(rs.getInt("empno"));
                ret.setEname(rs.getString("ename"));
                ret.setEage(rs.getInt("eage"));
                ret.setEgender(rs.getString("egender"));
                ret.setDeptno(rs.getInt("deptno"));
            }
            ps = conn.prepareStatement("delete from emp where ename = ? LIMIT 1");
            ps.setString(1, emp.getEname());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return ret;
        }
    }

    @Override
    public Map<Emp, Dept> getEmpByName(Emp emp) {
        Map<Emp, Dept> map = new LinkedHashMap<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from emp join dept on emp.deptno = dept.deptno where ename like ?");
            ps.setString(1, emp.getEname());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emp emp1 = new Emp();
                Dept dept = new Dept();
                emp1.setEmpno(rs.getInt("empno"));
                emp1.setEname(rs.getString("ename"));
                emp1.setEgender(rs.getString("egender"));
                emp1.setEage(rs.getInt("eage"));
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                map.put(emp1, dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return map;
        }
    }

    @Override
    public Map<Emp, Dept> getAllEmps() {
        Map<Emp, Dept> map = new LinkedHashMap<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from emp join dept on emp.deptno = dept.deptno");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emp emp = new Emp();
                Dept dept = new Dept();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setEgender(rs.getString("egender"));
                emp.setEage(rs.getInt("eage"));
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                map.put(emp, dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return map;
        }
    }

    @Override
    public List<Emp> getEmpsIn(Dept dept) {
        List<Emp> emps = new ArrayList<>();
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from emp JOIN dept on emp.deptno = dept.deptno where dname = ?");
            ps.setString(1, dept.getDname());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Emp emp = new Emp();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setEgender(rs.getString("egender"));
                emp.setEage(rs.getInt("eage"));
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                emps.add(emp);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return emps;
        }

    }
}
