package basics.b7;

import javax.servlet.*;
import java.io.IOException;

/**
 * 一个古老的Servlet
 * @author zhuzh
 * @date 2020.07.28
 */
public class LoginServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        String driver = servletConfig.getInitParameter("JDBC_DRIVER");
        String url = servletConfig.getInitParameter("JDBC_URL");
        String user = servletConfig.getInitParameter("JDBC_USER");
        String password = servletConfig.getInitParameter("JDBC_PASSWORD");
        DBUtil.prepare(driver,url,user,password);
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String username = servletRequest.getParameter("username");
        String password = servletRequest.getParameter("password");
        servletResponse.getWriter().println("user check result="+DBUtil.getInstance().checkUser(username,password));
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        DBUtil.getInstance().destroy();
    }
}
