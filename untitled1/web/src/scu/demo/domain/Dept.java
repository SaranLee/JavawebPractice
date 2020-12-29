package scu.demo.domain;

public class Dept {
    private Integer deptNo;
    private String name;
    private String location;

    public Dept() {
    }

    public Dept(Integer deptNo, String name, String location) {
        this.deptNo = deptNo;
        this.name = name;
        this.location = location;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
