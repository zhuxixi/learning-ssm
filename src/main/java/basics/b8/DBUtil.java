package basics.b8;

import java.sql.*;

/**
 * 数据库操作类
 * @author zhuzh
 * @date 2020.07.28
 */
public class DBUtil {

    private static DBUtil dbUtil;
    private static Connection connection;

    /**
     * 实例化数据库操作类
     * @param driver
     * @param url
     * @param user
     * @param password
     * @return
     */
    public static void prepare(String driver, String url, String user, String password){
        if (dbUtil==null){
            synchronized (DBUtil.class){
                if (dbUtil==null){
                    dbUtil = new DBUtil(driver, url, user, password);
                }
            }
        }
    }

    /**
     * 初始化结束后直接get即可
     * @return
     */
    public static DBUtil getInstance(){
        if (dbUtil==null){
            throw new IllegalStateException("数据库操作类还未初始化！");
        }
        return dbUtil;
    }

    /**
     * 单例类的构造方法必须私有化，否则可能有人通过new 创造多个实例
     * @param driver
     * @param url
     * @param user
     * @param password
     */
    private DBUtil(String driver,String url,String user,String password){
        getConnection(driver, url, user, password);
    }

    /**
     * 为了节约资源，只创建一个连接
     * @param driver
     * @param url
     * @param user
     * @param password
     */
    public void getConnection(String driver,String url,String user,String password){

            try {
                // 注册 JDBC 驱动
                Class.forName(driver);
                // 打开链接
                System.out.println("连接数据库...");
                connection = DriverManager.getConnection(url, user, password);
            }catch (ClassNotFoundException |SQLException e){
                e.printStackTrace();
            }
    }

    public static Connection getConnection() {
        return connection;
    }

    public void destroy(){
        if (connection!=null){
            try {
                connection.close();
                connection=null;
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
