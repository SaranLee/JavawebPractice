package scu.demo.dao;

import scu.demo.common.utils.MyDbUtil;
import scu.demo.domain.Dept;
import scu.demo.domain.Emp;

import java.util.List;

public class EmpDaoImpl implements EmpDao {
    //empNo,eName,eGender,eAge,job,mgr,hireDate,sal,comm,deptNo
    @Override
    public List<Emp> getAll() {
        String sql = "select * from emp";
        List<Emp> emps = MyDbUtil.executeQuery(Emp.class, sql);
        emps.stream().forEach(emp->{
            String sql2 = "select * from emp where empNo=? limit 1";
            List<Emp> mgrs = MyDbUtil.executeQuery(Emp.class, sql2, emp.getEmpNo());
            if(mgrs.size() > 0)
                emp.setMgrEmp(mgrs.get(0));

            sql2 = "select * from dept where deptNo=? limit 1";
            List<Dept> depts = MyDbUtil.executeQuery(Dept.class, sql2, emp.getDeptNo());
            if(depts.size() > 0)
                emp.setDept(depts.get(0));
        });
        return emps;
    }

    @Override
    public void delete(Emp emp) {

    }

    @Override
    public void modify(Emp emp) {

    }
}
