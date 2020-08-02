package basics.b8;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 用户实体
 * @author zhuzhenxi
 * @date 2020.08.02
 */
public class User {
    private int id;
    private String username;
    private String password;

    /**
     * 用户实体构造方法，通过用户名查询用户，如果用户不存在，就抛出异常
     * @param username
     * @throws IllegalArgumentException
     */
    public User(String username) throws IllegalArgumentException {
        this.username = username;
        //查询并设置数据
        this.queryUser();
        if (password==null){
            throw new IllegalArgumentException("user not found");
        }
    }




    /**
     * 用户数据查询
     * @return
     */
    private void queryUser() {
        Statement stmt = null;
        try{
            stmt = DBUtil.getConnection().createStatement();
            String sql = "SELECT id, username, password FROM t_user where username="+username;
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                int id  = rs.getInt("id");
                setId(id);
                String name = rs.getString("username");
                String realPassWord = rs.getString("password");
                setPassword(realPassWord);
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
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
