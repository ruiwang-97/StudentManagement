package sm.dao;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import sm.utils.JDBCUtilsByDruid;

import java.sql.Connection;
import java.util.List;

/***
 *
 *
 *
 * @Author: Wang Rui
 * @Date: 2020/11/18$
 */

/**
 * 功能：通用的增删改方法，针对于任何表
 */
//泛型类
public class BasicDao<T> {
    QueryRunner qr = new QueryRunner();

    public int update(String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();

            int update = qr.update(connection, sql, params);
            return update;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 功能：返回单个对象，针对于任何表
     */
    public T querySingle(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
//        QueryRunner qr = new QueryRunner();
            return qr.query(connection, sql, new BeanHandler<T>(clazz), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 功能：返回多个对象，针对于任何表
     */
    public List<T> queryMulti(String sql, Class<T> clazz, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
//            QueryRunner qr = new QueryRunner();
            return qr.query(connection, sql, new BeanListHandler<T>(clazz), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }

    /**
     * 功能：返回单个值，针对于任何表
     */
    public Object scalar(String sql, Object... params) {
        Connection connection = null;
        try {
            connection = JDBCUtilsByDruid.getConnection();
//            QueryRunner qr = new QueryRunner();
            return qr.query(connection, sql, new ScalarHandler(), params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
