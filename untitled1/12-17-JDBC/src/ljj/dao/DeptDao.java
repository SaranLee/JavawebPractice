package ljj.dao;

import ljj.domain.Dept;

import java.util.List;

public interface DeptDao {
    Dept getDeptByName(Dept dept);
    List<Dept> getAllDepts();
}
