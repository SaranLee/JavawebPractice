package scu.demo.domain;

public class EmpExtend {
    private Emp mgrEmp;
    private Dept dept;

    public EmpExtend() {
    }

    public EmpExtend(Emp mgrEmp, Dept dept) {
        this.mgrEmp = mgrEmp;
        this.dept = dept;
    }

    public Emp getMgrEmp() {
        return mgrEmp;
    }

    public void setMgrEmp(Emp mgrEmp) {
        this.mgrEmp = mgrEmp;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }
}
