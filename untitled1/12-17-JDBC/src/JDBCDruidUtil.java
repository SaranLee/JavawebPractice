import com.alibaba.druid.pool.DruidDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCDruidUtil {
    private static String driver;   //JDBC Driver类的全类名。jdbc 5.1和jdbc 8.0不一样
    private static String url;      //获取连接需要的url。通常为 "jdbc:mysql://localhost:3306/数据库名"
    private static String username; //连接数据库的用户名
    private static String password; //连接数据库的密码
    private static DruidDataSource dds; //连接池
    /**
     * 从<tt>jdbc.properties</tt>配置文件中获取连接用到的参数 。
     * 文件存放在和<tt>JDBCUtil</tt>类同级的目录下。
     */
    static {
        InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties pro = new Properties();
        try {
            pro.load(is);
            driver = pro.getProperty("driver");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");

            dds = new DruidDataSource();

            dds.setDriverClassName(driver);
            dds.setUrl(url);
            dds.setUsername(username);
            dds.setPassword(password);

            dds.setInitialSize(3);  //设置初始连接数量
            dds.setMaxActive(10);   //设置最大连接数量
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConn(){
        Connection conn = null;
        try {
            conn = dds.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
