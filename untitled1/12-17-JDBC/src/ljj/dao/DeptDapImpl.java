package ljj.dao;

import ljj.domain.Dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeptDapImpl implements DeptDao {

    private Connection conn;

    public DeptDapImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Dept getDeptByName(Dept dept) {
        Dept ret = null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from dept where dname = ?");
            ps.setString(1, dept.getDname());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ret = new Dept();
                ret.setDname(rs.getString("dname"));
                ret.setDeptno(rs.getInt("deptno"));
                ret.setLoc(rs.getString("loc"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return ret;
        }
    }

    @Override
    public List<Dept> getAllDepts() {
        List<Dept> depts = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from dept");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dept dept = new Dept();
                dept.setDname(rs.getString("dname"));
                dept.setDeptno(rs.getInt("deptno"));
                dept.setLoc(rs.getString("loc"));
                depts.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            return depts;
        }
    }
}
