package scu.demo.dao;

import scu.demo.common.utils.MyDbUtil;
import scu.demo.domain.Dept;

import java.util.List;

public class DeptDaoImpl implements DeptDao {
    @Override
    public List<Dept> getAll() {
        String sql = "select * from dept";
        return MyDbUtil.executeQuery(Dept.class, sql);
    }
}
