package basics.b9;


import javax.servlet.*;
import java.io.IOException;

/**
 * 一个古老的Servlet，但是有了MVC的味道
 * @author zhuzh
 * @date 2020.08.02
 */
public class LoginServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        try {
            //将数据查询逻辑移动到了model层
            User user = new User(username);
            //代码执行到这里，user不会为空，否则会抛出异常
            //校验业务逻辑写到了Servlet程序中的service方法中
            String result = "user check result="+ password.equals(user.getPassword());
            System.out.println(result);
            servletResponse.getWriter().println(result);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
            servletResponse.getWriter().println(e.getMessage());
        }

    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
