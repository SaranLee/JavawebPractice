package scu.demo.domain;

public class Dept {
    private Integer deptNo;
    private String dName;
    private String loc;

    public Dept() {
    }

    public Dept(Integer deptNo, String name, String location) {
        this.deptNo = deptNo;
        this.dName = name;
        this.loc = location;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDName() {
        return dName;
    }

    public void setDName(String dName) {
        this.dName = dName;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
