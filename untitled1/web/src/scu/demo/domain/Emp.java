package scu.demo.domain;

import java.util.Date;

public class Emp extends EmpExtend{
    private Integer empNo;
    private String eName;
    private String eGender;
    private Integer eAge;
    private String job;
    private Integer mgr;
    private Date hireDate;
    private double sal;
    private double comm;
    private Integer deptNo;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEName() {
        return eName;
    }

    public void setEName(String eName) {
        this.eName = eName;
    }

    public String getEGender() {
        return eGender;
    }

    public void setEGender(String eGender) {
        this.eGender = eGender;
    }

    public Integer getEAge() {
        return eAge;
    }

    public void setEAge(Integer eAge) {
        this.eAge = eAge;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empNo=" + empNo +
                ", eName='" + eName + '\'' +
                ", eGender='" + eGender + '\'' +
                ", eAge=" + eAge +
                ", job='" + job + '\'' +
                ", mgr=" + mgr +
                ", hireDate=" + hireDate +
                ", sal=" + sal +
                ", comm=" + comm +
                ", deptNo=" + deptNo +
                '}';
    }
}
