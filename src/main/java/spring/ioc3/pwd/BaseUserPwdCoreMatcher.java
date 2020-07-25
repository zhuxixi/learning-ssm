package spring.ioc3.pwd;

public abstract class BaseUserPwdCoreMatcher {

    /**
     * 传工号和密码比较
     * @param saleNo
     * @param pwd
     * @return
     */
    public abstract boolean check(String saleNo,String pwd);
}
