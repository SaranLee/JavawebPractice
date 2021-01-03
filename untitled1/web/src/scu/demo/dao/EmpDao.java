package scu.demo.dao;

import scu.demo.common.PageInfo;
import scu.demo.domain.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> getAll();
    List<Emp> getAllMgr();
    PageInfo list(PageInfo pageInfo);
    void delete(Emp emp);
    void modify(Integer oldEmpNo, Emp emp);
    void deleteBatch(String empNos);
}
