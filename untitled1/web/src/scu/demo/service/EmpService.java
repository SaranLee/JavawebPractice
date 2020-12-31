package scu.demo.service;

import scu.demo.domain.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> getAll();
    void deleteByName(Emp emp);
    void deleteByName(String eName);
    void modify(Emp emp);

}
