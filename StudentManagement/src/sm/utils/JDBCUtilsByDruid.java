package sm.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.security.spec.ECField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/***
 * @Description: 此类是通过德鲁伊数据库连接池获取连接对象
 * @Author: Wang Rui
 * @Date: 2020/11/17$
 */
public class JDBCUtilsByDruid {
    static DataSource ds;
    static {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src\\druid.properties"));

            //1.创建一个指定参数的数据流连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection() throws Exception{

        //2.从数据库连接池中获取可用的连接对象
        return ds.getConnection();
    }

    /**
     * 功能：释放资源
     * @param set
     * @param statement
     * @param connection
     * @throws Exception
     */
    public static void close(ResultSet set, Statement statement, Connection connection) {
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
