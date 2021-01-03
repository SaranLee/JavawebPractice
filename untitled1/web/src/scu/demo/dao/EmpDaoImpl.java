package scu.demo.dao;

import scu.demo.common.PageInfo;
import scu.demo.common.utils.JDBCUtil;
import scu.demo.common.utils.MyDbUtil;
import scu.demo.domain.Dept;
import scu.demo.domain.Emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    //empNo,eName,eGender,eAge,job,mgr,hireDate,sal,comm,deptNo
    @Override
    public List<Emp> getAll() {
        String sql = "select * from emp";
        List<Emp> emps = MyDbUtil.executeQuery(Emp.class, sql);
        setMgrAndDept(emps);
        return emps;
    }

    @Override
    public List<Emp> getAllMgr() {
        String sql = "select * from emp where empNo < 8000";
        return MyDbUtil.executeQuery(Emp.class, sql);
    }

    @Override
    public PageInfo list(PageInfo pageInfo) {
        String sql = "select * from emp limit ?,?";
        List<Emp> emps = MyDbUtil.executeQuery(Emp.class, sql, (pageInfo.getPageNo() - 1)*pageInfo.getPageSize(), pageInfo.getPageSize());
        setMgrAndDept(emps);
        pageInfo.setList(emps);
        //以下获取总记录数
        pageInfo.setTotalRecord(MyDbUtil.getTotalRecordCount("emp"));
        return pageInfo;
    }

    @Override
    public void delete(Emp emp) {
        String sql = "delete from emp where empNo=?";
        MyDbUtil.executeUpdate(sql, emp.getEmpNo());
    }

    @Override
    public void modify(Integer oldEmpNo, Emp emp) {
        String sql = "update emp set empNo=?, eName=?, job=?, mgr=?, sal=?, deptNo=? where empNo=? limit 1";
        Connection conn = JDBCUtil.getConn();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, emp.getEmpNo());
            ps.setString(2, emp.getEName());
            ps.setString(3, emp.getJob());
            ps.setInt(4, emp.getMgr());
            ps.setDouble(5, emp.getSal());
            ps.setInt(6, emp.getDeptNo());
            ps.setInt(7, oldEmpNo);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteBatch(String empNos) {
        String sql = "delete from emp where empNo in (" + empNos + ")";
        MyDbUtil.executeUpdate(sql);
    }

    private void setMgrAndDept(List<Emp> emps){
        emps.stream().forEach(emp->{
            String sql2 = "select * from emp where empNo=? limit 1";
            List<Emp> mgrs = MyDbUtil.executeQuery(Emp.class, sql2, emp.getMgr());
            if(mgrs.size() > 0)
                emp.setMgrEmp(mgrs.get(0));

            sql2 = "select * from dept where deptNo=? limit 1";
            List<Dept> depts = MyDbUtil.executeQuery(Dept.class, sql2, emp.getDeptNo());
            if(depts.size() > 0)
                emp.setDept(depts.get(0));
        });
    }
}
