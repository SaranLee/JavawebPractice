package scu.demo.test;

import scu.demo.common.utils.MyDbUtil;

public class Test {
    public static void main(String[] args) {
        for(int i = 7999;i < 10000;i++){
            String sql = "insert into emp(empNo, eName, job, sal, deptNo) values(?, ?, ?, ?, ?)";
            MyDbUtil.executeUpdate(sql, i, "Jiajun" + i, "Boss", 99999, 10);
        }
    }
}
