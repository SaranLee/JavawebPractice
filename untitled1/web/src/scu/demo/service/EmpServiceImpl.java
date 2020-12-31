package scu.demo.service;

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
    public void deleteByName(Emp emp) {
        dao.delete(emp);
    }

    @Override
    public void deleteByName(String eName) {
        Emp emp = new Emp();
        emp.setEName(eName);
        deleteByName(emp);
    }

    @Override
    public void modify(Emp emp) {
        dao.modify(emp);
    }
}
