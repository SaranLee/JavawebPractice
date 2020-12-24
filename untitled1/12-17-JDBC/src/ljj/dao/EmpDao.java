package ljj.dao;

import ljj.domain.Dept;
import ljj.domain.Emp;

import java.util.List;
import java.util.Map;

public interface EmpDao {
    boolean insert(Emp emp);
    Emp deleteByName(Emp emp);
    Map<Emp, Dept> getEmpByName(Emp emp);
    Map<Emp, Dept> getAllEmps();
    List<Emp> getEmpsIn(Dept dept);
}
