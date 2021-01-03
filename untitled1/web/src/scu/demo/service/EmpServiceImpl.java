package scu.demo.service;

import scu.demo.common.PageInfo;
import scu.demo.dao.EmpDao;
import scu.demo.dao.EmpDaoImpl;
import scu.demo.domain.Emp;

import java.util.List;

public class EmpServiceImpl implements EmpService {

    private EmpDao dao;

    public EmpServiceImpl() {
        this.dao = new EmpDaoImpl();
    }

    @Override
    public List<Emp> getAll() {
        return dao.getAll();
    }

    @Override
    public PageInfo list(PageInfo pageInfo) {
        return dao.list(pageInfo);
    }

    @Override
    public void deleteById(Emp emp) {
        dao.delete(emp);
    }

    @Override
    public void deleteByName(String eName) {
        Emp emp = new Emp();
        emp.setEName(eName);
        deleteById(emp);
    }

    @Override
    public void modify(Integer oldEmpNo, Emp emp) {
        dao.modify(oldEmpNo, emp);
    }

    @Override
    public void deleteBatch(String empNos) {
        dao.deleteBatch(empNos);
    }

    @Override
    public List<Emp> getAllMgr() {
        return dao.getAllMgr();
    }
}
