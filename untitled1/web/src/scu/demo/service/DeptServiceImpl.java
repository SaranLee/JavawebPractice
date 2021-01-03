package scu.demo.service;

import scu.demo.dao.DeptDao;
import scu.demo.dao.DeptDaoImpl;
import scu.demo.domain.Dept;

import java.util.List;

public class DeptServiceImpl implements DeptService {
    DeptDao dao;

    public DeptServiceImpl() {
        this.dao = new DeptDaoImpl();
    }

    @Override
    public List<Dept> getAll() {
        return dao.getAll();
    }
}
