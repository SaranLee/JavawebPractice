package scu.demo.dao;

import scu.demo.domain.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> getAll();
    void delete(Emp emp);
    void modify(Emp emp);
}
