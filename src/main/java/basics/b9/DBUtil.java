package basics.b9;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 数据库操作类
 * @author zhuzh
 * @date 2020.07.28
 */
public class DBUtil {


    private static DataSource dataSource;

    public static Connection getConnection() {
        if (dataSource == null){
            try {
                Context initCtx = new InitialContext();
                Context envCtx = (Context) initCtx.lookup("java:comp/env");
                dataSource = (DataSource) envCtx.lookup("jdbc/login");
            } catch ( NamingException e) {
                e.printStackTrace();
            }
        }
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;

    }
}
