package scu.demo.service;

import scu.demo.common.PageInfo;
import scu.demo.domain.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getAll();
    PageInfo list(PageInfo pageInfo);
    void deleteById(Emp emp);
    void deleteByName(String eName);
    void modify(Integer oldEmpNo, Emp emp);

    void deleteBatch(String empNos);

    List<Emp> getAllMgr();
}
