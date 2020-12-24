import java.sql.*;
import java.util.ArrayList;

public class JDBCDemo {

    public static void main(String[] args) {
        Connection conn = JDBCDruidUtil.getConn();
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = conn.createStatement();

            String sql = "SELECT ename, sal FROM emp WHERE sal > ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDouble(1, 2000.0);
            preparedStatement.execute();

            statement.execute("SELECT ename, sal FROM emp WHERE sal > 2000");
            resultSet = preparedStatement.getResultSet();
            while(resultSet.next())
                System.out.println(resultSet.getString("ename") + ", " + resultSet.getDouble("sal"));
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //JDBCUtil.close(resultSet, statement, conn);
        }
    }
}
