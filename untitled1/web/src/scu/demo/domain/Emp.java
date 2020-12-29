package scu.demo.domain;

public class Emp {
    private Integer empNo;
    private String name;
    private String job;
    private Integer mgr;
    private double sal;
    private Integer depNo;

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public Integer getDepNo() {
        return depNo;
    }

    public void setDepNo(Integer depNo) {
        this.depNo = depNo;
    }
}
