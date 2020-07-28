package basics.b7;

import java.sql.*;

public class DBUtil {
//    /**
//     * MySQL 8.0 以上版本 - JDBC 驱动名及数据库 URL
//     */
//    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
//    private static final String DB_URL = "jdbc:mysql://123.207.173.146:3306/login";
//    /**
//     * 数据库的用户名与密码，需要根据自己的设置
//     */
//    private static final String USER = "test";
//    private static final String PASS = "Clic1234!";
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
    public static DBUtil getInstance(String driver,String url,String user,String password){
        if (dbUtil==null){
            synchronized (DBUtil.class){
                if (dbUtil==null){
                    dbUtil = new DBUtil(driver, url, user, password);
                }
            }
        }
        return dbUtil;
    }

    /**
     *
     * @return
     */
    public static DBUtil getInstance(){
        if (dbUtil==null){
            throw new IllegalStateException("数据库操作类还未初始化！");
        }
        return dbUtil;
    }
    private DBUtil(String driver,String url,String user,String password){
        getConnection(driver, url, user, password);
    }

    private void getConnection(String driver,String url,String user,String password){
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

    public boolean checkUser(String username,String password) {
        Statement stmt = null;
        boolean result = false;
        try{
            stmt = connection.createStatement();
            String sql = "SELECT id, username, password FROM t_user where username="+username;
            ResultSet rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("username");
                String realPassWord = rs.getString("password");
                result = realPassWord.equals(password);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(Exception e){
            // 处理 Class.forName 错误
            e.printStackTrace();
        }finally{
            // 关闭资源
            try{
                if(stmt!=null) {
                    stmt.close();
                }
            }catch(SQLException se2){
            }// 什么都不做
        }
        return result;
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
